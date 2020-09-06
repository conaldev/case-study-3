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
                        parent_id int not null default 0,
                        sort_order tinyint(4) not null default 0

)ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=6 ;
create table product
(
    id          int(255)                                               not null auto_increment primary key,
    catalog_id  int                                                    not null,
    name        varchar(100)                                           not null collate utf8_unicode_ci,
    price       decimal(15, 4)                                         not null default '0,0000',
    discount    int(11)                                                not null,
#     ảnh sản phẩm
    image_link  varchar(50) character set utf8 collate utf8_unicode_ci not null,
#     ảnh kèm theo khi click vào ảnh sản phẩm
    image_list  text                                                   not null,
#     đếm số lượng đã bán ra
    count_buy   int,
#     đếm lượt xem
    count_views int,
#     tình trạng hàng
    product_status text
);
create table transaction(
                            id int primary key not null auto_increment,
                            user_id int not null ,
                            user_name varchar(100) not null ,
                            user_email varchar(100),
                            user_phone varchar(20) not null ,
                            total_amount decimal(15,2) not null,
                            payment varchar(50) not null ,
                            payment_info text not null ,
                            messeges varchar(255),
                            security varchar(40),
                            transaction_status tinyint(2),
                            transaction_time int(11)
);
create table bill (
                      id int primary key not null auto_increment,
                      transaction_id int not null ,
                      product_id int not null ,
                      qty int not null ,
                      amout decimal(15,2) not null ,
                      data text ,
                      status tinyint
);
