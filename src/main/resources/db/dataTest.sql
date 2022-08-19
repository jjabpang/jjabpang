create table jjabpang.cart
(
    cart_no bigint auto_increment
        primary key,
    cdt     datetime default CURRENT_TIMESTAMP null,
    crt_by  varchar(255)                       null,
    udt     datetime default CURRENT_TIMESTAMP null,
    upt_by  varchar(255)                       null,
    user_no bigint                             null
)
    engine = MyISAM
    charset = utf8mb4;

create index FKpgl0iqqyb5glqd67pu3xquq16
    on jjabpang.cart (user_no);

create table jjabpang.cart_item
(
    cart_item_no bigint auto_increment
        primary key,
    cdt          datetime default CURRENT_TIMESTAMP null,
    crt_by       varchar(255)                       null,
    udt          datetime default CURRENT_TIMESTAMP null,
    upt_by       varchar(255)                       null,
    item_count   int                                null,
    item_price   int                                null,
    cart         int                                null,
    item         bigint                             null
)
    engine = MyISAM
    charset = utf8mb4;

create index FKbm00xcycrn6molulecpuyulyc
    on jjabpang.cart_item (item);

create index FKknqhxrmf06u65u31yhsl1iswe
    on jjabpang.cart_item (cart);

create table jjabpang.category
(
    category_no    bigint auto_increment
        primary key,
    cdt            datetime default CURRENT_TIMESTAMP null,
    crt_by         varchar(255)                       null,
    udt            datetime default CURRENT_TIMESTAMP null,
    upt_by         varchar(255)                       null,
    category_depth int                                null,
    category_name  varchar(50)                        null,
    parent_no      int                                null
)
    engine = MyISAM
    charset = utf8mb4;

create table jjabpang.delivery
(
    delivery_no      bigint auto_increment
        primary key,
    cdt              datetime default CURRENT_TIMESTAMP null,
    crt_by           varchar(255)                       null,
    udt              datetime default CURRENT_TIMESTAMP null,
    upt_by           varchar(255)                       null,
    address1         varchar(50)                        null,
    address2         varchar(50)                        null,
    default_delivery char(3)  default 'Y'               null,
    delivery_name    varchar(20)                        null,
    phone_number     char(13)                           null,
    receiver         varchar(20)                        null,
    user_no          bigint                             null
)
    engine = MyISAM
    charset = utf8mb4;

create index FK5yrfwh9lafgj6yukerhr8q1rw
    on jjabpang.delivery (user_no);

create table jjabpang.item
(
    item_no       bigint auto_increment
        primary key,
    cdt           datetime      default CURRENT_TIMESTAMP null,
    crt_by        varchar(255)                            null,
    udt           datetime      default CURRENT_TIMESTAMP null,
    upt_by        varchar(255)                            null,
    brand_name    varchar(100)                            null,
    delivery_fee  int                                     null,
    detail        mediumtext                              null,
    discount_rate decimal(5, 2) default 0.00              null,
    image         varchar(800)                            null,
    price         int                                     null,
    quantity      int                                     null,
    rating_cnt    int           default 0                 null,
    rating_sum    decimal(4, 2) default 0.00              null,
    special_price int                                     null,
    title         varchar(500)                            null,
    category      bigint                                  null
)
    engine = MyISAM
    charset = utf8mb4;

create index FKt7c4we3bkvjqcli7ofu3kr71g
    on jjabpang.item (category);

create table jjabpang.jjim
(
    jjim_no bigint auto_increment
        primary key,
    cdt     datetime default CURRENT_TIMESTAMP null,
    crt_by  varchar(255)                       null,
    udt     datetime default CURRENT_TIMESTAMP null,
    upt_by  varchar(255)                       null,
    user_no bigint                             null
)
    engine = MyISAM;

create index FKnx4568xmnrbu45ui3l57oamyr
    on jjabpang.jjim (user_no);

create table jjabpang.jjim_item
(
    jjim_item_no bigint auto_increment
        primary key,
    cdt          datetime default CURRENT_TIMESTAMP null,
    crt_by       varchar(255)                       null,
    udt          datetime default CURRENT_TIMESTAMP null,
    upt_by       varchar(255)                       null,
    item_no      bigint                             null,
    jjim_no      bigint                             null
)
    engine = MyISAM;

create index FK62la0doomwwkmiab930l873n1
    on jjabpang.jjim_item (item_no);

create index FKe1389hji49ij01f61ngdoh8gm
    on jjabpang.jjim_item (jjim_no);

create table jjabpang.order_item
(
    order_item_no bigint auto_increment
        primary key,
    cdt           datetime default CURRENT_TIMESTAMP null,
    crt_by        varchar(255)                       null,
    udt           datetime default CURRENT_TIMESTAMP null,
    upt_by        varchar(255)                       null,
    price         int                                null,
    quantity      int                                null,
    item_no       bigint                             null,
    order_no      bigint                             null
)
    engine = MyISAM
    charset = utf8mb4;

create index FK5gwiclastnf73m8jqqrinfn5m
    on jjabpang.order_item (item_no);

create index FK64yctpiamtrlkbdp6lc626cy3
    on jjabpang.order_item (order_no);

create table jjabpang.orders
(
    order_no    bigint auto_increment
        primary key,
    cdt         datetime default CURRENT_TIMESTAMP null,
    crt_by      varchar(255)                       null,
    udt         datetime default CURRENT_TIMESTAMP null,
    upt_by      varchar(255)                       null,
    memo        varchar(300)                       null,
    status      varchar(10)                        null,
    delivery_no bigint                             null,
    user_no     bigint                             null
)
    engine = MyISAM
    charset = utf8mb4;

create index FK996j6iavflpcgsf7urs0bt0ha
    on jjabpang.orders (delivery_no);

create index FKk3nq0fbgx4q0bgxw9pqgak6dh
    on jjabpang.orders (user_no);

create table jjabpang.review
(
    review_no bigint auto_increment
        primary key,
    cdt       datetime default CURRENT_TIMESTAMP null,
    crt_by    varchar(255)                       null,
    udt       datetime default CURRENT_TIMESTAMP null,
    upt_by    varchar(255)                       null,
    del_yn    varchar(10)                        null,
    detail    varchar(3000)                      null,
    star_cnt  int                                null,
    summary   varchar(50)                        null,
    item_no   bigint                             null,
    user_no   bigint                             null
)
    engine = MyISAM
    charset = utf8mb4;

create index FK1yqarut4gof9pa1fa8e0i7v9v
    on jjabpang.review (item_no);

create index FKhctu9q3140kf2fsn2nfqr45ur
    on jjabpang.review (user_no);

create table jjabpang.review_image
(
    review_image_no bigint auto_increment
        primary key,
    cdt             datetime default CURRENT_TIMESTAMP null,
    crt_by          varchar(255)                       null,
    udt             datetime default CURRENT_TIMESTAMP null,
    upt_by          varchar(255)                       null,
    image_url       varchar(500)                       null,
    review_no       bigint                             null
)
    engine = MyISAM
    charset = utf8mb4;

create index FK1w12aeij5n35n95gvfurtuaxj
    on jjabpang.review_image (review_no);

create table jjabpang.user
(
    user_no         bigint auto_increment
        primary key,
    cdt             datetime    default CURRENT_TIMESTAMP null,
    crt_by          varchar(255)                          null,
    udt             datetime    default CURRENT_TIMESTAMP null,
    upt_by          varchar(255)                          null,
    agree_picu      varchar(5)  default '0'               null,
    agree_promotion varchar(5)  default '0'               null,
    agree_tos       varchar(5)  default '0'               null,
    birth           varchar(20)                           null,
    del_yn          varchar(5)  default 'n'               null,
    email           varchar(50)                           null,
    gender          varchar(5)  default 'm'               null,
    nickname        varchar(50)                           null,
    password        varchar(500)                          null,
    phone_nm        varchar(20)                           not null,
    role            varchar(20) default 'b'               null
)
    engine = MyISAM
    charset = utf8mb4;

