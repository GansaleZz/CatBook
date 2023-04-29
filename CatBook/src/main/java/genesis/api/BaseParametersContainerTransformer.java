package genesis.api;

import genesis.bean.GenesisBean;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;


public interface BaseParametersContainerTransformer<T extends GenesisParametersContainer, K extends GenesisHibernateQueryCriteria<? extends GenesisBean>> {

    K transformParametersContainerToHibernateQueryCriteria(T container);
}
