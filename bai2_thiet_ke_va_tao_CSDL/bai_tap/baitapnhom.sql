-- create database baitapvenha;
create table module(
ma_module int primary key,
ten_module varchar(50),
ngay_bat_dau date,
ngay_ket_thuc date,
hoc_phi varchar(50)
);
create table instructor(
id_instructor int primary key,
ten_instructor varchar(50)
);
create table tutor(
id_tutor int primary key,
ten_tutor varchar(50)
);
create table coach(
id_coach int primary key,
ten_coach varchar(50)
);
create table lop_hoc(
ten_lop_hoc varchar(50) primary key,
id_instructor int,
id_tutor int,
id_coach int,
foreign key (id_instructor) references instructor(id_instructor),
foreign key (id_coach) references coach(id_coach),
foreign key (id_tutor) references tutor(id_tutor)
);
create table hoc_sinh(
id_hoc_sinh int primary key,
ten_hoc_sinh varchar(50),
ngay_sinh date,
gioi_tinh varchar(50),
dia_chi varchar(50),
sdt varchar(50),
ma_module int,
ten_lop_hoc varchar(50),
foreign key (ten_lop_hoc) references lop_hoc(ten_lop_hoc),
foreign key (ma_module) references module(ma_module)
);