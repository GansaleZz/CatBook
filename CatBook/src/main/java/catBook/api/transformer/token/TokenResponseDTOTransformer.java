package catBook.api.transformer.token;

import catBook.api.DTO.token.TokenResponseDTO;
import catBook.main.bean.token.Token;
import genesis.api.BaseResponseDTOTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TokenResponseDTOTransformer extends BaseResponseDTOTransformer<TokenResponseDTO, Token> {
}
