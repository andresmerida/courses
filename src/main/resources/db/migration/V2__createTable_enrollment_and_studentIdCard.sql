-- create enrollment table
create table enrollment (
                            id bigint not null,
                            grade integer not null,
                            created_at timestamp not null,
                            student_id integer,
                            course_id integer,
                            primary key (id)
);
create sequence enrollment_sequence as integer increment 1;

alter table enrollment add constraint FK_Enrollment_Ref_Student foreign key (student_id)
    references student (id) on delete restrict on update restrict;

alter table enrollment add constraint FK_Enrollment_Ref_Course foreign key (course_id)
    references course (id) on delete restrict on update restrict;

-- brand dto
create table student_id_card (
                                 id integer not null,
                                 card_number varchar (100) not null,
                                 student_id int,
                                 primary key (id)
);
alter table student_id_card add constraint fk_student_id_card_Ref_Student foreign key (student_id)
    references student (id) on delete restrict on update restrict;

create sequence my_sequence as integer increment 1;
