-- drop database if exists casestudyDatabase;
-- create database casestudyDatabase;
create table vi_tri(
id_vi_tri int primary key auto_increment,
ten_vi_tri varchar(45) not null
);
create table trinh_do(
id_trinh_do int primary key auto_increment,
ten_trinh_do varchar(45) not null
);
create table bo_phan(
id_bo_phan int primary key auto_increment,
ten_bo_phan varchar(45) not null
);
create table nhan_vien(
id_nhan_vien int primary key auto_increment,
ho_ten varchar(45) not null,
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
foreign key (id_vi_tri) references vi_tri(id_vi_tri) ON DELETE CASCADE,
foreign key (id_bo_phan) references bo_phan(id_bo_phan) ON DELETE CASCADE,
foreign key (id_trinh_do) references trinh_do(id_trinh_do) ON DELETE CASCADE,
ngay_sinh date,
so_cmnd varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45)
);
create table loai_khach(
id_loai_khach int primary key auto_increment,
ten_loai_khach varchar(45)
);
create table khach_hang(
id_khach_hang int primary key auto_increment,
id_loai_khach int,
foreign key(id_loai_khach) references loai_khach(id_loai_khach) ON DELETE CASCADE,
ho_ten varchar(45),
ngay_sinh date,
so_cmnd varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45)
);
create table loai_dich_vu(
id_loai_dich_vu int primary key auto_increment,
ten_loai_dich_vu varchar(45)
);
create table kieu_thue(
id_kieu_thue int primary key auto_increment,
ten_kieu_thue varchar(45),
gia int
);
create table dich_vu(
id_dich_vu int primary key auto_increment,
ten_dich_vu varchar(45),
dien_tich int,
so_tang int,
so_nguoi_toi_da varchar(45),
chi_phi_thue varchar(45),
id_kieu_thue int,
id_loai_dich_vu int,
foreign key(id_kieu_thue) references kieu_thue(id_kieu_thue) ON DELETE CASCADE,
foreign key(id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu) ON DELETE CASCADE,
trang_thai varchar(45)
);
create table dich_vu_di_kem(
id_dich_vu_di_kem int primary key auto_increment,
ten_dich_vu_di_kem varchar(45),
gia int,
don_vi int,
trang_thai_kha_dung varchar(45)
);
create table hop_dong(
id_hop_dong int primary key auto_increment,
id_nhan_vien int,	
id_khach_hang int,
id_dich_vu int,
foreign key(id_nhan_vien) references nhan_vien(id_nhan_vien) ON DELETE CASCADE,
foreign key(id_khach_hang) references khach_hang(id_khach_hang) ON DELETE CASCADE,
foreign key(id_dich_vu) references dich_vu(id_dich_vu) ON DELETE CASCADE,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tien int
);
create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int primary key auto_increment,
id_hop_dong int,
id_dich_vu_di_kem int,
foreign key(id_hop_dong) references hop_dong(id_hop_dong) ON DELETE CASCADE,
foreign key(id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem) ON DELETE CASCADE,
so_luong int
);
insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung) values('massage',100,5,'con moi');
insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung) values('karaoke',150,8,'con moi');
insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung) values('thuc an',80,18,'con moi');
insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung) values('nuoc uong',120,12,'con moi');
insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung) values('thue xe',200,10,'con moi');

-- task2
select * from casestudydatabase.nhan_vien 
where (nhan_vien.ho_ten like 'H%' or nhan_vien.ho_ten like 'T%'
or nhan_vien.ho_ten like 'K%') and length(nhan_vien.ho_ten) <=15;
-- task3
select * from casestudydatabase.khach_hang
where (year(curdate()) - year(khach_hang.ngay_sinh) >= 18 and year(curdate()) - year(khach_hang.ngay_sinh) <=50)
and (khach_hang.dia_chi = 'da nang' or khach_hang.dia_chi = 'quang tri');
