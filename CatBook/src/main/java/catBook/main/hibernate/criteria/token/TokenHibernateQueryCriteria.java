package catBook.main.hibernate.criteria.token;

import catBook.main.bean.token.Token;
import genesis.hibernate.criteria.Criteria;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenHibernateQueryCriteria extends GenesisHibernateQueryCriteria<Token> {

    @Override
    public Class<Token> getBeanClass() {
        return Token.class;
    }

    @Criteria(name = "tokenName")
    private String tokenName = null;

    @Criteria(name = "tokenValue")
    private String tokenValue = null;
}
