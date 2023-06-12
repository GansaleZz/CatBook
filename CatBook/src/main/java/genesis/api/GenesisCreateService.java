package genesis.api;

import genesis.bean.GenesisBean;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Default implementation of {@link BaseCreateService}.
 *
 * @author GansaleZz
 */
public abstract class GenesisCreateService<T extends GenesisResponseDTO, K extends GenesisRequestDTO, S extends GenesisBean, L extends GenesisParametersContainer, M extends GenesisHibernateQueryCriteria<S>>
        extends GenesisReadService<T, S, L, M> implements BaseCreateService<T, K> {

    @Autowired(required = false)
    private BaseRequestResponseDTOTransformer<T, K, S> baseRequestTransformerDTO;

    @Override
    public T save(K k) {
        S s = baseRequestTransformerDTO.transformRequestDTOToEntity(k);

        return baseRequestTransformerDTO.transformEntityToResponseDTO(genesisManager.save(s));
    }

    @Override
    public T remove(K k) {
        S s = baseRequestTransformerDTO.transformRequestDTOToEntity(k);

        return baseRequestTransformerDTO.transformEntityToResponseDTO(genesisManager.remove(s));
    }
}
