package catBook.main.controller;

import catBook.main.bean.book.Book;
import catBook.main.bean.book.BookType;
import catBook.main.bean.book.BookUserMap;
import catBook.main.bean.user.User;
import catBook.main.manager.book.BookManager;
import catBook.main.manager.book.BookTypeManager;
import catBook.main.manager.book.BookUserMapManager;
import catBook.main.manager.user.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestUserController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private BookManager bookManager;

    @Autowired
    private BookTypeManager bookTypeManager;

    @Autowired
    private BookUserMapManager bookUserMapManager;

    @GetMapping("/api/users/{ID}")
    public EntityModel<User> getUser(@PathVariable long ID) {
        return EntityModel.of(userManager.findByID(ID));
    }

    @GetMapping("/api/books/{ID}")
    public EntityModel<Book> getBook(@PathVariable long ID) {
        Book book = new Book();
        book.setBookName("TEST");
        book.setBookType(bookTypeManager.findByID(1L));
        bookManager.save(book);
        return EntityModel.of(new Book());
    }

    @GetMapping("/api/bookTypes/{ID}")
    public EntityModel<BookType> getBookType(@PathVariable long ID) {
        return EntityModel.of(bookTypeManager.findByID(ID));
    }

    @GetMapping("/api/bookUserMaps/{ID}")
    public EntityModel<BookUserMap> getBookUserMap(@PathVariable long ID) {
        return EntityModel.of(bookUserMapManager.findByID(ID));
    }
}
