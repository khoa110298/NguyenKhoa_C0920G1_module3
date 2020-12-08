SELECT * FROM customers WHERE customerNumber = 175; 
EXPLAIN SELECT * FROM customers WHERE customerNumber = 175;
alter table customers add index inx_customerNumber(customerNumber);
explain select * from customers where customerNumber = 175;
alter table customers add index idx_full_name(contactFirstName,contactLastName);
explain select * from customers where contactFirstName = 'Jean' or contactFirstName = 'King';
alter table customers drop index idx_full_name;