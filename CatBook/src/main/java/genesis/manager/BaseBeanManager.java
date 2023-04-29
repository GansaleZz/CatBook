package genesis.manager;

import genesis.bean.GenesisBean;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Default methods for all managers.
 *
 * @author GansaleZz
 */
public interface BaseBeanManager<T extends GenesisBean> {

    T findByID(long ID);

    List<T> findAll();

    List<T> findAll(Pageable pageable);

    List<T> findAll(Sort sort);

    T findSingleByCriteria(GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria);

    List<T> findAll(GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria);

    List<T> findAll(Sort sort, GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria);

    List<T> findAll(Pageable pageable, GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria);

    T save(T t);

    List<T> saveAll(List<T> t);

    T remove(T t);

    void delete(long ID);

    long count();
}
