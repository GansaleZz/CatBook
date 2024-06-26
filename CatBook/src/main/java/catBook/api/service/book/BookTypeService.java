package catBook.api.service.book;

import catBook.api.DTO.book.BookTypeResponseDTO;
import catBook.api.transformer.container.BookTypeParametersContainer;
import catBook.main.bean.BookType;
import genesis.api.BaseReadService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/bookTypes")
public interface BookTypeService extends BaseReadService<BookTypeResponseDTO, BookType, BookTypeParametersContainer> {
}
