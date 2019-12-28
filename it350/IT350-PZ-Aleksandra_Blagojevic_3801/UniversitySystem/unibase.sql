/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     12/29/2019 12:05:26 AM                       */
/*==============================================================*/


drop table if exists curriculum;

drop table if exists degree;

drop table if exists faculty;

drop table if exists grading;

drop table if exists homework;

drop table if exists homework_obligation;

drop table if exists obligation_definition;

drop table if exists professor;

drop table if exists project;

drop table if exists project_obligation;

drop table if exists r16;

drop table if exists r18;

drop table if exists semester;

drop table if exists student;

drop table if exists study_program;

drop table if exists study_year;

drop table if exists subject;

drop table if exists subject_definition;

drop table if exists test;

drop table if exists test_obligation;

/*==============================================================*/
/* Table: curriculum                                            */
/*==============================================================*/
create table curriculum
(
   curriculum_id        int not null,
   program_id           int,
   year_id              int not null,
   semester_id          int not null,
   primary key (curriculum_id)
);

/*==============================================================*/
/* Table: degree                                                */
/*==============================================================*/
create table degree
(
   degree_id            int not null,
   faculty_id           int,
   degree_name          varchar(64) not null,
   primary key (degree_id)
);

/*==============================================================*/
/* Table: faculty                                               */
/*==============================================================*/
create table faculty
(
   faculty_id           int not null,
   faculty_name         varchar(64) not null,
   primary key (faculty_id)
);

/*==============================================================*/
/* Table: grading                                               */
/*==============================================================*/
create table grading
(
   grading_id           int not null,
   person_id            int(13) not null,
   stud_id              int not null,
   file_location        varchar(256) not null,
   date                 date not null,
   points               real not null,
   primary key (grading_id)
);

/*==============================================================*/
/* Table: homework                                              */
/*==============================================================*/
create table homework
(
   homework_id          int not null,
   homework_num         smallint not null,
   homework_text        text not null,
   primary key (homework_id)
);

/*==============================================================*/
/* Table: homework_obligation                                   */
/*==============================================================*/
create table homework_obligation
(
   hw_ob_id             int not null,
   homework_id          int not null,
   obli_def_id          int,
   primary key (hw_ob_id)
);

/*==============================================================*/
/* Table: obligation_definition                                 */
/*==============================================================*/
create table obligation_definition
(
   obli_def_id          int not null,
   sub_def_id           int not null,
   proj_ob_id           int,
   max_points           real not null,
   primary key (obli_def_id)
);

/*==============================================================*/
/* Table: professor                                             */
/*==============================================================*/
create table professor
(
   person_id            int(13) not null auto_increment,
   prof_id              int not null,
   degree_name          varchar(64),
   surname              varchar(64),
   phone_number         varchar(32),
   email                varchar(64),
   city_of_birth        varchar(32),
   date_of_birth        date,
   study_title          varchar(16) not null,
   prof_email           varchar(64) not null,
   primary key (person_id, prof_id)
);

/*==============================================================*/
/* Table: project                                               */
/*==============================================================*/
create table project
(
   project_id           int not null,
   name                 varchar(128) not null,
   abstract             text not null,
   key_words            text not null,
   primary key (project_id)
);

/*==============================================================*/
/* Table: project_obligation                                    */
/*==============================================================*/
create table project_obligation
(
   proj_ob_id           int not null,
   project_id           int not null,
   primary key (proj_ob_id)
);

/*==============================================================*/
/* Table: r16                                                   */
/*==============================================================*/
create table r16
(
   subject_id           int not null,
   person_id            int(13) not null,
   stud_id              int not null,
   primary key (subject_id, person_id, stud_id)
);

/*==============================================================*/
/* Table: r18                                                   */
/*==============================================================*/
create table r18
(
   grading_id           int not null,
   obli_def_id          int not null,
   primary key (grading_id, obli_def_id)
);

/*==============================================================*/
/* Table: semester                                              */
/*==============================================================*/
create table semester
(
   semester_id          int not null,
   semester_code        smallint not null,
   primary key (semester_id)
);

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
   person_id            int(13) not null auto_increment,
   stud_id              int not null,
   degree_name          varchar(64),
   surname              varchar(64),
   phone_number         varchar(32),
   email                varchar(64),
   city_of_birth        varchar(32),
   date_of_birth        date,
   study_type           varchar(16) not null,
   stud_email           varchar(64) not null,
   primary key (person_id, stud_id)
);

/*==============================================================*/
/* Table: study_program                                         */
/*==============================================================*/
create table study_program
(
   program_id           int not null,
   faculty_id           int,
   study_name           varchar(32) not null,
   duration             smallint not null,
   min_espb             smallint not null,
   study_title          varchar(16) not null,
   primary key (program_id)
);

/*==============================================================*/
/* Table: study_year                                            */
/*==============================================================*/
create table study_year
(
   year_id              int not null,
   yearstart            date not null,
   yearend              date not null,
   primary key (year_id)
);

/*==============================================================*/
/* Table: subject                                               */
/*==============================================================*/
create table subject
(
   subject_id           int not null,
   person_id            int(13) not null,
   prof_id              int not null,
   subject_code         varchar(5) not null,
   subject_name         varchar(64) not null,
   espb                 smallint not null,
   primary key (subject_id)
);

/*==============================================================*/
/* Table: subject_definition                                    */
/*==============================================================*/
create table subject_definition
(
   sub_def_id           int not null,
   curriculum_id        int not null,
   subject_id           int not null,
   primary key (sub_def_id)
);

/*==============================================================*/
/* Table: test                                                  */
/*==============================================================*/
create table test
(
   test_id              int not null,
   test_num             smallint not null,
   primary key (test_id)
);

/*==============================================================*/
/* Table: test_obligation                                       */
/*==============================================================*/
create table test_obligation
(
   test_ob_id           int not null,
   test_id              int not null,
   obli_def_id          int,
   primary key (test_ob_id)
);

alter table curriculum add constraint fk_r3 foreign key (program_id)
      references study_program (program_id) on delete restrict on update restrict;

alter table curriculum add constraint fk_r4 foreign key (year_id)
      references study_year (year_id) on delete restrict on update restrict;

alter table curriculum add constraint fk_r6 foreign key (semester_id)
      references semester (semester_id) on delete restrict on update restrict;

alter table degree add constraint fk_r1 foreign key (faculty_id)
      references faculty (faculty_id) on delete restrict on update restrict;

alter table grading add constraint fk_r17 foreign key (person_id, stud_id)
      references student (person_id, stud_id) on delete restrict on update restrict;

alter table homework_obligation add constraint fk_r10 foreign key (homework_id)
      references homework (homework_id) on delete restrict on update restrict;

alter table homework_obligation add constraint fk_r13 foreign key (obli_def_id)
      references obligation_definition (obli_def_id) on delete restrict on update restrict;

alter table obligation_definition add constraint fk_r12 foreign key (proj_ob_id)
      references project_obligation (proj_ob_id) on delete restrict on update restrict;

alter table obligation_definition add constraint fk_r8 foreign key (sub_def_id)
      references subject_definition (sub_def_id) on delete restrict on update restrict;

alter table project_obligation add constraint fk_r9 foreign key (project_id)
      references project (project_id) on delete restrict on update restrict;

alter table r16 add constraint fk_r16 foreign key (subject_id)
      references subject (subject_id) on delete restrict on update restrict;

alter table r16 add constraint fk_r19 foreign key (person_id, stud_id)
      references student (person_id, stud_id) on delete restrict on update restrict;

alter table r18 add constraint fk_r18 foreign key (grading_id)
      references grading (grading_id) on delete restrict on update restrict;

alter table r18 add constraint fk_r20 foreign key (obli_def_id)
      references obligation_definition (obli_def_id) on delete restrict on update restrict;

alter table study_program add constraint fk_r2 foreign key (faculty_id)
      references faculty (faculty_id) on delete restrict on update restrict;

alter table subject add constraint fk_r15 foreign key (person_id, prof_id)
      references professor (person_id, prof_id) on delete restrict on update restrict;

alter table subject_definition add constraint fk_r5 foreign key (curriculum_id)
      references curriculum (curriculum_id) on delete restrict on update restrict;

alter table subject_definition add constraint fk_r7 foreign key (subject_id)
      references subject (subject_id) on delete restrict on update restrict;

alter table test_obligation add constraint fk_r11 foreign key (test_id)
      references test (test_id) on delete restrict on update restrict;

alter table test_obligation add constraint fk_r14 foreign key (obli_def_id)
      references obligation_definition (obli_def_id) on delete restrict on update restrict;

