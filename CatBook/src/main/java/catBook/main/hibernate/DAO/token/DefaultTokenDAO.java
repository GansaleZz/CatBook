package catBook.main.hibernate.DAO.token;

import catBook.main.bean.token.Token;
import catBook.main.hibernate.criteria.token.TokenHibernateQueryCriteria;
import genesis.hibernate.DAO.GenesisHibernateBeanDAO;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultTokenDAO extends GenesisHibernateBeanDAO<Token> {
}
