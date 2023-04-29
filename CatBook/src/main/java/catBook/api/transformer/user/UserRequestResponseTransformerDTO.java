package catBook.api.transformer.user;

import catBook.api.DTO.user.UserRequestDTO;
import catBook.api.DTO.user.UserResponseDTO;
import catBook.main.bean.User;
import genesis.api.BaseRequestResponseTransformerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestResponseTransformerDTO extends BaseRequestResponseTransformerDTO<UserResponseDTO, UserRequestDTO, User> {

}
