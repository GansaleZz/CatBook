package catBook.api.service.token;

import catBook.api.DTO.token.TokenResponseDTO;
import catBook.api.transformer.token.container.TokenParametersContainer;
import catBook.main.bean.token.Token;
import genesis.api.BaseReadService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/tokens")
public interface TokenService extends BaseReadService<TokenResponseDTO, Token, TokenParametersContainer> {
}
