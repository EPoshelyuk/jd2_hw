#получение всех полей из таблицы expenses
select * from listExpenses.expenses;

#получение определенных полей (id, paydate, value) из таблицы expenses
select id, paydate, value from listExpenses.expenses;

#получение всех полей из таблицы expenses, в которых затраты больше или равно 30р
select * from listExpenses.expenses where value>=30;

#получение всех полей из таблицы expenses, в которых код получателя равен 2
select * from listExpenses.expenses where receiver=2;

#сортировать по затратам в порядке возрастания
select * from listExpenses.expenses order by value;

#сортировать по затратам в порядке убывания
select * from listExpenses.expenses order by value desc;

#сортировать по коду получателя и затратам
select * from listExpenses.expenses order by receiver, value;

#получить данные о расходах с названиями получателей платежей
select paydate, value, name from listExpenses.expenses, listExpenses.receivers where receiver=receivers.id;

# Задание 2 
# Выборка из обеих таблиц, где величина расходов больше 10р. Должны присутствовать поля: номер платежа, дата, имя получателя, величина
select expenses.id, expenses.paydate, expenses.value, receivers.name from listExpenses.expenses, listExpenses.receivers 
where receiver=receivers.id and expenses.value>10;






