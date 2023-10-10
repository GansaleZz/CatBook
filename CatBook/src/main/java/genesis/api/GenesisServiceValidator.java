package genesis.api;

import catBook.api.util.validator.*;
import catBook.exception.ValidationDTOException;
import genesis.bean.GenesisBean;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
public abstract class GenesisServiceValidator<T extends GenesisRequestDTO> {

    @Autowired
    protected LongValidator longValidator;

    @Autowired
    protected StringValidator stringValidator;

    @Autowired
    protected DateValidator dateValidator;

    @Autowired
    protected IntegerValidator integerValidator;

    @Autowired
    protected IDValidator idValidator;

    /**
     *
     * @param DTO
     */
    public abstract void doValidate(BaseRequestResult result, T DTO);

    /**
     *
     * @param DTO
     */
    public final void validate(T DTO) {
        BaseRequestResult result = new BaseRequestResult();

        doValidate(result, DTO);

        if (CollectionUtils.isNotEmpty(result.getErrors().values())) {
            throw new ValidationDTOException(result);
        }
    }
}
