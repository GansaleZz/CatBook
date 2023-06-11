package genesis.hibernate.DAO;

import genesis.bean.GenesisBean;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 *
 * @author GansaleZz
 */
public abstract class BaseBeanHibernateBeanDAO<T extends GenesisBean> {

    @Autowired
    private BaseBeanDAO<T> baseBeanDAO;

    public abstract T findSingleByCriteria(GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria);

    public abstract List<T> findAll(GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria);

    public abstract List<T> findAll(Sort sort, GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria);

    public abstract List<T> findAll(Pageable pageable, GenesisHibernateQueryCriteria<T> genesisHibernateQueryCriteria);

    public List<T> findAll() {
        return IterableUtils.toList(baseBeanDAO.findAll());
    }

    public List<T> findAll(Pageable pageable) {
        return IterableUtils.toList(baseBeanDAO.findAll(pageable));
    }

    public List<T> findAll(Sort sort) {
        return IterableUtils.toList(baseBeanDAO.findAll(sort));
    }

    public T findByID(long ID) {
        return baseBeanDAO.findById(ID).orElse(null);
    }

    @Transactional
    public T save(T t) {
        return baseBeanDAO.save(t);
    }

    public List<T> saveAll(List<T> tList) {
        return IterableUtils.toList(baseBeanDAO.saveAll(tList));
    }

    public void delete(long ID) {
        baseBeanDAO.deleteById(ID);
    }

    public T remove(T t) {
        t.setActive(false);

        return baseBeanDAO.save(t);
    }

    public long count() {
        return baseBeanDAO.count();
    }
}
