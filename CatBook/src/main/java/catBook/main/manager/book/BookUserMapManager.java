package catBook.main.manager.book;

import catBook.main.bean.book.BookUserMap;
import genesis.manager.GenesisManager;

import java.util.List;

/**
 *
 * @author GansaleZz
 */
public abstract class BookUserMapManager extends GenesisManager<BookUserMap> {

    public abstract List<BookUserMap> findByUserID(long userID);
}
