package genesis.api;

import genesis.bean.GenesisBean;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import genesis.manager.GenesisManager;
import genesis.util.constant.GenesisConstants;
import genesis.util.page.PageEntityLinkHelper;
import genesis.util.page.PageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.validation.BindingResult;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.stream.Collectors;

/**
 * Default implementation of {@link BaseReadService}.
 *
 * @author GansaleZz
 */
public abstract class GenesisReadService<T extends GenesisResponseDTO, K extends GenesisBean, S extends GenesisParametersContainer, L extends GenesisHibernateQueryCriteria<K>>
        implements BaseReadService<T, K, S> {

    @Autowired(required = false)
    protected GenesisManager<K> genesisManager;

    @Autowired(required = false)
    protected BaseResponseDTOTransformer<T, K> baseResponseDTOTransformer;

    @Autowired(required = false)
    protected BaseParametersContainerTransformer<S, L> baseParametersContainerTransformer;

    @Autowired
    protected PageEntityLinkHelper pageEntityLinkHelper;

    @Override
    public EntityModel<T> findByID(long ID) {
        return EntityModel.of(baseResponseDTOTransformer.transformEntityToResponseDTO(genesisManager.findByID(ID)));
    }

    @Override
    public CollectionModel<EntityModel<T>> findAll(@Valid PageFilter pageFilter, S container, BindingResult bindingResult) {
        Link selfLink = Link.of(WebMvcLinkBuilder.linkTo(this.getClass())
                .toString());;

        Link selfLinkWithParams = Link.of(UriComponentsBuilder.fromUri(selfLink.toUri())
                .queryParams(pageEntityLinkHelper.getParametersFromParametersContainerAndPageFilter(container, pageFilter))
                .build(true)
                .toString());

        CollectionModel<EntityModel<T>> result = CollectionModel.of(baseResponseDTOTransformer.transformEntitiesToResponseDTOs(genesisManager.findAll(
                                PageRequest.of(pageFilter.getPage(), pageFilter.getItems()),
                                baseParametersContainerTransformer.transformParametersContainerToHibernateQueryCriteria(container)))
                        .stream()
                        .map(EntityModel::of)
                        .collect(Collectors.toList()),
                selfLinkWithParams);

        pageFilter.setCount(genesisManager.count());

        createPageLinks(pageFilter, selfLink, result);

        return result;
    }

    protected void createPageLinks(PageFilter pageFilter, Link link, CollectionModel<EntityModel<T>> result) {
        if (!(pageFilter.getItems() == GenesisConstants.INTEGER_MAX)) {
            pageEntityLinkHelper.createNextPageLink(pageFilter, link)
                    .ifPresent(result::add);
            pageEntityLinkHelper.createPreviousPageLink(pageFilter, link)
                    .ifPresent(result::add);
            pageEntityLinkHelper.createFirstPageLink(pageFilter, link)
                    .ifPresent(result::add);
            pageEntityLinkHelper.createLastPageLink(pageFilter, link)
                    .ifPresent(result::add);
        }
    }
}
