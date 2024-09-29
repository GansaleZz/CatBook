package catBook.main.hibernate.criteria.user;

import catBook.main.bean.user.User;
import genesis.hibernate.criteria.Criteria;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserHibernateQueryCriteria extends GenesisHibernateQueryCriteria<User> {

    @Override
    public Class<User> getBeanClass() {
        return User.class;
    }

    @Criteria(name = "userName")
    private String userName;

    @Criteria(name = "displayName")
    private String displayName;
}
