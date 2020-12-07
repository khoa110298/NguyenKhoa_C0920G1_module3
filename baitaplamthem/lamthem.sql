update products set price = price + 10 where price <=1000;
update products set discount = discount + 5 where discount <=10;
delete from products where stock = 0;
select * from products where discount <=10;
select * from products where stock <=5;
select * from products where (1 - discount/100)*price <1000;
select * from customers where address = 'Đà Nẵng';
select * from customers where year(birthday) = 1990;
select * from customers where day(birthday) = day(now()) and month(birthday) = month(now());
select * from orders where status = 'done';
select * from orders where status = 'canceled' and curdate() = date_ship;
select * from orders where now() - (date_ship) > 0;

