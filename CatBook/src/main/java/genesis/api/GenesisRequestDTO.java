package genesis.api;

import lombok.Getter;
import lombok.Setter;

/**
 * Parent RequestDTO which contain common fields for all RequestDTO's.
 *
 * @author GansaleZz
 */
@Getter
@Setter
public abstract class GenesisRequestDTO {

    private boolean active = true;
}
