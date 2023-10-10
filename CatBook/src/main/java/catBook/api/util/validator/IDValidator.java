package catBook.api.util.validator;

import genesis.api.BaseRequestResult;
import genesis.bean.GenesisBean;
import genesis.hibernate.DAO.GenesisHibernateBeanDAO;
import genesis.manager.GenesisManager;
import genesis.util.constant.GenesisConstants;
import genesis.util.validation.GenesisValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IDValidator extends GenesisValidator {

    @Autowired
    private LongValidator longValidator;

    @Autowired
    private ApplicationContext applicationContext;

    public void rejectInvalidID(BaseRequestResult result, Long ID, String fieldName, Class<? extends GenesisBean> clazz) {
        longValidator.rejectEmpty(result, ID, fieldName);

        if (!result.getErrors().containsKey(fieldName)) {
            ResolvableType type = ResolvableType.forClassWithGenerics(GenesisManager.class, clazz);
            GenesisManager<?> manager = (GenesisManager<?>) applicationContext.getBeanProvider(type).getObject();

            if (Optional.ofNullable(manager.findByID(ID)).isEmpty()) {
                putError(fieldName, String.format(GenesisConstants.VALIDATION_INVALID_ID, fieldName, ID), result);
            }
        }
    }
}
