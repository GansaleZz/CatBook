package genesis.api;

import genesis.bean.GenesisBean;

/**
 * Methods for map EntityResponseDTO and Entity to EntityRequestDTO or vise versa.
 *
 * @author GansaleZz
 */
public interface BaseRequestResponseTransformerDTO<T extends GenesisResponseDTO, K extends GenesisRequestDTO, S extends GenesisBean>
        extends BaseResponseTransformerDTO<T, S> {

    S transformRequestDTOToEntity(K k);
}
