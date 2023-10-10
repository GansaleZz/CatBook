package catBook.api.transformer.user;

import catBook.api.DTO.user.UserRoleMapRequestDTO;
import catBook.api.DTO.user.UserRoleMapResponseDTO;
import catBook.main.bean.user.User;
import catBook.main.bean.user.UserRole;
import catBook.main.bean.user.UserRoleMap;
import genesis.api.BaseRequestResponseDTOTransformer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserRoleMapRequestResponseDTOTransformer
        extends BaseRequestResponseDTOTransformer<UserRoleMapResponseDTO, UserRoleMapRequestDTO, UserRoleMap> {

    @Override
    @Mapping(source = "userID", target = "user", qualifiedByName = "userIDToUserTransformer")
    @Mapping(source = "userRoleID", target = "userRole", qualifiedByName = "userRoleIDToUserRoleTransformer")
    UserRoleMap transformRequestDTOToEntity(UserRoleMapRequestDTO userRoleMapRequestDTO);

    @Named("userIDToUserTransformer")
    static User userIDToUser(long userID) {
        User user = new User();
        user.setID(userID);

        return user;
    }

    @Named("userRoleIDToUserRoleTransformer")
    static UserRole userRoleIDToUserRole(long userRoleID) {
        UserRole userRole = new UserRole();
        userRole.setID(userRoleID);

        return userRole;
    }
}
