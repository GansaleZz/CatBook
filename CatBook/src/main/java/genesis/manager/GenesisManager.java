package genesis.manager;

import genesis.bean.GenesisBean;
import genesis.hibernate.DAO.GenesisHibernateBeanDAO;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

/**
 * Default implementation of {@link BaseBeanManager}.
 *
 * @author GansaleZz
 */
@Setter
@Log4j2
public abstract class GenesisManager<T extends GenesisBean> implements BaseBeanManager<T> {

    @Autowired
    private GenesisHibernateBeanDAO<T> dao;

    @Override
    public T findByID(long ID) {
        return dao.findByID(ID);
    }

    @Override
    public List<T> findAll() {
        return dao.findAll();
    }

    @Override
    public List<T> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public List<T> findAll(Sort sort) {
        return dao.findAll(sort);
    }

    @Override
    public T findSingleByCriteria(GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria) {
        return dao.findSingleByCriteria(genesisHibernateQueryCriteria);
    }

    @Override
    public List<T> findAll(GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria) {
        return dao.findAll(genesisHibernateQueryCriteria);
    }

    @Override
    public List<T> findAll(Sort sort, GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria) {
        return dao.findAll(sort, genesisHibernateQueryCriteria);
    }

    @Override
    public List<T> findAll(Pageable pageable, GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria) {
        return dao.findAll(pageable, genesisHibernateQueryCriteria);
    }

    @Override
    @Transactional
    public T save(T t) {
        return dao.save(t);
    }

    @Override
    @Transactional
    public List<T> saveAll(List<T> t) {
        return dao.saveAll(t);
    }

    @Override
    public T remove(T t) {
        removeDependencies(t);

        t.setActive(false);

        return save(t);
    }

    @Override
    public void delete(long ID) {
        dao.delete(ID);
    }

    @Override
    public long count() {
        return dao.count();
    }

    protected void removeDependencies(T t) {

    }
}
