package catBook.api.DTO.user;

import genesis.api.GenesisResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleResponseDTO extends GenesisResponseDTO {

    private String userRoleName;
}
