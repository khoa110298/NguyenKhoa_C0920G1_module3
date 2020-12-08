create view customer_views as
select customers.customerNumber,customers.customerName,customers.phone
from customers;
select * from customer_views;
create or replace view customer_views as
select customers.customerNumber,customers.customerName,
customers.contactFirstName,customers.contactLastName,customers.phone
from customers where city = 'Nantes';
drop view customer_views;