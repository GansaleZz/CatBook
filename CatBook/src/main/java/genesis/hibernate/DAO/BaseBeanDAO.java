package genesis.hibernate.DAO;

import genesis.bean.GenesisBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Define default DAO methods.
 *
 * @author GansaleZz
 */
@Repository
public interface BaseBeanDAO<T extends GenesisBean> extends PagingAndSortingRepository<T, Long> {

}
