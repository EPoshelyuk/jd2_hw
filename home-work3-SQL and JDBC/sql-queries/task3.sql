use listExpenses;

#увеличить затраты на 0,99р
update expenses set value=value+0.99;

#уменьшить затраты на 1,99р, где код получателя=1
update expenses set value=value-1.99 where id=1;

#Задание 3
#удалить все платежи,которые по меньше 30р
delete from expenses where value<30;
