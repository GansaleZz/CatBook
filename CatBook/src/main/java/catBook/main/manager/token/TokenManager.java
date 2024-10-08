package catBook.main.manager.token;

import catBook.main.bean.token.Token;
import genesis.manager.GenesisManager;

public abstract class TokenManager extends GenesisManager<Token> {

    public abstract String processToken(String source);

    public abstract Token findByTokenValue(String tokenValue);
}
