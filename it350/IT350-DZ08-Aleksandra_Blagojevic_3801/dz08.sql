set foreign_key_checks=0;
 
create database if not exists dz08;
 
use dz08;
 
drop table if exists patient;
create table if not exists patient (
    patient_id int(11) not null auto_increment,
    name varchar(64) not null,
    surname varchar(64) not null,
    jmbg varchar(13) not null unique,
    address varchar(64) not null,
    phone varchar (32) not null,
    constraint patient_pk primary key (patient_id),
    doctor_id int(11)
);
describe pacijent;
 
 
alter table patient add constraint foreign key (doctor_id) references doctor (doctor_id);
 
 
drop table if exists doctor;
create table if not exists doctor (
    doctor_id int(11) not null auto_increment,
    name varchar(64) not null,
    surname varchar(64) not null,
    jmbg varchar(13) not null unique,
    spec varchar(32) not null,
    constraint doctor_pk primary key (doctor_id)
);
describe doctor;
 
 
drop table if exists medikament;
create table if not exists medikament (
    medikament_id int(11) auto_increment,
    name varchar(64) not null,
    vendor varchar(64) not null,
    sifra varchar(13) not null,
    constraint medikament_pk primary key (medikament_id),
    vendor_id int(11)
);
describe medikament;
 
 
alter table medikament add constraint foreign key (vendor_id) references vendor (vendor_id);
 
 
drop table if exists illness;
create table if not exists illness (
    illness_id int(11) not null auto_increment,
    name varchar(64) not null,
    description varchar(1024) not null,
    image blob not null,
    constraint illness_pk primary key (illness_id)
);
 
drop table if exists vendor;
create table if not exists vendor (
    vendor_id int(11) not null auto_increment,
    name varchar(64) not null,
    address varchar(64) not null,
    phone varchar(32) not null,
    constraint vendor_pk primary key (vendor_id)
);
describe vendor;
 
 
drop table if exists boluje_od;
create table if not exists boluje_od (
    boluje_od_id int(11) not null auto_increment,
    diagnosis_date varchar(32) not null,
    constraint boluje_od_pk primary key (boluje_od_id),
    patient_id int(11),
    illness_id int(11)
);
describe boluje_od;
 
alter table boluje_od add constraint foreign key (patient_id) references patient (patient_id);
alter table boluje_od add constraint foreign key (illness_id) references illness (illness_id);
 
alter table illness drop image;
describe illness;
 
alter table doctor add legitimacija varchar(16) unique after jmbg;
describe doctor;
 
drop table if exists chosen_doctor;
create table if not exists chosen_doctor (
    chosen_doctor_id integer(11) auto_increment,
    constraint chosen_doctor_pk primary key (chosen_doctor_id),
    doctor_id integer(11),
    patient_id integer(11),
    constraint foreign key (doctor_id) references doctor(doctor_id),
    constraint foreign key (patient_id) references patient(patient_id)
);
 
drop table if exists pregled;
create table if not exists pregled (
    pregled_id integer(11) auto_increment,
    constraint pregled_pk primary key (pregled_id),
    datee datetime,
    doctor_id integer(11),
    patient_id integer(11),
    constraint foreign key (doctor_id) references doctor(doctor_id),
    constraint foreign key (patient_id) references patient(patient_id)
);
 
drop table if exists therapy;
create table if not exists therapy (
    therapy_id integer(11) auto_increment,
    constraint therapy_pk primary key (therapy_id),
    descriptionn varchar(4096),
    datee datetime,
    duration integer(3),
    doctor_id integer(11),
    patient_id integer(11),
    constraint foreign key (doctor_id) references doctor(doctor_id),
    constraint foreign key (patient_id) references patient(patient_id)
);
 
set foreign_key_checks=1;