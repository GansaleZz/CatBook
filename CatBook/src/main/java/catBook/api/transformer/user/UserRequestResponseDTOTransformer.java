package catBook.api.transformer.user;

import catBook.api.DTO.user.UserRequestDTO;
import catBook.api.DTO.user.UserResponseDTO;
import catBook.main.bean.user.User;
import genesis.api.BaseRequestResponseDTOTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestResponseDTOTransformer extends BaseRequestResponseDTOTransformer<UserResponseDTO, UserRequestDTO, User> {

}
