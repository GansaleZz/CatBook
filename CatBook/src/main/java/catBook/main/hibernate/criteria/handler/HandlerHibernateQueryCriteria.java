package catBook.main.hibernate.criteria.handler;

import catBook.main.bean.handler.Handler;
import genesis.hibernate.criteria.Criteria;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import genesis.util.constant.GenesisConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HandlerHibernateQueryCriteria extends GenesisHibernateQueryCriteria<Handler> {

    @Criteria(name = "handlerName")
    private String handlerName = null;

    @Criteria(name = "handlerType")
    private Long handlerTypeID = GenesisConstants.EMPTY_LONG;

    @Override
    public Class<Handler> getBeanClass() {
        return Handler.class;
    }
}
