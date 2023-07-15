package com.query.application.book;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookRepositoryIntImpl implements BookRepositoryInt {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Book> getBooksBySortPriceDesc() {
        JPAQuery<Book> jpaQuery = new JPAQuery<>(em);
        QBook qbook = QBook.book;
        return jpaQuery.from(qbook)
                .orderBy(qbook.price.desc())
                .fetch();
    }

    @Override
    public List<Book> getBooksAlphabet() {
        JPAQuery<Book> jpaQuery = new JPAQuery<>(em);
        QBook qbook = QBook.book;
        return jpaQuery.from(qbook)
                .orderBy(qbook.name.asc())
                .fetch();
    }
}
