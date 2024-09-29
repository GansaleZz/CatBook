package genesis.api;

import genesis.bean.GenesisBean;

import java.util.List;

public abstract class GenesisResponseDTOTransformer<T extends GenesisResponseDTO, K extends GenesisBean>
        implements BaseResponseDTOTransformer<T,K> {

    protected abstract Class<T> getResponseDTOClass();

    @Override
    public T transformToResponseDTO(K k) {
        if (k != null) {
            try {
                T t = getResponseDTOClass().getDeclaredConstructor().newInstance();

                t.setID(k.getID());
                t.setCreatedByID(k.getCreatedByID());
                t.setCreatedDate(k.getCreatedDate());
                t.setModifiedByID(k.getModifiedByID());
                t.setModifiedDate(k.getModifiedDate());
                t.setActive(k.isActive());

                transformCustomData(t, k);

                return t;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }

    @Override
    public List<T> transformToResponseDTOs(List<K> list) {
        return list.stream()
                .map(this::transformToResponseDTO)
                .toList();
    }

    protected abstract void transformCustomData(T t, K k);
}
