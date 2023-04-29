package genesis.util.page;

import genesis.api.GenesisParametersContainer;
import genesis.util.constant.GenesisConstants;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Creator of links for paginating.
 *
 * @author GansaleZz
 */
@Component
public class PageEntityLinkHelper {

    private static final String PAGE = "page";
    private static final String ITEMS = "items";
    private static final String NEXT = "next";
    private static final String PREVIOUS = "previous";
    private static final String FIRST = "first";
    private static final String LAST = "last";

    public MultiValueMap<String, String> getParametersFromParametersContainerAndPageFilter(GenesisParametersContainer container,
                                                                                           PageFilter pageFilter) {
        MultiValueMap<String, String> resultMap = new LinkedMultiValueMap<>();

        try {
            for (Field field : getAllDeclaredFieldsFromCriteria(container)) {
                field.setAccessible(true);

                if (isFieldPopulated(field, container)) {
                    resultMap.add(field.getName(), String.valueOf(field.get(container)));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if (pageFilter.getItems() != GenesisConstants.INTEGER_MAX) {
            resultMap.addAll(getPageFilterParameters(pageFilter));
        }

        return resultMap;
    }

    /**
     * Sets pagination parameters as map values.
     *
     * @param pageFilter object which contains information about pagination.
     * @return resulting map.
     */
    public MultiValueMap<String, String> getPageFilterParameters(PageFilter pageFilter) {
        MultiValueMap<String, String> pagingParameters = new LinkedMultiValueMap<>();

        pagingParameters.add(PAGE, String.valueOf(pageFilter.getPage()));
        pagingParameters.add(ITEMS, String.valueOf(pageFilter.getItems()));

        return pagingParameters;
    }

    /**
     * Creates link on next page.
     *
     * @param pageFilter object which contains information about pagination.
     * @param link to getting list of entities.
     * @return link on next page if current page is not last.
     */
    public Optional<Link> createNextPageLink(PageFilter pageFilter, Link link) {
        return createNewLink(link, provideNextPage(pageFilter), NEXT);
    }

    /**
     * Creates link on previous page.
     *
     * @param pageFilter object which contains information about pagination.
     * @param link to getting list of entities.
     * @return link on previous page if current page is not first.
     */
    public Optional<Link> createPreviousPageLink(PageFilter pageFilter, Link link) {
        return createNewLink(link, providePreviousPage(pageFilter), PREVIOUS);
    }

    /**
     * Creates link on first page.
     *
     * @param pageFilter object which contains information about pagination.
     * @param link to getting list of entities.
     * @return link on first page if current page is not first.
     */
    public Optional<Link> createFirstPageLink(PageFilter pageFilter, Link link) {
        return createNewLink(link, provideFirstPage(pageFilter), FIRST);
    }

    /**
     * Creates link on last page.
     *
     * @param pageFilter object which contains information about pagination.
     * @param link to getting list of entities.
     * @return link on last page if current page is not last.
     */
    public Optional<Link> createLastPageLink(PageFilter pageFilter, Link link) {
        return createNewLink(link, provideLastPage(pageFilter), LAST);
    }

    private Optional<PageFilter> provideNextPage(PageFilter pageFilter) {
        int countOfPages = calculateCountOfPages(pageFilter);

        if (pageFilter.getPage() < countOfPages) {
            return Optional.of(PageFilter.builder()
                    .page(pageFilter.getPage() + 1)
                    .items(pageFilter.getItems())
                    .build());
        } else {
            return Optional.empty();
        }
    }

    private Optional<PageFilter> providePreviousPage(PageFilter pageFilter) {
        int maxPages = calculateCountOfPages(pageFilter);

        if (pageFilter.getPage() > 0 &&
                pageFilter.getPage() <= maxPages) {
            return Optional.of(PageFilter.builder()
                    .page(pageFilter.getPage()-1)
                    .items(pageFilter.getItems())
                    .build());
        } else {
            return Optional.empty();
        }
    }

    private Optional<PageFilter> provideFirstPage(PageFilter pageFilter) {
        if (pageFilter.getPage() !=0) {
            return Optional.of(PageFilter.builder()
                    .page(0)
                    .items(pageFilter.getItems())
                    .build());
        } else {
            return Optional.empty();
        }
    }

    private Optional<PageFilter> provideLastPage(PageFilter pageFilter) {
        int countOfPages = calculateCountOfPages(pageFilter);

        if (pageFilter.getPage() < countOfPages) {
            return Optional.of(PageFilter.builder()
                    .page(countOfPages)
                    .items(pageFilter.getItems())
                    .build());
        } else {
            return Optional.empty();
        }
    }

    private int calculateCountOfPages(PageFilter pageFilter) {
        int countOfPages = (int) pageFilter.getCount() / pageFilter.getItems() - 1;
        if (pageFilter.getCount() % pageFilter.getItems() > 0) {
            countOfPages ++;
        }

        return countOfPages;
    }

    private Optional<Link> createNewLink(Link link, Optional<PageFilter> newPageFilter, String rel) {
        Optional<Link> newPageLink = Optional.empty();

        if (newPageFilter.isPresent()) {
            newPageLink = Optional.of(Link.of(UriComponentsBuilder.fromUri(link.toUri())
                            .replaceQueryParam(PAGE, newPageFilter.get().getPage())
                            .replaceQueryParam(ITEMS, newPageFilter.get().getItems())
                            .build(true)
                            .toString())
                    .withRel(rel));
        }

        return newPageLink;
    }

    private List<Field> getAllDeclaredFieldsFromCriteria(GenesisParametersContainer container) {
        List<Field> fields = new LinkedList<>();
        fields.addAll(List.of(container.getClass().getSuperclass().getDeclaredFields()));
        fields.addAll(List.of(container.getClass().getDeclaredFields()));

        return fields;
    }

    private boolean isFieldPopulated(Field field, GenesisParametersContainer container)
            throws IllegalAccessException {
        return (field.getType() == Long.class && !field.get(container).equals(GenesisConstants.EMPTY_LONG)) ||
                (field.getType() == String.class && field.get(container) != null) ||
                (field.getType() == LocalDateTime.class && !field.get(container).equals(GenesisConstants.DATE_MAX)) ||
                (field.getType() == Boolean.class && field.get(container) != null);
    }
}
