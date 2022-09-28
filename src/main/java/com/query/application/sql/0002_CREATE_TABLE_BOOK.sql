create table book (
	id bigint auto_increment primary key,
    name varchar(30),
    price double,
    person_id bigint,
    foreign key(person_id) references person(id)
);