package catBook.main.hibernate.criteria.book;

import catBook.main.bean.book.Book;
import genesis.hibernate.criteria.Criteria;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import genesis.util.constant.GenesisConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookHibernateQueryCriteria extends GenesisHibernateQueryCriteria<Book> {

    @Override
    public Class<Book> getBeanClass() {
        return Book.class;
    }

    @Criteria(name = "bookName")
    private String bookName = null;
}
