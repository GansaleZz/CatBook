package catBook.api.service.book;

import catBook.api.DTO.book.BookUserMapRequestDTO;
import catBook.api.DTO.book.BookUserMapResponseDTO;
import catBook.api.transformer.container.BookUserMapParametersContainer;
import catBook.main.bean.BookUserMap;
import genesis.api.BaseCreateService;
import genesis.api.BaseReadService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/bookUserMaps")
public interface BookUserMapService extends BaseCreateService<BookUserMapResponseDTO, BookUserMapRequestDTO>,
        BaseReadService<BookUserMapResponseDTO, BookUserMap, BookUserMapParametersContainer> {
}
