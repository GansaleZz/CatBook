package catBook.api.transformer.notification;

import catBook.api.transformer.notification.container.NotificationStatusParametersContainer;
import catBook.main.hibernate.criteria.notification.NotificationStatusHibernateQueryCriteria;
import genesis.api.BaseParametersContainerTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationStatusParametersContainerTransformer extends BaseParametersContainerTransformer<NotificationStatusParametersContainer,
        NotificationStatusHibernateQueryCriteria> {
}
