package catBook.api.transformer.notification;

import catBook.api.transformer.notification.container.NotificationParametersContainer;
import catBook.main.hibernate.criteria.notification.NotificationHibernateQueryCriteria;
import genesis.api.BaseParametersContainerTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationParametersContainerTransformer extends BaseParametersContainerTransformer<NotificationParametersContainer,
        NotificationHibernateQueryCriteria> {
}
