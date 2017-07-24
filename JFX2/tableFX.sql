create database tabeleFX;
use tabeleFX;

create table employee(

id_employee Integer not null primary key auto_increment,
firstName_employee varchar(15) not null,
lastName_employee varchar(25) not null,
gross_salary Integer  not null

);

#insert into employee (firstName_employee,lastName_employee, gross_salary) values
#('admin', 'admin123', 2000),
#('Bartosz', 'Kowalski', 3000),
#('Kamil', 'Nowak', 4000);


insert into employee (firstName_employee,lastName_employee, gross_salary) values ('admin', 'admin123', 2000);
insert into employee (firstName_employee,lastName_employee, gross_salary) values ('Bartosz', 'Kowalski', 3000);
insert into employee (firstName_employee,lastName_employee, gross_salary) values ('Kamil', 'Nowak', 4000);


select * from employee;
drop table employee;
create table users(

id_employee Integer not null,
login varchar(15) not null,
pass varchar(25) not null,
access varchar(25) not null,
primary key(id_employee),
foreign key(id_employee) references employee (id_employee)
);


insert into users (id_employee,login, pass, access) values (1, 'l1', 'p1','admin');
insert into users (id_employee,login, pass, access) values (2, 'l2', 'p2','user');
select * from users;
drop table users;

