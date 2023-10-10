package genesis.api;

import genesis.bean.GenesisBean;

import java.util.List;

/**
 * Methods for map {@link GenesisResponseDTO} to {@link GenesisBean} or vise versa.
 *
 * @author GansaleZz
 */
public interface BaseResponseDTOTransformer<T extends GenesisResponseDTO, K extends GenesisBean> {

    T transformToResponseDTO(K k);

    List<T> transformToResponseDTOs(List<K> list);
}
