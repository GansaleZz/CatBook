package catBook.main.hibernate.DAO.user;

import catBook.main.bean.user.User;
import genesis.hibernate.DAO.GenesisHibernateBeanDAO;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultUserDAO extends GenesisHibernateBeanDAO<User> {

}
