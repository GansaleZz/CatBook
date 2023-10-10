package catBook.api.service.book;

import catBook.api.DTO.book.BookRequestDTO;
import catBook.api.DTO.book.BookResponseDTO;
import catBook.api.transformer.book.container.BookParametersContainer;
import catBook.main.bean.book.Book;
import genesis.api.BaseCreateService;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/books")
public interface BookService extends BaseCreateService<BookResponseDTO, Book, BookRequestDTO> {

    @GetMapping({"/", ""})
    CollectionModel<EntityModel<BookResponseDTO>> findAll(PageFilter pageFilter,
                                                          BookParametersContainer container);
}
