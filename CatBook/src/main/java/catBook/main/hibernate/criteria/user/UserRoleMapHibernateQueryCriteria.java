package catBook.main.hibernate.criteria.user;

import catBook.main.bean.user.UserRoleMap;
import genesis.hibernate.criteria.Criteria;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import genesis.util.constant.GenesisConstants;
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
    private Long userID = GenesisConstants.EMPTY_LONG;

    @Criteria(name = "userRoleID")
    private Long userRoleID = GenesisConstants.EMPTY_LONG;
}
