package genesis.api;

import genesis.bean.GenesisBean;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import genesis.manager.GenesisManager;
import genesis.util.page.PageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.stream.Collectors;

@PreAuthorize("hasClientRole()")
public abstract class GenesisReadService<T extends GenesisResponseDTO, K extends GenesisBean>
        implements BaseReadService<T, K> {

    @Autowired(required = false)
    protected GenesisManager<K> manager;

    @Autowired(required = false)
    protected BaseResponseDTOTransformer<T, K> transformer;

    @Override
    public EntityModel<T> findByID(long ID) {
        return EntityModel.of(transformer.transformToResponseDTO(manager.findByID(ID)));
    }

    @Override
    public CollectionModel<EntityModel<T>> findAll(PageFilter pageFilter, GenesisHibernateQueryCriteria<K> criteria) {
        return CollectionModel.of(transformer.transformToResponseDTOs(manager.findAll(
                        PageRequest.of(pageFilter.getPage(), pageFilter.getItems()),
                        criteria))
                .stream()
                .map(EntityModel::of)
                .collect(Collectors.toList()));
    }
}
