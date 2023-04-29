package genesis.hibernate.criteria;

import genesis.bean.GenesisBean;
import genesis.util.constant.GenesisConstants;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 * @author GansaleZz
 */
@Component
public class GenesisHibernateQueryCriteriaBuilder {

    @PersistenceContext
    protected EntityManager entityManager;

    /**
     * Returns criteria built by fields from criteria instance and ordered by specified sort instance.
     *
     * @param criteria
     */
    @SuppressWarnings("unchecked")
    public Query createQuery(GenesisHibernateQueryCriteria<? extends GenesisBean> criteria, Sort sort) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<? extends GenesisBean> criteriaQuery = criteriaBuilder.createQuery(criteria.getBeanClass());
        Root root = criteriaQuery.from(criteria.getBeanClass());
        criteriaQuery.select(root);
        try {
            List<Predicate> predicates = createConjunctionPredicatesFromCriteriaFields(root, criteria);
            List<Order> orders = createOrderList(sort, criteriaBuilder, root);

            criteriaQuery.where(predicates.toArray(new Predicate[] {}));
            criteriaQuery.orderBy(orders);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return entityManager.createQuery(criteriaQuery);
    }

    /**
     * Returns list of predicates from values of criteria fields.
     *
     * @param criteria
     * @return
     * @throws IllegalAccessException
     */
    private List<Predicate> createConjunctionPredicatesFromCriteriaFields(Root root,
                                                                          GenesisHibernateQueryCriteria<? extends GenesisBean> criteria)
            throws IllegalAccessException {
        List<Predicate> predicates = new ArrayList<>();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        for (Field field : getAllDeclaredFieldsFromCriteria(criteria)) {
            field.setAccessible(true);
            Criteria fieldCriteriaAnnotation = field.getAnnotation(Criteria.class);

            if (fieldCriteriaAnnotation != null && isFieldPopulated(field, criteria)) {
                String criteriaFieldName = fieldCriteriaAnnotation.name();
                Object criteriaFieldValue = field.get(criteria);

                predicates.add(criteriaBuilder.equal(root.get(criteriaFieldName), criteriaFieldValue));
            }
        }

        return predicates;
    }

    /**
     * Returns list of orders from {@link Sort}.
     *
     * @param sort
     * @param criteriaBuilder
     * @param root
     * @return
     */
    private List<Order> createOrderList(Sort sort, CriteriaBuilder criteriaBuilder, Root root) {
        List<Order> orders = new ArrayList<>();

        if (sort.isSorted()) {
            sort.toList().forEach(sortOrder -> {
                if (sortOrder.isAscending()) {
                    orders.add(criteriaBuilder.asc(root.get(sortOrder.getProperty())));
                } else {
                    orders.add(criteriaBuilder.desc(root.get(sortOrder.getProperty())));
                }
            });
        }

        return orders;
    }

    /**
     * Returns list of all declared fields from criteria instance.
     *
     * @param criteria
     * @return
     */
    private List<Field> getAllDeclaredFieldsFromCriteria(GenesisHibernateQueryCriteria<? extends GenesisBean> criteria) {
        List<Field> fields = new LinkedList<>();
        fields.addAll(List.of(criteria.getClass().getSuperclass().getDeclaredFields()));
        fields.addAll(List.of(criteria.getClass().getDeclaredFields()));

        return fields;
    }

    /**
     * Checks if field on criteria instance is populated.
     *
     * @param field
     * @return
     * @throws IllegalAccessException
     */
    private boolean isFieldPopulated(Field field, GenesisHibernateQueryCriteria<? extends GenesisBean> criteria)
            throws IllegalAccessException {
        return (field.getType() == Long.class && !field.get(criteria).equals(GenesisConstants.EMPTY_LONG)) ||
                (field.getType() == String.class && field.get(criteria) != null) ||
                (field.getType() == LocalDateTime.class && !field.get(criteria).equals(GenesisConstants.DATE_MAX)) ||
                (field.getType() == Boolean.class && field.get(criteria) != null);
    }
}
