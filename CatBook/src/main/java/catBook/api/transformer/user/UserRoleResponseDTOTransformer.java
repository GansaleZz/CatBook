package catBook.api.transformer.user;

import catBook.api.DTO.user.UserRoleResponseDTO;
import catBook.main.bean.user.UserRole;
import genesis.api.BaseResponseDTOTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRoleResponseDTOTransformer extends BaseResponseDTOTransformer<UserRoleResponseDTO, UserRole> {

}
