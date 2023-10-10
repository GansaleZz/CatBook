package genesis.api;

import genesis.bean.GenesisBean;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 */
public interface BaseReadService<T extends GenesisResponseDTO, K extends GenesisBean> {

    @GetMapping("/{ID}")
    EntityModel<T> findByID(@PathVariable long ID);

    CollectionModel<EntityModel<T>> findAll(PageFilter pageFilter, GenesisHibernateQueryCriteria<K> criteria);
}
