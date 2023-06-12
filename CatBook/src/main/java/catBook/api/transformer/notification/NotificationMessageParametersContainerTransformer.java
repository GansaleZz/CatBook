package catBook.api.transformer.notification;

import catBook.api.transformer.notification.container.NotificationMessageParametersContainer;
import catBook.main.hibernate.criteria.notification.NotificationMessageHibernateQueryCriteria;
import genesis.api.BaseParametersContainerTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMessageParametersContainerTransformer extends BaseParametersContainerTransformer<NotificationMessageParametersContainer,
        NotificationMessageHibernateQueryCriteria> {
}
