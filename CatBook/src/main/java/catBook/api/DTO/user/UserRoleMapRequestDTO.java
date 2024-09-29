package catBook.api.DTO.user;

import genesis.api.GenesisRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleMapRequestDTO extends GenesisRequestDTO {

    private Long userRoleMapID;

    private Long userID;
    
    private Long userRoleID;
}
