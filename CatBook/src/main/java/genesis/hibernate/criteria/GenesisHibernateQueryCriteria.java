package genesis.hibernate.criteria;

import genesis.bean.GenesisBean;
import genesis.util.constant.GenesisConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class GenesisHibernateQueryCriteria<T extends GenesisBean> {

    public abstract Class<T> getBeanClass();

    @Criteria(name = "ID")
    private Long ID = GenesisConstants.EMPTY_LONG;

    @Criteria(name = "modifiedByID")
    private Long modifiedByID = GenesisConstants.EMPTY_LONG;

    @Criteria(name = "createdByID")
    private Long createdByID = GenesisConstants.EMPTY_LONG;

    @Criteria(name = "active")
    private Boolean active = null;
}
