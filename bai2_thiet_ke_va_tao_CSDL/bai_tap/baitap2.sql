create table offices(
officeCode varchar(10) primary key,
city varchar(50) not null,
phone varchar(50) not null,
addressLine1 varchar(50) not null,
addressLine2 varchar(50) not null,
state varchar(50) not null,
country varchar(50) not null,
postalCode varchar(15) not null
);
create table employees(
employeeNumber int primary key,
lastName varchar(50) not null,
firstName varchar(50) not null,
email varchar(100) not null,
jobTitle varchar(50) not null,
officeCode varchar(10),
foreign key(officeCode) references offices(officeCode),
report_to int,
foreign key (report_to) references employees(employeeNumber)
);
create table customers(
customernumber int primary key,
customername varchar(50) not null,
contactLastName varchar(50) not null,
contactFirstName varchar(50) not null,
phone varchar(50) not null,
addressLine1 varchar(50) not null,
addressLine2 varchar(50) not null,
city varchar(50) not null,
state varchar(50) not null,
postalCode varchar(15) not null,
country varchar(50) not null,
creditLimit double,
employeeNumber int,
foreign key(employeeNumber) references employees(employeeNumber)
);
create table orders(
orderNumber int primary key,
oderDate date not null,
requiredDate date not null,
shippedDate date not null,
status varchar(15) not null,
comments text,
quantityOrdered int not null,
priceEach double not null,
customernumber int,
foreign key(customernumber) references customers(customernumber)
);
create table payments(
customernumber int,
checkNumber varchar(50) primary key,
paymentDate date not null,
amount double not null,
foreign key(customernumber) references customers(customernumber)
);

create table productlines(
productLine varchar(50) primary key,
textDescription text,
image varchar(50)
);
create table products(
productCode varchar(50) primary key,
productName varchar(70) not null,
productScale varchar(10) not null,
productVendor varchar(50) not null,
productDescription  text not null,
quantityInStock int not null,
buyPrice double not null,
MSRP double not null,
productLine varchar(50),
foreign key(productLine) references productlines(productLine)
);
create table OrderDetails(
orderNumber int,
productCode varchar(50),
primary key(orderNumber,productCode),
foreign key(orderNumber) references orders(orderNumber),
foreign key(productCode) references products(productCode)
);