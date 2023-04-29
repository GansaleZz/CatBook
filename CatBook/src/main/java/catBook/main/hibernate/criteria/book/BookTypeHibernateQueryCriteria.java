package catBook.main.hibernate.criteria.book;

import catBook.main.bean.BookType;
import genesis.hibernate.criteria.Criteria;
import genesis.hibernate.criteria.GenesisHibernateQueryCriteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTypeHibernateQueryCriteria extends GenesisHibernateQueryCriteria<BookType> {

    @Override
    public Class<BookType> getBeanClass() {
        return BookType.class;
    }

    @Criteria(name = "bookTypeName")
    private String bookTypeName;
}
