package catBook.api.service.token;

import catBook.api.DTO.token.TokenResponseDTO;
import catBook.api.transformer.token.container.TokenParametersContainer;
import catBook.main.bean.token.Token;
import catBook.main.hibernate.criteria.token.TokenHibernateQueryCriteria;
import genesis.api.GenesisReadService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultTokenService extends GenesisReadService<TokenResponseDTO, Token, TokenParametersContainer,
        TokenHibernateQueryCriteria> implements TokenService {
}
