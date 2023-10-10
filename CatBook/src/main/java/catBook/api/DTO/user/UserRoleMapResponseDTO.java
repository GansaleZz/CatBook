package catBook.api.DTO.user;

import genesis.api.GenesisResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleMapResponseDTO extends GenesisResponseDTO {

    private UserResponseDTO user;

    private UserRoleResponseDTO userRole;
}
