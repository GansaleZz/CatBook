package catBook.main.hibernate.criteria.book;

import catBook.main.bean.book.BookUserMap;
import genesis.hibernate.criteria.Criteria;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import genesis.util.constant.GenesisConstants;
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
    private Long bookID = GenesisConstants.EMPTY_LONG;

    @Criteria(name = "userID")
    private Long userID = GenesisConstants.EMPTY_LONG;

    @Criteria(name = "bookType")
    private Long bookTypeID = GenesisConstants.EMPTY_LONG;
}
