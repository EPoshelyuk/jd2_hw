#использование алиасов (псевдонимов)
select paydate, value, name from expenses, receivers rs where receiver=rs.id;

#вывод величины платежа деленная на два, даты платежа. В заголовке таблицы будет название Половина
select value/2 as Половина, paydate from expenses;

#вывод уникальных строк
select distinct value, name from expenses, receivers rs where receiver=rs.id;

#посчитать количество строк в таблице
select count(*) as Количество from expenses;

#посчитать количество уникальных значений 
select count(distinct value) as Количество from expenses;

#вычислить минимальный расход 
select min(value) as Минимальный_расход, paydate, receiver from expenses;

#вычислить максимальный расход 
select max(value) as Максимальный_расход, paydate, receiver from expenses;

#посчитать сумму всех затрат
select sum(value) as Общий_расход from expenses;

#количество строк с одинаковым получателем
select count(*), name from expenses, receivers rs where receiver=rs.id group by name;

#показать только первых пять записей с начала таблицы
select paydate, value, name from expenses, receivers rs where receiver=rs.id limit 0,5;

#вывести наибольший платеж
select paydate, value, name from expenses, receivers rs where receiver=rs.id and value=(select max(value) from expenses) ;

#Задание 6
#вывести список получателей и сумму платежей по каждому из них
select sum(value) as Потрачено, name from expenses, receivers rs where receiver=rs.id group by receiver;

#вывести сумму платежей за тот день, когда был нибольший платеж
select paydate, sum(value) from expenses where paydate=(select paydate from expenses where value=(select max(value) from expenses));

#вывести наибольший платеж за тот день, когда сумма платежей была наибольшая
select paydate, max(value) from expenses where paydate=(select paydate from expenses where value=(select max(value) from expenses));




