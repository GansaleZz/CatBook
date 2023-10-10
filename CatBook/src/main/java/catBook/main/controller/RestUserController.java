package catBook.main.controller;

import catBook.main.bean.book.Book;
import catBook.main.bean.book.BookType;
import catBook.main.bean.book.BookUserMap;
import catBook.main.bean.user.User;
import catBook.main.manager.book.BookManager;
import catBook.main.manager.book.BookTypeManager;
import catBook.main.manager.book.BookUserMapManager;
import catBook.main.manager.token.TokenManager;
import catBook.main.manager.user.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestUserController {

    @Autowired
    private TokenManager tokenManager;

    @GetMapping("/api/books")
    public EntityModel<Book> getBook() {
        return EntityModel.of(new Book());
    }

}
