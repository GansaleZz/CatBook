package genesis.hibernate.DAO;

import genesis.bean.GenesisBean;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteriaBuilder;
import genesis.util.constant.GenesisConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class GenesisHibernateBeanDAO<T extends GenesisBean> extends BaseBeanHibernateBeanDAO<T> {

    @Autowired
    protected GenesisHibernateQueryCriteriaBuilder hibernateQueryCriteriaBuilder;

    @Override
    public T findSingleByCriteria(GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria) {
        return findAll(genesisHibernateQueryCriteria).stream().findFirst().orElse(null);
    }

    @Override
    public List<T> findAll(GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria) {
        Pageable pageable = PageRequest.of(0, GenesisConstants.INTEGER_MAX, Sort.by(Sort.Direction.ASC, "ID"));

        return findAll(pageable, genesisHibernateQueryCriteria);
    }

    @Override
    public List<T> findAll(Sort sort, GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria) {
        Pageable pageable = PageRequest.of(0, GenesisConstants.INTEGER_MAX, sort);

        return findAll(pageable, genesisHibernateQueryCriteria);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll(Pageable pageable, GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria) {
        Query query = hibernateQueryCriteriaBuilder.createQuery(genesisHibernateQueryCriteria, pageable.getSort());

        return query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize())
                .setMaxResults(pageable.getPageSize())
                .getResultList();
    }
}
