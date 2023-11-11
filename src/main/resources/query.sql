-- create student table
create table student (
                         id integer not null,
                         first_name varchar(100) not null,
                         last_name varchar(100) not null,
                         email varchar(255),
                         age int,
                         primary key (id)
);

-- create a sequence for estudent ide
create sequence student_sequence as integer increment 1;

-- create book table
create table book (
                      id integer not null,
                      name varchar(100) not null,
                      student_id integer,
                      primary key (id)
);

alter table book add constraint FK_Book_RefStudent foreign key (student_id)
    references student (id) on delete restrict on update restrict;

create sequence book_sequence as integer increment 1;