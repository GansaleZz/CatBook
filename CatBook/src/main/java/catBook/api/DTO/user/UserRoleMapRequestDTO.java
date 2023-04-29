package catBook.api.DTO.user;

import genesis.api.GenesisRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleMapRequestDTO extends GenesisRequestDTO {

    private long userID;
    
    private long userRoleID;
}
