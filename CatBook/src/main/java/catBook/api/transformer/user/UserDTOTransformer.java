package catBook.api.transformer.user;

import catBook.api.DTO.user.UserResponseDTO;
import catBook.main.bean.user.User;
import genesis.api.BaseResponseDTOTransformer;

public interface UserDTOTransformer extends BaseResponseDTOTransformer<UserResponseDTO, User> {
}
