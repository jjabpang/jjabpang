alter table `user`
    convert to charset utf8mb4;
alter table `item`
    convert to charset utf8mb4;

insert into `user` value (1, current_date, current_date, '0', '0', '0', '19951103', 'n', 'qkrtkdwns3410@naver.com', 'm',
                          'qkrtkdw', '1234', '01011111111', 'b');
insert into `user` value (2, current_date, current_date, '0', '0', '0', '19951203', 'n', 'qkrtkdwns3410@naver1.com',
                          'm', 'qkrtkdw2', '1234', '01011111111', 'b');
insert into `user` value (3, current_date, current_date, '0', '0', '0', '19941103', 'n', 'qkrtkdwns3410@naver2.com',
                          'm', 'qkrtkdw3', '1234', '01011111111', 'b');
insert into `user` value (4, current_date, current_date, '0', '0', '0', '19931103', 'n', 'qkrtkdwns3410@naver3.com',
                          'm', 'qkrtkdw4', '1234', '01011111111', 'b');
commit;