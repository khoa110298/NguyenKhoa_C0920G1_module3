create table customers(
customer_number int primary key,
fullname varchar(50) not null,
address varchar(50) not null,
email varchar(50) unique not null,
phone varchar(50) unique
);
create table account(
account_number int primary key,
account_type varchar(50) not null,
date_account date,
balance int not null,
customer_number int,
foreign key(customer_number) references customers(customer_number)
); 
create table transactions(
tran_number int primary key,
account_number int not null,
date_transaction date,
amounts int not null,
descriptions nvarchar(100) not null,
account_number int,
foreign key(account_number) references account(account_number)
);