package genesis.api;

import genesis.bean.GenesisBean;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.time.LocalDateTime;

/**
 * Parent ResponseDTO which contains common fields for all ResponseDTOs.
 *
 * @author GansaleZz
 */
@Setter
@Getter
public abstract class GenesisResponseDTO extends RepresentationModel<GenesisResponseDTO> {

    private long ID;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    private long createdByID;

    private long modifiedByID;

    private boolean active;
}
