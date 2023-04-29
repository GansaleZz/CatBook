package catBook.api.service.book;

import catBook.api.DTO.book.BookRequestDTO;
import catBook.api.DTO.book.BookResponseDTO;
import catBook.api.transformer.container.BookParametersContainer;
import catBook.main.bean.Book;
import genesis.api.BaseCreateService;
import genesis.api.BaseReadService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/books")
public interface BookService extends BaseCreateService<BookResponseDTO, BookRequestDTO>,
        BaseReadService<BookResponseDTO, Book, BookParametersContainer> {

}
