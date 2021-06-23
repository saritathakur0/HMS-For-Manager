drop database HMS;
create database HMS;
use HMS;

create table Login(
username varchar(20),
pwd varchar(20)
);

insert into Login values("manager", "manager");

create table Room(
rno integer primary key,
floorno integer,
rstatus varchar(3),
booking varchar(3) default "no");

create table Student(
sid integer primary key auto_increment,
fname varchar(20),
lname varchar(20),
mobile varchar(10),
email varchar(20),
cname varchar(50),
aadhar varchar(12),
image longblob,
address varchar(100),
rno integer,
doj date,
constraint fk_paststudent foreign key(rno) references Room(rno) on delete cascade)auto_increment=201;

create table PastStudent(
fname varchar(20),
lname varchar(20),
mobile varchar(10),
email varchar(20),
cname varchar(50),
aadhar varchar(12),
address varchar(100),
rno integer,
doj date,
dol date,
constraint fk_student foreign key(rno) references Room(rno) on delete cascade )auto_increment=201;

create table Employees(
eid integer primary key auto_increment,
fname varchar(20),
lname varchar(20),
mobile varchar(10),
email varchar(20),
aadhar varchar(12),
image longblob,
address varchar(100),
job varchar(20),
gender varchar(6),
doj date )auto_increment=301;

create table PastEmployees(
fname varchar(20),
lname varchar(20),
mobile varchar(10),
email varchar(20),
aadhar varchar(12),
address varchar(100),
job varchar(20),
gender varchar(6),
doj date,
dor date );

create table StudentFees(
sid integer,
month varchar(15),
amount integer,
paidon date,
constraint fk_studentfees foreign key(sid) references Student(sid) on delete cascade
);

create table EmployeePayment(
eid integer,
month varchar(15),
amount integer,
paidon date,
constraint fk_employeepayment foreign key(eid) references Employees(eid) on delete cascade
);
