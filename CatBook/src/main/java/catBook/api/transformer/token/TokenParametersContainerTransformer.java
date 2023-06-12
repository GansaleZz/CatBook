package catBook.api.transformer.token;

import catBook.api.transformer.token.container.TokenParametersContainer;
import catBook.main.hibernate.criteria.token.TokenHibernateQueryCriteria;
import genesis.api.BaseParametersContainerTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TokenParametersContainerTransformer extends BaseParametersContainerTransformer<TokenParametersContainer,
        TokenHibernateQueryCriteria> {
}
