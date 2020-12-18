create table users(
id int primary key auto_increment,
name varchar(45) not null,
email varchar(45) not  null,
country varchar(50)

);
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');