package com.query.application.person;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPerson is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPerson extends EntityPathBase<Person> {

    private static final long serialVersionUID = -1640521219L;

    public static final QPerson person = new QPerson("person");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final ListPath<com.query.application.book.Book, com.query.application.book.QBook> books = this.<com.query.application.book.Book, com.query.application.book.QBook>createList("books", com.query.application.book.Book.class, com.query.application.book.QBook.class, PathInits.DIRECT2);

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastName = createString("lastName");

    public QPerson(String variable) {
        super(Person.class, forVariable(variable));
    }

    public QPerson(Path<? extends Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPerson(PathMetadata metadata) {
        super(Person.class, metadata);
    }

}

