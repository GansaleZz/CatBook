package catBook.api.service.book;

import catBook.api.DTO.book.BookResponseDTO;
import catBook.api.DTO.book.BookUserMapRequestDTO;
import catBook.api.DTO.book.BookUserMapResponseDTO;
import catBook.api.transformer.book.container.BookUserMapParametersContainer;
import catBook.main.bean.book.BookUserMap;
import genesis.api.BaseCreateService;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/bookUserMaps")
public interface BookUserMapService extends BaseCreateService<BookUserMapResponseDTO, BookUserMap, BookUserMapRequestDTO> {

    @GetMapping({"/", ""})
    CollectionModel<EntityModel<BookUserMapResponseDTO>> findAll(PageFilter pageFilter,
                                                          BookUserMapParametersContainer container);
}
