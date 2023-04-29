package catBook.api.transformer.user;

import catBook.api.DTO.user.UserRoleMapRequestDTO;
import catBook.api.DTO.user.UserRoleMapResponseDTO;
import catBook.main.bean.UserRoleMap;
import genesis.api.BaseRequestResponseTransformerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRoleMapResponseTransformerDTO
        extends BaseRequestResponseTransformerDTO<UserRoleMapResponseDTO, UserRoleMapRequestDTO, UserRoleMap> {

}
