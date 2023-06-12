package catBook.main.hibernate.criteria.user;

import catBook.main.bean.user.UserRoleMap;
import genesis.hibernate.criteria.Criteria;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleMapHibernateQueryCriteria extends GenesisHibernateQueryCriteria<UserRoleMap> {

    @Override
    public Class<UserRoleMap> getBeanClass() {
        return UserRoleMap.class;
    }

    @Criteria(name = "userID")
    private long userID;

    @Criteria(name = "userRoleID")
    private long userRoleID;
}
