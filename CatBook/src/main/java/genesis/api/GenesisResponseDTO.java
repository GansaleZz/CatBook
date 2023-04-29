package genesis.api;

import genesis.bean.GenesisBean;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.time.LocalDateTime;

/**
 * Parent ResponseDTO which contain common fields for all ResponseDTO's.
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

    protected abstract Class<? extends BaseReadService<? extends GenesisResponseDTO,
            ? extends GenesisBean,
            ? extends GenesisParametersContainer>> getServiceClass();

    public void setID(long ID) {
        this.ID = ID;

        add(WebMvcLinkBuilder.linkTo(getServiceClass()).slash(ID).withSelfRel());
    }
}
