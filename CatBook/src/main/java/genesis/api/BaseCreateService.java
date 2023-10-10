package genesis.api;

import genesis.bean.GenesisBean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Default methods for create/update and remove entity.
 *
 * @author GansaleZz
 */
public interface BaseCreateService<T extends GenesisResponseDTO, K extends GenesisBean, S extends GenesisRequestDTO>
        extends BaseReadService<T, K> {

    @PostMapping({"/", ""})
    T save(@RequestBody S s);

    @DeleteMapping({"/", ""})
    T remove(S s);

    void beforeSave(S s);
}
