create database JB;
use JB;
drop table Songs;
create table Songs(song_id int primary key,song_name varchar(30),genre varchar(20),duration Time,album varchar(30),artist_name varchar(30),song_url varchar(50));
insert into Songs values(101,'kannuladha','Romance','00:03:26','3 Tamil','Anirudh','C:\\assignments NIIT\\Songs\\3 Tamil.wav');
insert into Songs values(102,'Believer','Motivational','00:03:24','Imagine Dragon','Jackson','C:\\assignments NIIT\\Songs\\Believer.wav');
insert into Songs values(103,'Despacito','Happy mood','00:04:41','Spanish famous','Yoyo','C:\\assignments NIIT\\Songs\\Despacito.wav');
insert into Songs values(104,'FairyTale','Heart Broken','00:03:00','American Rock','Justin','C:\\assignments NIIT\\Songs\\FairyTale.wav');
insert into Songs values(105,'Naatu Naatu','Mass','00:03:28','RRR','Chandra','C:\\assignments NIIT\\Songs\\Naatu Naatu.wav');
insert into Songs values(106,'Raa Mundhadugedham','Patriotic','00:06:47','Kanche','Sitaramayasastri','C:\\assignments NIIT\\Songs\\Raa Mundhadugedham.wav');
insert into Songs values(107,'Shape of you','Romance','00:03:54','Private','Ed sheeran','C:\\assignments NIIT\\Songs\\Shape of you.wav');
insert into Songs values(108,'Tharagadhi','Love','00:03:33','Color photo','sriram','C:\\assignments NIIT\\Songs\\Tharagadhi.wav');
insert into Songs values(109,'Thunder','Motivational','00:03:24','Imagine Dragon','Jackson','C:\\assignments NIIT\\Songs\\Thunder.wav');
insert into Songs values(110,'Yadagara','Motivational','00:02:57','KGF','Ravi Basrur','C:\\assignments NIIT\\Songs\\Yadagara.wav');
select*from Songs;
create table Podcast(podcast_id int primary key, celebrity varchar(25),duration time,published_date Date,podcast_name varchar(30),podcast_url varchar(60));
insert into podcast values(501,'Dhanush','00:03:30','2020-05-23','The self love','C:\\assignments NIIT\\Podcast\\Dhanush.wav');
insert into podcast values(502,'Karthee','00:04:54','2019-12-31','The side effects of love','C:\\assignments NIIT\\Podcast\\Karthee.wav');
insert into podcast values(503,'NTR','00:04:00','2020-07-13','Imporatnce of nature','C:\\assignments NIIT\\Podcast\\NTR.wav');
insert into podcast values(504,'Prabhas','00:03:11','2019-02-26','The history','C:\\assignments NIIT\\Podcast\\Prabhas.wav');
insert into podcast values(505,'RajniKanth','00:03:38','2018-11-11','power of me','C:\\assignments NIIT\\Podcast\\Rajnikanth.wav');
insert into podcast values(506,'Ram Charan','00:04:43','2016-08-18','Enjoy every moment','C:\\assignments NIIT\\Podcast\\Ram Charan.wav');
select *from podcast;
create table user(userid int primary key auto_increment,username varchar(50) not null,password varchar(30) not null)auto_increment=11111; 
insert into user values(1001,'Ashok','ashok@#123');
insert into user values(1002,'Sai','Sai@#123');
insert into user values(1003,'Lokesh','Lokesh@#123');
insert into user values(1004,'Prasad','Prasad@#123');
insert into user values(1005,'Swathi','Swathi@#123');
insert into user values(1006,'Kiran','Kiran@#123');
select * from user;
create table playlists(playlistId int primary key auto_increment,userId int not null,foreign key(userId) references user(userId) on delete cascade,playlistName varchar(50))auto_increment=1111;
insert into playlists values(2001,1001,'Heart');
insert into playlists values(2002,1002,'Melody');
insert into playlists values(2003,1003,'Star');
insert into playlists values(2004,1003,'Summer');
insert into playlists values(2005,1004,'Love');
insert into playlists values(2006,1006,'Broken');
insert into playlists(userid,playlistname) values(1001,'kalyan');
select * from playlists;

insert into audio values (2008,102,null);

select * from audio;



create table Audio(playlistId int,foreign key(playlistId) references playlists(playlistId) on delete cascade,song_id int, foreign key(song_Id) references songs(song_Id),podcast_Id int,foreign key(podcast_Id) references podcast(podcast_Id));
insert into Audio values(2001,101,null);
insert into Audio values(2002,null,null);
insert into Audio values(2003,null,501);
insert into Audio values(2002,102,null);
insert into Audio values(2004,101,502);
select * from audio;


