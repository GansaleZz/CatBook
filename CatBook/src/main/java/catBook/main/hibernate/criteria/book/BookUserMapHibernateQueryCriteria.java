package catBook.main.hibernate.criteria.book;

import catBook.main.bean.book.BookUserMap;
import genesis.hibernate.criteria.Criteria;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUserMapHibernateQueryCriteria extends GenesisHibernateQueryCriteria<BookUserMap> {

    @Override
    public Class<BookUserMap> getBeanClass() {
        return BookUserMap.class;
    }

    @Criteria(name = "bookID")
    private long bookID;

    @Criteria(name = "userID")
    private long userID;
}
