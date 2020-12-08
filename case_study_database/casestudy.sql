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
-- task4 
select khach_hang.ho_ten,count(hop_dong.id_khach_hang) as solandatphong,khach_hang.id_loai_khach
from khach_hang join hop_dong on
khach_hang.id_khach_hang = hop_dong.id_khach_hang where id_loai_khach = 1
group by hop_dong.id_khach_hang
order by solandatphong;
-- task5
select khach_hang.id_khach_hang,khach_hang.ho_ten,loai_khach.ten_loai_khach,
hop_dong.id_hop_dong,dich_vu.ten_dich_vu,hop_dong.ngay_lam_hop_dong,
hop_dong.ngay_ket_thuc,sum(dich_vu.chi_phi_thue + dich_vu_di_kem.gia*hop_dong_chi_tiet.so_luong) as tongtien
from khach_hang 
left join loai_khach on khach_hang.id_loai_khach = loai_khach.id_loai_khach
left join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang
left join dich_vu on hop_dong.id_dich_vu = dich_vu.id_dich_vu
left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
group by khach_hang.ho_ten;
-- task6
select dich_vu.id_dich_vu,dich_vu.ten_dich_vu,hop_dong.ngay_lam_hop_dong,dich_vu.dien_tich,dich_vu.chi_phi_thue,
loai_dich_vu.ten_loai_dich_vu from dich_vu
join loai_dich_vu on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu
left join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
where not(year(hop_dong.ngay_lam_hop_dong) = 2019 and month(hop_dong.ngay_lam_hop_dong) in(1,2,3));
-- task7
select dich_vu.id_dich_vu,dich_vu.ten_dich_vu,dich_vu.dien_tich,dich_vu.so_nguoi_toi_da,
dich_vu.chi_phi_thue,loai_dich_vu.ten_loai_dich_vu,ngay_lam_hop_dong from dich_vu 
join loai_dich_vu on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu
join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
where year(ngay_lam_hop_dong) = 2018 and hop_dong.id_dich_vu not 
in (select hop_dong.id_dich_vu from hop_dong where year(ngay_lam_hop_dong) = 2019);
-- task8
select distinct khach_hang.ho_ten from khach_hang;
select khach_hang.ho_ten from khach_hang group by khach_hang.ho_ten;
select khach_hang.ho_ten from khach_hang 
union
select khach_hang.ho_ten from khach_hang;
-- task9
select month(hop_dong.ngay_lam_hop_dong) as thang,count(month(ngay_lam_hop_dong)) as songuoidatphong
from hop_dong where year(ngay_lam_hop_dong)=2019
group by month(ngay_lam_hop_dong)
order by month(ngay_lam_hop_dong);
-- task10
select hop_dong.id_hop_dong,hop_dong.ngay_lam_hop_dong,hop_dong.ngay_ket_thuc,
hop_dong.tien_dat_coc,count(hop_dong_chi_tiet.id_dich_vu_di_kem) as soluongdichvudikem
from hop_dong 
join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
group by hop_dong_chi_tiet.id_hop_dong
order by hop_dong_chi_tiet.id_hop_dong;
-- task11
select khach_hang.ho_ten,khach_hang.dia_chi,loai_khach.ten_loai_khach, 
dich_vu_di_kem.ten_dich_vu_di_kem,dich_vu_di_kem.gia from khach_hang
join loai_khach on khach_hang.id_loai_khach = loai_khach.id_loai_khach
join hop_dong on hop_dong.id_khach_hang = khach_hang.id_khach_hang
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
where ten_loai_khach = 'Diamond' and dia_chi in ('Vinh','quang ngai');
-- task12
select hop_dong.id_hop_dong,nhan_vien.ho_ten,khach_hang.ho_ten,khach_hang.sdt,
dich_vu.ten_dich_vu,count(hop_dong_chi_tiet.id_dich_vu_di_kem) as soluongdichvudikem,
hop_dong.tien_dat_coc from khach_hang 
join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang
join nhan_vien on nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
join dich_vu on hop_dong.id_dich_vu = dich_vu.id_dich_vu
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
where ((year(ngay_lam_hop_dong) = 2019 and month(ngay_lam_hop_dong) in(10,11,12))
and hop_dong.id_dich_vu not 
in (select hop_dong.id_dich_vu from hop_dong where year(ngay_lam_hop_dong)=2019 and month(ngay_lam_hop_dong) in(1,2,3,4,5,6)))
group by hop_dong_chi_tiet.id_dich_vu_di_kem;
-- task13
select * from
(select dich_vu_di_kem.ten_dich_vu_di_kem,count(hop_dong_chi_tiet.id_dich_vu_di_kem) as solansudung 
from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
group by hop_dong_chi_tiet.id_dich_vu_di_kem) as abc
where solansudung = (select count(hop_dong_chi_tiet.id_dich_vu_di_kem) from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
group by hop_dong_chi_tiet.id_dich_vu_di_kem 
order by count(hop_dong_chi_tiet.id_dich_vu_di_kem) desc
limit 1);
-- task 14
select hop_dong.id_hop_dong,loai_dich_vu.ten_loai_dich_vu,dich_vu_di_kem.ten_dich_vu_di_kem,
count(hop_dong_chi_tiet.id_dich_vu_di_kem) as solansudung from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
join hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
group by hop_dong_chi_tiet.id_dich_vu_di_kem
having solansudung = 1;
-- task 15
select nhan_vien.id_nhan_vien,nhan_vien.ho_ten,trinh_do.ten_trinh_do,bo_phan.ten_bo_phan,nhan_vien.sdt,
nhan_vien.dia_chi,count(hop_dong.id_nhan_vien) as solanlamhopdong, 
year(hop_dong.ngay_lam_hop_dong) as nam_hop_dong from bo_phan
join nhan_vien on nhan_vien.id_bo_phan = bo_phan.id_bo_phan
join trinh_do on nhan_vien.id_trinh_do = trinh_do.id_trinh_do
join hop_dong on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
group by hop_dong.id_nhan_vien
having (nam_hop_dong between 2018 and 2019) and solanlamhopdong <= 3;
-- task16
delete from nhan_vien where nhan_vien.id_nhan_vien not
in(select hop_dong.id_nhan_vien from hop_dong 
where year(hop_dong.ngay_lam_hop_dong) between 2017 and 2020); 
-- task17
update khach_hang set khach_hang.id_loai_khach = 1 
where khach_hang.id_loai_khach = 2 and 


