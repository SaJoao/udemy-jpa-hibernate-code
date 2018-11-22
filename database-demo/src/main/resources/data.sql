-- This script runs automatically at application startup
-- DB connection jdbc:h2:mem:testdb

-- Create table is not needed in JPA with embeded database
-- Spring boot autoconfig triggers Hibernate's Schema Update that creates tables for the @Entity  
/*
create table person
(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);
*/

insert into person (id, name, location, birth_date) values (10001, 'Joao', 'Gondomar', sysdate());
insert into person (id, name, location, birth_date) values (10002, 'Dri', 'Porto', sysdate());
insert into person (id, name, location, birth_date) values (10003, 'Manel', 'Braga', sysdate());
