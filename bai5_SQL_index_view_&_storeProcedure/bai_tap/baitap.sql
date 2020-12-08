-- create database demo;
create table Products(
id int primary key,
product_code varchar(50),
product_name varchar(50),
product_price varchar(50),
product_amount varchar(50),
product_description varchar(50),
product_status varchar(50)
);
create unique index index_productCode
on products(productCode);
create index composite_index
on products(productName,productPrice);
explain select * from products where productName='Fan' ;
explain select * from products where productCode='sp002' ;
create view test_view as
select productCode, productName,productPrice,productStatus
from products;
create or replace view test_view as
select productCode, productName,productPrice,productStatus
from products where productStatus = 'stock';
drop view test_view;
delimiter //
create procedure showAllProduct()
begin
select * from products;
end //
delimiter ;
delimiter //
create procedure addNewProductAutoID(productCode varchar(20),
productName varchar(50),
productPrice int(20),
productAmount int(20),
productDescription varchar(100),
productStatus varchar(100)
)
begin
insert into products(productCode,productName,productPrice,productAmount,productDescription,productStatus)
value(productCode,productName,productPrice,productAmount,productDescription,productStatus);
end; //
delimiter ;
call addNewProductAutoID('sp008','Hat','121','32','ship','not stock');
delimiter //
create procedure editById(inputId int,
productCode varchar(20),
productName varchar(50),
productPrice int(20),
productAmount int(20),
productDescription varchar(100),
productStatus varchar(100))
begin
update products
set
productCode=productCode,
productName=productName,
productPrice=productPrice,
productAmount=productAmount,
productDescription=productDescription,
productStatus=productStatus
where id = inputId;
end; //
delimiter ;
call editById(7,'sp444','AK-47','444','44','not ship','dont have');
select * from products;
delimiter //
create procedure deleteById(inputId int)
begin
delete from products where id = inputId;
end;//
delimiter ;
call deleteById(7);