package catBook.api.transformer.locale;

import catBook.api.DTO.locale.LocaleResponseDTO;
import catBook.main.bean.locale.Locale;
import genesis.api.BaseResponseDTOTransformer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocaleResponseDTOTransformer extends BaseResponseDTOTransformer<LocaleResponseDTO, Locale> {
}
