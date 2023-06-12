package catBook.main.hibernate.criteria.user;

import catBook.main.bean.user.UserRole;
import genesis.hibernate.criteria.Criteria;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleHibernateQueryCriteria extends GenesisHibernateQueryCriteria<UserRole> {

    @Override
    public Class<UserRole> getBeanClass() {
        return UserRole.class;
    }

    @Criteria(name = "userRoleName")
    private String userRoleName;
}
