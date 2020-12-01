select * from classicmodels.customers limit 0,30;
select * from classicmodels.customers where customerName = 'Atelier Graphique' limit 0,30;
select * from classicmodels.customers where customerName like "%A%" limit 0,30;
select * from classicmodels.customers
where city in ('Nantes', 'Las Vegas', 'Warszawa', 'NYC')
limit 0,30;
select * from classicmodels.orders where
orderNumber between 10100 and 10110;
select * from classicmodels.orders 
where (day(orderdate)<=3 and month(orderdate)<=3 and year(orderdate) <=2003) and
orders.status like "%shipped";