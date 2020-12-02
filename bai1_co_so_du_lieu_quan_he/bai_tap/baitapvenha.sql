create database baitapvenha;
create table categories(
id int primary key,
name nvarchar(50),
description nvarchar(500)
);
create table supplieers(
id int primary key,
name nvarchar(100),
email varchar(50),
phonenumber varchar(50),
address nvarchar(500)
);
create table customer(
id varchar(50) primary key,
firstName nvarchar(50),
lastName nvarchar(50),
phoneNumber varchar(50),
address nvarchar(500),
Email varchar(50),
birthDay date
);
create table employees(
id int primary key,
name nvarchar(500),
umageUrl nvarchar(1000),
price int,
Discount int,
Stock int,
CategoryId int,
SupplieId int,
Description nvarchar(1000)
);
create table Orders(
id int primary key,
CreateDate datetime,
ShippedDate datetime,
Status varchar(50),
Description nvarchar(1000),
ShippingAddress nvarchar(1000),
ShippingCity nvarchar(100),
PaymentType varchar(20),
customerId varchar(50),
EmployeeId varchar(50)
);
create table orderDetails(
id int primary key,
OrderId int,
ProductId int,
Quantity int
);