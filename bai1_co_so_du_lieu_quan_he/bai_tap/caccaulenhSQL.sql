select * from classicmodels.customers;
select customerName, phone, city, country from customers;
select * from customers where customerName =  'Atelier Graphique';
select * from customers where customerName like "%A%";
SELECT * FROM customers WHERE city IN ('Nantes',' Las Vegas',' Warszawa','NYC');
SELECT * FROM customers WHERE city IN ('Nantes',' Las Vegas',' Warszawa','NYC');