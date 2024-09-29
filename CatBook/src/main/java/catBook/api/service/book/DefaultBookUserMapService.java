package catBook.api.service.book;

import catBook.api.DTO.book.BookUserMapRequestDTO;
import catBook.api.DTO.book.BookUserMapResponseDTO;
import catBook.api.transformer.book.container.BookUserMapParametersContainer;
import catBook.main.bean.book.BookUserMap;
import catBook.main.hibernate.criteria.book.BookUserMapHibernateQueryCriteria;
import catBook.main.manager.book.BookManager;
import catBook.main.manager.book.BookTypeManager;
import catBook.main.manager.user.UserManager;
import genesis.api.GenesisCreateService;
import genesis.util.constant.GenesisConstants;
import genesis.util.page.PageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultBookUserMapService extends GenesisCreateService<BookUserMapResponseDTO, BookUserMap, BookUserMapRequestDTO>
        implements BookUserMapService {

    @Autowired
    private BookManager bookManager;

    @Autowired
    private UserManager userManager;

    @Autowired
    private BookTypeManager bookTypeManager;

    @Override
    public CollectionModel<EntityModel<BookUserMapResponseDTO>> findAll(PageFilter pageFilter, BookUserMapParametersContainer container) {
        BookUserMapHibernateQueryCriteria criteria = new BookUserMapHibernateQueryCriteria();

        if (container.getBookID() != GenesisConstants.EMPTY_LONG) {
            criteria.setBookID(container.getBookID());
        }
        if (container.getUserID() != GenesisConstants.EMPTY_LONG) {
            criteria.setUserID(container.getUserID());
        }
        if (container.getBookTypeID() != GenesisConstants.EMPTY_LONG) {
            criteria.setBookTypeID(container.getBookTypeID());
        }
        criteria.setActive(container.getActive());

        return findAll(pageFilter, criteria);
    }

    @Override
    protected BookUserMap doSave(BookUserMapRequestDTO bookUserMapRequestDTO) {
        BookUserMap bookUserMap = new BookUserMap();
        bookUserMap.setBookType(bookTypeManager.findByID(bookUserMapRequestDTO.getBookTypeID()));
        bookUserMap.setUser(userManager.findByID(bookUserMapRequestDTO.getUserID()));
        bookUserMap.setBook(bookManager.findByID(bookUserMapRequestDTO.getBookID()));

        return manager.save(bookUserMap);
    }
}
