package catBook.api.transformer.notification;

import catBook.api.transformer.notification.container.NotificationSubTypeParametersContainer;
import catBook.main.hibernate.criteria.notification.NotificationSubTypeHibernateQueryCriteria;
import genesis.api.BaseParametersContainerTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationSubTypeParametersContainerTransformer extends BaseParametersContainerTransformer<NotificationSubTypeParametersContainer,
        NotificationSubTypeHibernateQueryCriteria> {
}
