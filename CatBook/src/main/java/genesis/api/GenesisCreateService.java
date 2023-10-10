package genesis.api;

import genesis.bean.GenesisBean;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Default implementation of {@link BaseCreateService}.
 *
 * @author GansaleZz
 */
@PreAuthorize("hasClientRole()")
public abstract class GenesisCreateService<T extends GenesisResponseDTO, K extends GenesisRequestDTO, S extends GenesisBean, L extends GenesisParametersContainer, M extends GenesisHibernateQueryCriteria<S>>
        extends GenesisReadService<T, S, L, M> implements BaseCreateService<T, K> {

    @Autowired(required = false)
    private BaseRequestResponseDTOTransformer<T, K, S> baseRequestTransformerDTO;

    @Autowired
    private GenesisServiceValidator<K> serviceValidator;

    @Override
    public T save(K k) {
        beforeSave(k);

        S s = baseRequestTransformerDTO.transformRequestDTOToEntity(k);

        s = genesisManager.save(s);

        afterSave(k);

        return baseRequestTransformerDTO.transformEntityToResponseDTO(s);
    }

    @Override
    public T remove(K k) {
        S s = baseRequestTransformerDTO.transformRequestDTOToEntity(k);

        return baseRequestTransformerDTO.transformEntityToResponseDTO(genesisManager.remove(s));
    }

    public void beforeSave(K k) {
        serviceValidator.validate(k);
    }

    public void afterSave(K k) {

    }
}
