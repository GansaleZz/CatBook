package catBook.api.transformer.user;

import catBook.api.DTO.user.UserRoleResponseDTO;
import catBook.main.bean.UserRole;
import genesis.api.BaseResponseTransformerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRoleResponseTransformerDTO extends BaseResponseTransformerDTO<UserRoleResponseDTO, UserRole> {

}
