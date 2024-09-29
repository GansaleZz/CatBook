package catBook.api.service.book;

import catBook.api.DTO.book.BookTypeResponseDTO;
import catBook.api.transformer.book.container.BookTypeParametersContainer;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/bookTypes")
public interface BookTypeService {

    @GetMapping({"/", ""})
    CollectionModel<EntityModel<BookTypeResponseDTO>> findAll(PageFilter pageFilter,
                                                              BookTypeParametersContainer container);
}
