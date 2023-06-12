package catBook.api.transformer.user;

import catBook.api.DTO.user.UserRoleMapRequestDTO;
import catBook.api.DTO.user.UserRoleMapResponseDTO;
import catBook.main.bean.user.UserRoleMap;
import genesis.api.BaseRequestResponseDTOTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRoleMapResponseDTOTransformer
        extends BaseRequestResponseDTOTransformer<UserRoleMapResponseDTO, UserRoleMapRequestDTO, UserRoleMap> {

}
