package genesis.api;

import genesis.bean.GenesisBean;

import java.util.List;

/**
 * Methods for map EntityResponseDTO to Entity or vise versa.
 *
 * @author GansaleZz
 */
public interface BaseResponseTransformerDTO<T extends GenesisResponseDTO, K extends GenesisBean> {

    T transformEntityToResponseDTO(K k);

    List<T> transformEntitiesToResponseDTOs(List<K> list);

    K transformResponseDTOToEntity(T t);

    List<K> transformResponseDTOsToEntities(List<T> list);
}
