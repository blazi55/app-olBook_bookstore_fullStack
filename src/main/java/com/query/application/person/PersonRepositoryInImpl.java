package com.query.application.person;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonRepositoryInImpl implements PersonRepositoryIn {

    @PersistenceContext
    EntityManager em;
    @Override
    public List<Person> getAllPerson() {
        JPAQuery<Person> jpaQuery = new JPAQuery<>(em);
        QPerson qperson = QPerson.person;
        return jpaQuery.from(qperson)
                .orderBy(qperson.firstName.asc())
                .fetch();
    }
}
