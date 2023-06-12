package catBook.api.transformer.notification;

import catBook.api.transformer.notification.container.NotificationTypeParametersContainer;
import catBook.main.hibernate.criteria.notification.NotificationTypeHibernateQueryCriteria;
import genesis.api.BaseParametersContainerTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationTypeParametersContainerTransformer extends BaseParametersContainerTransformer<NotificationTypeParametersContainer,
        NotificationTypeHibernateQueryCriteria> {
}
