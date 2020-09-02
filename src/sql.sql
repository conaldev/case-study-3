create database latopaz;
use latopaz;
CREATE TABLE IF NOT EXISTS admin (
                                       id int(11) NOT NULL AUTO_INCREMENT,
                                       username varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
                                       password varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
                                       name varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
                                       PRIMARY KEY (id)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=6 ;
CREATE TABLE user(
    id int not null auto_increment,
    name varchar(50) character set utf8 collate utf8_unicode_ci not null ,
    email varchar(100) character set utf8 collate utf8_unicode_ci not null ,
    phone varchar(15) character set utf8 collate utf8_unicode_ci not null ,
    password varchar(50) character set  utf8 collate utf8_unicode_ci not null ,
    address varchar(100) character set utf8 collate utf8_unicode_ci,
    created int(11) not null,
    primary key (id)


)ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=6 ;
create table catalog(
    id int not null primary key auto_increment,
    name varchar(50) character set utf8 collate utf8_unicode_ci not null ,

)