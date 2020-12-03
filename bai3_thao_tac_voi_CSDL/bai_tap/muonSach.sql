create table Book(
idBook int primary key auto_increment,
tensach varchar(50) not null,
nhaXuatBan varchar(50),
tacGia varchar(50),
namXuatBan date not null,
soLanXuatBan int,
gia double not null,
anh varchar(50),
categoryId int,
foreign key(categoryId) references  Category(idCategory)
);
create table Category(
idCategory int primary key auto_increment,
vanHoc varchar(50) not null,
tinHoc varchar(50) not null,
toanHoc varchar(50) not null
);
create table Student(
student_number varchar(15) primary key,
student_name varchar(50) unique,
address nvarchar(500) not null,
email varchar(50) unique,
image varchar(50),
ngaySinh date,
phoneNumber int(11) not null unique,
tinhtrang varchar(15) not null
);
create table BorrowOrder(
idBorrowOrder int primary key auto_increment,
ngayMuon date not null,
ngayTra date not null,
student_number varchar(15),
foreign key(student_number) references Student(student_number)
);
create table BookOrder(
idBookOrder int primary key,
idBook int,
IdOrder int,
foreign key (idBook) references Book(idBook),
foreign key(IdOrder) references BorrowOrder(idBorrowOrder)
);