drop database if exists social_network;
create database social_network;
use social_network;
select database();

drop table if exists `comment`;
create table `comment`(
 `id` int(100) not null auto_increment,
 `author_name` varchar(350) not null,
 `post_id` int(100),
 primary key (`id`)
);

drop table if exists `post`;
create table `post`(
`post_id` int(100) not null auto_increment,
`title` varchar(500) not null,
 primary key (`post_id`)
);

alter table `comment`
add foreign key (`post_id`) references post(`post_id`);