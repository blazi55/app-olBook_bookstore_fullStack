package com.query.application.person;

import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Person> checkAge(Integer age) {
        JPAQuery<Person> jpaQuery = new JPAQuery<>(em);
        QPerson qperson = QPerson.person;
        return jpaQuery.from(qperson)
                .where(qperson.age.between(age, 100))
                .orderBy(qperson.firstName.desc())
                .fetch();
    }

    @Override
    public List<Long> countFirstName() {
        JPAQuery<Person> jpaQuery = new JPAQuery<>(em);
        QPerson qperson = QPerson.person;
        NumberPath<Long> count = Expressions.numberPath(Long.class, "c");

        return jpaQuery.select(
                qperson.firstName.count().as(count))
                .from(qperson)
                .fetch();
    }

    @Override
    public List<Person> sortFirstNameAndLastName() {
        JPAQuery<Person> jpaQuery = new JPAQuery<>(em);
        QPerson qperson = QPerson.person;
        return jpaQuery.from(qperson)
                .orderBy(qperson.firstName.desc(), qperson.lastName.asc())
                .fetch();
    }

    @Override
    public Map<Long, String> getFullNameWithAge() {
        JPAQuery<Person> jpaQuery = new JPAQuery<>(em);
        QPerson qperson = QPerson.person;
        String emptyPlace = " ";
        return jpaQuery.from(qperson)
                .transform(GroupBy.groupBy(qperson.id).as(qperson.firstName
                        .concat(emptyPlace).concat(qperson.lastName)));
    }
}
