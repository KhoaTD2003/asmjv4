use master
go

create database asmjava4
go

use asmjava4
go

create table [user]
(
	id			int				primary key identity,
	username		varchar(10)		unique not null,
	[password]	nvarchar(10)	not null,
	email		nvarchar(50)	unique not null,
	isAdmin		bit				not null default 0,
	isActive 	bit				not null default 1
)
go

create table video
(
	id			int				primary key identity,
	title		nvarchar(255)	not null,
	href		nvarchar(50)	unique not null,
	poster		nvarchar(255)	null,
	[views]		int				not null default 0,
	shares		int				not null default 0,
	[description] nvarchar(255)
)
go 

create table history
(
	id			int				primary key identity,
	userId		int				foreign key references [user](id),
	videoId		int				foreign key references video(id),
	viewedate	datetime		not null default getDate(),
	isLiked		bit				not null default 0,
	likedDate	datetime		null
 
)
go


insert into [user] (username, [password], email, isAdmin) values 

('duynt','111', 'nguyentranduy94@gmail.com',1),
('hangtran','222', 'nguyentr.duy@gmail.com',0)

go


insert into video (title, href, [description]) values

(N'Ông Thầy Tào Lao - Trấn Thành, Trường Giang, Khả Như',	'iIalwR98Ny4',		N'Trấn Thành, Trường Giang, Khả Như'),
(N'HÀI KỊCH || GIẢI HẠN || TRẦN THÀNH - ANH ĐỨC',			'AEjv3tFncGQ',		 N'Trấn Thành - Anh Đức'),
(N'Thần Tiên Cũng Nổi Điên',								'NbX-JZXIgok',		N'Hoài Linh, Chí Tài, Trường Giang')

go


insert into history (userId, videoId, isLiked, likedDate) values
(2, 1, 1, getDate()),
(2,3, 0, null)

go