#создание бд
create database if not exists listExpenses;

#создание таблиц
create table if not exists listExpenses.receivers(
id int auto_increment primary key,
name varchar(255) not null
);

create table if not exists listExpenses.expenses(
id int (10) auto_increment primary key,
paydate date not null,
receiver int (10) not null,
value dec (7,2) not null,
constraint receiver foreign key (receiver) references listExpenses.receivers(id)
);

#Задание 1
#добавление данных в табл. receivers
insert into listexpenses.receivers (name) values ("evroopt");
insert into listexpenses.receivers (name) values ("korona");
insert into listexpenses.receivers (name) values ("sosedi");

#добавление данных в табл. expenses
insert into listexpenses.expenses (id,paydate,receiver,value) 
values (1, '25.12.2020',1,36.00);
insert into listexpenses.expenses (id,paydate,receiver,value) 
values (2, '2020.12.24',2,25.36);
insert into listexpenses.expenses (paydate,receiver,value) 
values ('2020.12.20',2,10.00);
insert into listexpenses.expenses (paydate,receiver,value) 
values ('2020.12.19',3,150.00);

