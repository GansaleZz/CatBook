package genesis.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Default methods for create/update and remove entity.
 *
 * @author GansaleZz
 */
public interface BaseCreateService<T extends GenesisResponseDTO, K extends GenesisRequestDTO> {

    @PostMapping("/")
    T save(@RequestBody K k);

    @DeleteMapping("/")
    T remove(K k);
}
