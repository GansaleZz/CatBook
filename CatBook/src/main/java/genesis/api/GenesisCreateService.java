package genesis.api;

import genesis.bean.GenesisBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Default implementation of {@link BaseCreateService}.
 *
 * @author GansaleZz
 */
@PreAuthorize("hasClientRole()")
public abstract class GenesisCreateService<T extends GenesisResponseDTO, K extends GenesisBean, S extends GenesisRequestDTO>
        extends GenesisReadService<T, K> implements BaseCreateService<T, K, S> {

    @Autowired
    private GenesisServiceValidator<S> validator;

    @Override
    public T save(S s) {
        beforeSave(s);

        K k = doSave(s);

        return transformer.transformToResponseDTO(k);
    }

    protected K doSave(S s) {
        throw new RuntimeException("Save service method is not implemented!");
    }

    @Override
    public T remove(S s) {

        K k = doRemove(s);

        return transformer.transformToResponseDTO(k);
    }

    protected K doRemove(S s) {
        throw new RuntimeException("Remove service method is not implemented!");
    }

    public void beforeSave(S s) {
        validator.validate(s);
    }
}
