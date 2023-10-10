package catBook.main.manager.book;

import catBook.main.bean.book.BookUserMap;
import catBook.main.hibernate.criteria.book.BookUserMapHibernateQueryCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultBookUserMapManager extends BookUserMapManager {

    @Override
    public List<BookUserMap> findByUserID(long userID) {
        BookUserMapHibernateQueryCriteria criteria = new BookUserMapHibernateQueryCriteria();
        criteria.setUserID(userID);
        criteria.setActive(true);

        return findAll(criteria);
    }
}
