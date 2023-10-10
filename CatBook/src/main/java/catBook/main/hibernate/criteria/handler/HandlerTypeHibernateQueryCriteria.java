package catBook.main.hibernate.criteria.handler;

import catBook.main.bean.handler.HandlerType;
import genesis.hibernate.criteria.Criteria;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HandlerTypeHibernateQueryCriteria extends GenesisHibernateQueryCriteria<HandlerType> {

    @Criteria(name = "handlerTypeName")
    private String handlerTypeName = null;

    @Override
    public Class<HandlerType> getBeanClass() {
        return HandlerType.class;
    }
}
