package genesis.manager;

import genesis.bean.GenesisBean;
import genesis.hibernate.DAO.GenesisHibernateBeanDAO;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Default implementation of {@link BaseBeanManager}.
 *
 * @author GansaleZz
 */
@Setter
public abstract class GenesisManager<T extends GenesisBean> implements BaseBeanManager<T> {

    @Autowired
    protected GenesisHibernateBeanDAO<T> genesisHibernateBeanDAO;

    @Override
    public T findByID(long ID) {
        return genesisHibernateBeanDAO.findByID(ID);
    }

    @Override
    public List<T> findAll() {
        return genesisHibernateBeanDAO.findAll();
    }

    @Override
    public List<T> findAll(Pageable pageable) {
        return genesisHibernateBeanDAO.findAll(pageable);
    }

    @Override
    public List<T> findAll(Sort sort) {
        return genesisHibernateBeanDAO.findAll(sort);
    }

    @Override
    public T findSingleByCriteria(GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria) {
        return genesisHibernateBeanDAO.findSingleByCriteria(genesisHibernateQueryCriteria);
    }

    @Override
    public List<T> findAll(GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria) {
        return genesisHibernateBeanDAO.findAll(genesisHibernateQueryCriteria);
    }

    @Override
    public List<T> findAll(Sort sort, GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria) {
        return genesisHibernateBeanDAO.findAll(sort, genesisHibernateQueryCriteria);
    }

    @Override
    public List<T> findAll(Pageable pageable, GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria) {
        return genesisHibernateBeanDAO.findAll(pageable, genesisHibernateQueryCriteria);
    }

    @Override
    @Transactional
    public T save(T t) {
        return genesisHibernateBeanDAO.save(t);
    }

    @Override
    @Transactional
    public List<T> saveAll(List<T> t) {
        return genesisHibernateBeanDAO.saveAll(t);
    }

    @Override
    public T remove(T t) {
        t.setActive(false);

        return save(t);
    }

    @Override
    public void delete(long ID) {
        T t = findByID(ID);

        genesisHibernateBeanDAO.delete(ID);
    }

    @Override
    public long count() {
        return genesisHibernateBeanDAO.count();
    }
}
