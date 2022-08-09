alter table jjabpang.user
    convert to charset utf8mb4;
alter table jjabpang.item
    convert to charset utf8mb4;
alter table jjabpang.cart
    convert to charset utf8mb4;
alter table jjabpang.cart_item
    convert to charset utf8mb4;
alter table jjabpang.category
    convert to charset utf8mb4;
alter table jjabpang.orders
    convert to charset utf8mb4;
alter table jjabpang.delivery
    convert to charset utf8mb4;
alter table jjabpang.order_item
    convert to charset utf8mb4;
alter table jjabpang.review
    convert to charset utf8mb4;
alter table jjabpang.review_image
    convert to charset utf8mb4;


-- 카테고리 추가
INSERT INTO jjabpang.category (category_no, cdt, udt, category_depth, category_name, parent_no)
VALUES (null, null, null, 1, '가전디지털', null);

INSERT INTO jjabpang.category (category_no, cdt, udt, category_depth, category_name, parent_no)
VALUES (null, null, null, 2, '청소기', 1);

INSERT INTO jjabpang.category (category_no, cdt, udt, category_depth, category_name, parent_no)
VALUES (null, null, null, 3, '스틱청소기', 2);

-- 유저 추가
insert into jjabpang.user(user_no, cdt, udt, agree_tos, agree_picu, agree_promotion, birth, del_yn, email, gender,
                          nickname, password, phone_nm, role) value (1,
                                                                     current_date,
                                                                     current_date,
                                                                     '0', '0',
                                                                     '0', '19951103',
                                                                     'n',
                                                                     'qkrtkdwns3410@naver.com',
                                                                     'm',
                                                                     'qkrtkdw', '1234',
                                                                     '01011111111', 'b');
insert into jjabpang.user(user_no, cdt, udt, agree_tos, agree_picu, agree_promotion, birth, del_yn, email, gender,
                          nickname, password, phone_nm, role) value (2, current_date, current_date,
                                                                     '0', '0', '0',
                                                                     '19951203', 'n',
                                                                     'qkrtkdwns3410@naver1.com',
                                                                     'm', 'qkrtkdw2', '1234',
                                                                     '01011111111', 'b');
insert into jjabpang.user(user_no, cdt, udt, agree_tos, agree_picu, agree_promotion, birth, del_yn, email, gender,
                          nickname, password, phone_nm, role) value (3, current_date, current_date,
                                                                     '0', '0', '0',
                                                                     '19941103', 'n',
                                                                     'qkrtkdwns3410@naver2.com',
                                                                     'm', 'qkrtkdw3', '1234',
                                                                     '01011111111', 'b');
insert into jjabpang.user(user_no, cdt, udt, agree_tos, agree_picu, agree_promotion, birth, del_yn, email, gender,
                          nickname, password, phone_nm, role) value (4, current_date, current_date,
                                                                     '0', '0', '0',
                                                                     '19931103', 'n',
                                                                     'qkrtkdwns3410@naver3.com',
                                                                     'm', 'qkrtkdw4', '1234',
                                                                     '01011111111', 'b');
-- 상품 추가
INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (1, '2022-08-07 16:07:45', null, '2022-08-03 00:00:00', null, '홈플래닛', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        2.00,
        'https://thumbnail9.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/852201942122386-8187777a-6bf5-4fb9-b042-7f45da3c8cc8.jpg',
        42900, 100, 6934, 4.00, null, '홈플래닛 2 in 1 무선 진공청소기 858B-DC, 화이트', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (2, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '디베아', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        2.00,
        'https://thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/16977221407792315-4d62c14b-9a63-45d7-953b-d9d0c29a875a.jpg',
        279000, 100, 12236, 4.00, null,
        '디베아 차이슨 무선청소기 ALLNEW22000 + UV터보브러쉬 + UV침구브러쉬 + NEW물걸레 키트 + 멀티카펫브러쉬 솔 + 헤파필터 2개, 혼합색상', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (3, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '홈플래닛', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        5.00,
        'https://thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/24628599404929-7fd7bec3-6738-44fb-94ae-0d2ba654c9b9.jpg',
        25600, 100, 4162, 4.00, null, '홈플래닛 2 IN 1 유선 청소기, 화이트+블랙, MC607B', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (4, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '클래파', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        8.00,
        'https://thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/10150009316506443-2c031284-02e4-46f6-98e9-fa25bba6e3c1.jpg',
        40900, 100, 4069, 4.00, null, '클래파 DC모터 다용도 미니 핸디형 무선청소기 BVC-H10, 화이트', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (5, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '하우리즈', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail6.coupangcdn.com/thumbnails/remote/230x230ex/image/rs_quotation_api/rspxubpj/b9e31d9839874a77ace95b5c58ee4519.jpg',
        40900, 100, 0, 0.00, null, '하우리즈 클린앤 유선청소기 NS-CV400, 핑크', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (6, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '일렉트로룩스', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        3.00,
        'https://thumbnail8.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/1137038450797678-ad8c196d-fa7e-420d-9345-8b11d2f3854d.jpg',
        164730, 100, 1883, 4.00, null, '일렉트로룩스 웰 Q6 무선 스틱청소기 WQ61-1OGG, 그라나이트 그레이', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (7, '2022-08-14 16:07:56', null, '2022-08-03 00:00:00', null, '아이닉', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        1.00,
        'https://thumbnail7.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/8590629775334856-725f6307-68af-4397-b2bd-232868d4ea9b.jpg',
        159000, 100, 2939, 4.00, null, '아이닉 차이슨 무선청소기 i20 Elite + UV헤드브러시 + UV침구브러시 + 필터, 화이트', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (8, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, 'iRoom', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/1569372406521263-abffb36e-daa8-4cab-9de6-27cdf1284f14.jpg',
        40900, 100, 2153, 4.00, null, 'iRoom 차이슨 무선청소기 AST-009 PLUS 거치대 패키지, 퍼플', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (9, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '삼성전자', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        7.00,
        'https://thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/2021/09/08/15/1/07bb44d9-cd8f-4aae-9006-b409ea7da509.jpg',
        553770, 100, 602, 5.00, null,
        '삼성전자 BESPOKE 제트 무선청소기 VS20A956A3B (VS20A956A31P VS20A956A31+VCA-SAE951) 자가설치, 미드나잇 블루', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (10, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '일렉트로룩스', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/71731179976847-7684cb7c-39b5-4c06-8bba-632f73f61eac.png',
        40900, 100, 2147, 5.00, null, '일렉트로룩스 에르고라피도 무선청소기 ZB3511DB, 데님 블루', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (11, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '홈플래닛', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        7.00,
        'https://thumbnail8.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/2019/12/23/18/5/164b42fd-0b19-4338-8bd6-a804630cf064.jpg',
        40200, 100, 3821, 4.00, null, '[쿠팡수입] 디어마 유선 청소기 DX700, 화이트', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (12, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '디베아', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        1.00,
        'https://thumbnail7.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/1829410707349279-de9c6841-9142-4ae1-9bc7-94c4795de5b1.jpg',
        199000, 100, 2954, 4.00, null, '아이닉 차이슨 무선청소기 NEW i20 + UV헤드브러시 + UV침구브러시 + 필터, 혼합색상', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (13, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '홈플래닛', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/rs_quotation_api/nqwxyob0/3e9770057e9f4e33b9b0c9742751f317.jpg',
        40900, 100, 0, 0.00, null, '하우리즈 클린앤 유선청소기 NS-CV400, 블루', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (14, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '클래파', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        4.00,
        'https://thumbnail7.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/1397149500543212-aa2cda2f-f5e3-4219-8ea5-3410305c6fe9.jpg',
        379000, 100, 4126, 5.00, null, '디베아 차이슨 무선청소기 ALLNEW29000 + 물걸레 키트 + 브러쉬 4종 + 필터2p 세트, 폴라나이트 그레이', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (15, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '하우리즈', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail7.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/249135674619-b4e17b9e-74ac-48fd-9199-3794c727a4e3.jpg',
        40900, 100, 13720, 4.00, null, '인터비즈 스틱앤 핸디 2 in 1 진공청소기 IB-VC0700, 그레이', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (16, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '일렉트로룩스', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/73178422483680-c97cde6a-9b8b-471c-b675-a699157aa30c.jpg',
        40900, 100, 2184, 4.00, null, '하우리즈 블랙나인 무선 청소기, 혼합색상, NS-WV200', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (17, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '아이닉', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        2.00,
        'https://thumbnail9.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/2021/02/25/13/2/703ee420-9bb5-455d-8c59-6e6135c33f81.jpg',
        39900, 100, 739, 4.00, null, '자일렉 에이블 핸디형 무선청소기 ZL-274H, 혼합색상', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (18, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, 'iRoom', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        9.00,
        'https://thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/vendor_inventory/5824/2c09a3516131d236ba044a8d51aea08149eb97027df4df1f1fedf418a355.jpg',
        1062500, 100, 1481, 5.00, null, 'LG전자 A9S 코드제로 무선청소기 A9370IK, 아이언그레이', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (19, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '삼성전자', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/303937481740922-a6ddc3f2-15a5-4368-bcf7-e034d77d6c65.jpg',
        40900, 100, 653, 4.00, null, '홈플래닛 650W파워 헤파필터 유선청소기 (필터/먼지통/본체 완전 분리 물청소), 혼합색상, HS-806', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (20, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '일렉트로룩스', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        6.00,
        'https://thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/2022/02/09/14/4/92c4622c-0023-48e2-9003-242bb79cf6b7.jpg',
        529000, 100, 459, 5.00, null, '삼성전자 BESPOKE 제트 청소기 VS20A956AVW 210W 자가설치, 미스티화이트', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (21, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '홈플래닛', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        5.00,
        'https://thumbnail8.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/2021/01/22/14/2/749a22ba-a753-40ab-8a3c-42cad8fcb1a6.jpg',
        199000, 100, 1835, 4.00, null,
        '[쿠팡수입] 디베아 무선청소기 ALL IN 1 NEW + 소프트 롤러 브러시 + 전동 회전 물걸레 + 간편 물걸레 키트 + 극세사 물걸레 6p + 침구 브러시 + 2 in 1 브러시 + 틈새 브러시, 화이트',
        3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (22, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '디베아', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        8.00,
        'https://thumbnail6.coupangcdn.com/thumbnails/remote/230x230ex/image/rs_quotation_api/wn60selc/0096fbf4ddd740a7a3c620af873271e3.jpg',
        61200, 100, 309, 4.00, null, '신일 핸디형 소형 유선 청소기, 화이트, SVC-R1000NX', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (23, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '홈플래닛', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail6.coupangcdn.com/thumbnails/remote/230x230ex/image/product/image/vendoritem/2019/01/29/3310103830/24a71b3c-f3ba-46ab-85d5-231a52143457.jpg',
        40900, 100, 4325, 4.00, null, 'iRoom 차이슨 무선청소기 AST-009 PLUS, 혼합색상', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (24, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '클래파', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/vendor_inventory/d531/13db3622638c4b64096f386d6752b870d6de4d9e0802db8f0db9de97cf81.png',
        40900, 100, 52, 5.00, null, '리하스 자동 흡입력 조절 무선청소기 S3, 화이트', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (25, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '하우리즈', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        4.00,
        'https://thumbnail9.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/719325324556172-66336353-1f4a-468d-af15-cb01ca084728.png',
        197290, 100, 89, 4.00, null, '일렉트로룩스 WELL Q7 파워프로 무선청소기 WQ71-2OIBF, 인디고 블루', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (26, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '일렉트로룩스', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        5.00,
        'https://thumbnail6.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/2021/12/14/16/7/f1cd102f-0730-4acf-8b09-9eff4504e986.jpg',
        129900, 100, 245, 4.00, null, '[쿠팡수입] 샤오미 미 무선 청소기 라이트, 혼합색상, MJWXCQ03DY', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (27, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '아이닉', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        3.00,
        'https://thumbnail9.coupangcdn.com/thumbnails/remote/230x230ex/image/rs_quotation_api/doyf6mgz/b1ee98cdc10f419c9657769ff6590483.jpg',
        236700, 100, 411, 4.00, null, '쿠쿠 인스퓨어 파워클론 무선 청소기 CVC-A1420UG, 어반그레이', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (28, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, 'iRoom', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail9.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/2022/03/08/15/0/35253e4e-829f-411c-a391-02f997b3f070.jpg',
        40900, 100, 4069, 4.00, null, '클래파 DC모터 다용도 미니 핸디형 무선청소기 BVC-H10, 그레이', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (29, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '삼성전자', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        6.00,
        'https://thumbnail6.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/2017/08/01/16/0/26095bb9-1f94-49b8-b4ed-de546952ea22.jpg',
        26230, 100, 1642, 4.00, null, '제이닉스 2 IN 1 유선청소기 JY-J370VC, 그레이', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (30, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '일렉트로룩스', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        4.00,
        'https://thumbnail8.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/1824682597558525-4e7d1394-f67a-4abc-b187-a12a2be4c17d.jpg',
        379000, 100, 4126, 5.00, null, '디베아 차이슨 무선청소기 ALLNEW29000 + 물걸레 키트 + 브러쉬 4종 + 필터2p 세트, 미드나이트 블랙', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (31, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '홈플래닛', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail8.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/53717773776713-4ce606b9-995c-450a-bb2a-b44bf7b1483a.jpg',
        40900, 100, 1128, 4.00, null, '홈플래닛 유선 청소기 S20, 화이트, V19T01A20S', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (32, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '디베아', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        7.00,
        'https://thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/2021/09/08/15/0/9329ba0b-80c8-41a1-84d2-7624d7989c62.jpg',
        571880, 100, 493, 5.00, null, '삼성전자 BESPOKE 제트 210W 무선청소기 자가설치, VS20A956A3W, 미스티화이트', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (33, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '홈플래닛', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        8.00,
        'https://thumbnail6.coupangcdn.com/thumbnails/remote/230x230ex/image/vendor_inventory/9ea9/c209dce11f598b052955ad30ed2f5764214c1b83cea8eb5f6a86cce548eb.jpg',
        64560, 100, 1787, 4.00, null, '삼성전자 무선 핸디 스틱 청소기 VC-H71, 에어본 + 뉴트럴 그레이', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (34, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '클래파', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        1.00,
        'https://thumbnail7.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/69106487571977-3bbc7beb-7dcf-41e8-b7e1-55ba686ccb39.jpg',
        58000, 100, 2821, 4.00, null, '보랄 Q10 무선 청소기 BR-Q390RV, 화이트', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (35, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '하우리즈', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        6.00,
        'https://thumbnail9.coupangcdn.com/thumbnails/remote/230x230ex/image/vendor_inventory/79c2/de7fb624a8a3df2ff965ee6571b4564a942dd7da0c012a149385f3f5ce19.jpg',
        15900, 100, 20, 5.00, null, '누심비 일렉트로룩스 뉴에르고라피도 호환 필터 무선청소기 4개 세트, 뉴에르고라피도 필터 4개', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (36, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '일렉트로룩스', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        8.00,
        'https://thumbnail8.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/2022/04/21/11/4/899d39d3-de9f-423f-a461-36b4ae65887c.jpg',
        569600, 100, 21, 5.00, null, 'LG전자 코드제로 A9S 무선청소기 AS9200BA, 블랙(본체), 그레이(충전대)', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (37, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '아이닉', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/rs_quotation_api/6xjc015u/ffed2a1a82e945819c0951f3c20a2c56.jpg',
        166320, 100, 674, 5.00, null, '아이룸 차이슨 KHAN 무선청소기 A15 + 거치대 세트, 화이트', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (38, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, 'iRoom', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/979967972170386-9acf816f-0fad-48b6-970a-cac83940522f.jpg',
        40900, 100, 350, 4.00, null, '홈플래닛 100W파워 HEPA 무선청소기 + 충전거치대, 화이트, A31', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (39, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '삼성전자', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        5.00,
        'https://thumbnail8.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/519429682362369-f482d782-2525-4540-98a5-059ce1063a2b.jpg',
        179000, 100, 186, 5.00, null, '한경희생활과학 저소음 무선청소기 HE-C287, 화이트 + 레드', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (40, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '일렉트로룩스', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        2.00,
        'https://thumbnail6.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/72872876141408-d427d3f3-d2dc-4129-a201-4d736cec46a6.jpg',
        249480, 100, 233, 4.00, null, '일렉트로룩스 웰 Q7 무선 스틱청소기 WQ71-2BSWF, 사틴 화이트', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (41, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '홈플래닛', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        8.00,
        'https://thumbnail7.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/2021/07/02/10/8/3bab3b1e-9c32-4152-ad16-e073ee003ef8.jpg',
        17400, 100, 53, 4.00, null, '트루쎈 디베아 / 차이슨 / 캐치웰 호환 무선 청소기 충전기', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (42, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '디베아', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        6.00,
        'https://thumbnail9.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/606749554968943-95b680a2-e01b-482d-ae98-34b92c875bbf.jpg',
        39800, 100, 3821, 4.00, null, '[쿠팡수입] 디어마 유선 청소기 DX700, 다크 그레이', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (43, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '홈플래닛', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        1.00,
        'https://thumbnail6.coupangcdn.com/thumbnails/remote/230x230ex/image/rs_quotation_api/9s99dk0j/c964ab52caaf48d29438528325fabcd2.jpg',
        74300, 100, 122, 4.00, null, '신일 싸이클론 2 in 1 스틱 앤 핸디형 무선 청소기 SVC-599WS, 혼합색상', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (44, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '클래파', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail7.coupangcdn.com/thumbnails/remote/230x230ex/image/vendor_inventory/93a6/3d167d167150a02ee8cfbf13056c51d4409c9160738dba003227174cd2b5.jpg',
        40900, 100, 36, 5.00, null, '삼성전자 BESPOKE 제트 스틱청소기 220W VS20B957F5E 자가설치, 산토리니 베이지', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (45, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '하우리즈', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        3.00,
        'https://thumbnail9.coupangcdn.com/thumbnails/remote/230x230ex/image/rs_quotation_api/ehrzejzp/54511bb546df464fbeb61a183b8db1ac.jpg',
        995000, 100, 209, 5.00, null, 'LG전자 코드제로 A9S 오브제 올인원타워 무선청소기 AO9471WKT, 카밍베이지', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (46, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '일렉트로룩스', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        5.00,
        'https://thumbnail8.coupangcdn.com/thumbnails/remote/230x230ex/image/rs_quotation_api/l2hzemws/46d390e868f942b695d0cc04931d0e4f.jpg',
        189000, 100, 87, 4.00, null, '삼성전자 파워스틱 무선청소기 VS02R6512JG, 뉴트럴 그레이', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (47, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '아이닉', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        5.00,
        'https://thumbnail9.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/3665121375531520-5e7d8cb8-c6c5-45e5-9024-7f87e8049128.jpg',
        135400, 100, 803, 4.00, null, '홈플래닛 350W파워 무선청소기 + 터보헤드 + UV침구헤드 + 물걸레키트 + 필터2개 + 카펫브러쉬, 혼합색상, LIS-AW01-7SW',
        3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (48, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, 'iRoom', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/vendor_inventory/646e/50875b7302e4339ff47c45c07b924e2fce4c9f95c92bcc09e3e8fca268cb.jpg',
        270000, 100, 1250, 5.00, null, '2022년형 차이슨무선청소기 아이룸 제우스 진공청소기, 제우스 단품', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (49, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '삼성전자', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail7.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/2021/06/15/16/0/df8158d9-246c-4ff0-bde2-7b619076b6ef.jpg',
        226460, 100, 463, 5.00, null, '일렉트로룩스 Well Q7 무선 청소기 WQ71-2OIB, 인디고 블루', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (50, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '일렉트로룩스', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        3.00,
        'https://thumbnail7.coupangcdn.com/thumbnails/remote/230x230ex/image/product/image/vendoritem/2019/01/10/4194708560/1b953a51-49a0-4208-827c-f2207cfc75f5.jpg',
        89910, 100, 808, 4.00, null, '일렉트로룩스 다이나미카 프로 유선 스틱청소기 EDYL35IW/OR, 아이스 화이트, EDYL35IW', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (51, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '홈플래닛', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        9.00,
        'https://thumbnail6.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/234827244497072-05bdab7e-1100-43ee-84bc-c41d92d68b94.jpg',
        267600, 100, 790, 5.00, null, '[쿠팡수입] 퍼피유 강력 파워 자동 흡입조절 무선 청소기 + 물걸레키트 + 벽걸이형 충전 거치대 + 물걸레, T12 Home, 혼합색상', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (52, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '디베아', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        8.00,
        'https://thumbnail6.coupangcdn.com/thumbnails/remote/230x230ex/image/vendor_inventory/ec06/cd63de37a0b591cc64d2b4145ca22545e13db5ee367bd4cd1e1dbfc9f8f6.png',
        1350000, 100, 301, 5.00, null, 'LG전자 코드제로 오브제 올인원타워 무선청소기 AO9571WKT, 카밍베이지', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (53, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '홈플래닛', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail7.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/1305358867773927-2d09702d-7989-4744-8bfc-e13731751262.jpg',
        40900, 100, 191, 4.00, null, '신일 하이그로시 무선 진공청소기 SVC-B880, 블랙', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (54, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '클래파', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        5.00,
        'https://thumbnail9.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/8240472301911694-328e2771-f043-4fc9-83d9-c03cfd6de8d5.jpg',
        398000, 100, 383, 5.00, null, '하우리즈 트윈즈 BLDC 물걸레 진공 무선 청소기, 그레이, NS-WV250', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (55, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '하우리즈', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        7.00,
        'https://thumbnail6.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/596598954891608-27324f0b-05b5-43ec-92b1-50071968caf1.jpg',
        129000, 100, 445, 4.00, null, '캐치웰 무선청소기 + 스탠드거치대 + 헤파필터 2p + 브러시 2종 + 액세서리 2종 세트, 혼합색상, CV6 PLUS addition', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (56, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '일렉트로룩스', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail7.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/542886371058164-efb15b97-0b19-4692-8eec-02a46b428b29.jpg',
        40900, 100, 374, 4.00, null, '보아르 포스D14 무선 핸디 진공 청소기 VCL-004WH, 화이트', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (57, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '아이닉', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail8.coupangcdn.com/thumbnails/remote/230x230ex/image/vendor_inventory/7fce/1ed23aec138f74c4e294a580dc1deae1d625a7a92828e9789830ff19af1c.jpg',
        40900, 100, 32, 4.00, null, '일렉트로룩스 에르고라피도 무선청소기 ZB3512IG', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (58, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, 'iRoom', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        1.00,
        'https://thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/vendor_inventory/dfa5/4bcc6ffdc96cfa6e6bbd5572cce4f9f52a930f58c160863363397a6e25a5.jpg',
        99000, 100, 1589, 4.00, null, 'iRoom 싸이클 무선 청소기 MINI A20, 혼합색상', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (59, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '삼성전자', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        0.00,
        'https://thumbnail8.coupangcdn.com/thumbnails/remote/230x230ex/image/retail/images/4879160818349854-f42f95b0-52b0-4dba-9d57-20233b68567d.jpg',
        40900, 100, 688, 4.00, null, '신일 BLDC 멀티 싸이클론 무선청소기 SVC-9958PNX, 스카이블루', 3);

INSERT INTO jjabpang.item (item_no, cdt, crt_by, udt, upt_by, brand_name, delivery_fee, detail, discount_rate, image,
                           price, quantity, rating_cnt, rating_sum, special_price, title, category)
VALUES (60, '2022-08-03 00:00:00', null, '2022-08-03 00:00:00', null, '일렉트로룩스', 0,
        'http://image1.coupangcdn.com/image/vendor_inventory/6331/cda2696406077a40ef9cb65295a9db9254e69262703cf6a58638ec512217.jpg',
        9.00,
        'https://thumbnail9.coupangcdn.com/thumbnails/remote/230x230ex/image/vendor_inventory/dfc4/ee836b2e4caa0c80085bde77dc5b2e77d220fd66978640c76a7c23f6efed.jpg',
        99000, 100, 1008, 4.00, null, '아이룸 차이슨 무선청소기 마카롱 M20, 베이비핑크', 3);


-- 배송지 추가
INSERT INTO jjabpang.delivery (cdt, udt, address1, address2, default_delivery, delivery_name, phone_number, receiver,
                               user_no)
VALUES (DEFAULT, DEFAULT, '서울특별시 관악구 신림동', '우리우리집', 'Y', '우리집', '01011111111', '''10013021''', 1);

INSERT INTO jjabpang.delivery (cdt, udt, address1, address2, default_delivery, delivery_name, phone_number, receiver,
                               user_no)
VALUES (DEFAULT, DEFAULT, '서울특별시 관악구 신림동', '우리우리집', 'N', '너네집', '01022222222', '''10013021''', 1);

INSERT INTO jjabpang.delivery (cdt, udt, address1, address2, default_delivery, delivery_name, phone_number, receiver,
                               user_no)
VALUES (DEFAULT, DEFAULT, '서울특별시 관악구 신림동', '우리우리집', 'N', '자기집', '01011111111', '''10013021''', 1);

INSERT INTO jjabpang.delivery (cdt, udt, address1, address2, default_delivery, delivery_name, phone_number, receiver,
                               user_no)
VALUES (DEFAULT, DEFAULT, '서울특별시 관악구 신림동', '우리우리집', 'N', '희망집', '01022222222', '''10013021''', 1);

INSERT INTO jjabpang.delivery (cdt, udt, address1, address2, default_delivery, delivery_name, phone_number, receiver,
                               user_no)
VALUES (DEFAULT, DEFAULT, '서울특별시 관악구 신림동', '우리우리집', 'N', '2번집', '01011111111', '''10013021''', 2);

INSERT INTO jjabpang.delivery (cdt, udt, address1, address2, default_delivery, delivery_name, phone_number, receiver,
                               user_no)
VALUES (DEFAULT, DEFAULT, '서울특별시 관악구 신림동', '우리우리집', 'N', '2_1번집', '01011111111', '''10013021''', 2);

INSERT INTO jjabpang.delivery (cdt, udt, address1, address2, default_delivery, delivery_name, phone_number, receiver,
                               user_no)
VALUES (DEFAULT, DEFAULT, '서울특별시 관악구 신림동', '우리우리집', 'N', '3번집', '01022222222', '''10013021''', 3);

INSERT INTO jjabpang.delivery (cdt, udt, address1, address2, default_delivery, delivery_name, phone_number, receiver,
                               user_no)
VALUES (DEFAULT, DEFAULT, '서울특별시 관악구 신림동', '우리우리집', 'N', '3번_2집', '01011111111', '''10013021''', 3);

INSERT INTO jjabpang.delivery (cdt, udt, address1, address2, default_delivery, delivery_name, phone_number, receiver,
                               user_no)
VALUES (DEFAULT, DEFAULT, '서울특별시 관악구 신림동', '우리우리집', 'Y', '4번기본집', '01011111111', '''10013021''', 4);

INSERT INTO jjabpang.delivery (cdt, udt, address1, address2, default_delivery, delivery_name, phone_number, receiver,
                               user_no)
VALUES (DEFAULT, DEFAULT, '서울특별시 관악구 신림동', '우리우리집', 'N', '4번', '01022222222', '''10013021''', 4);

-- 주문 추가
INSERT INTO jjabpang.orders (cdt, udt, memo, status, user_no)
VALUES (DEFAULT, DEFAULT, '메모', 'ORDER', 1);

INSERT INTO jjabpang.orders (cdt, udt, memo, status, user_no)
VALUES (DEFAULT, DEFAULT, '메모', 'ORDER', 1);

INSERT INTO jjabpang.orders (cdt, udt, memo, status, user_no)
VALUES (DEFAULT, DEFAULT, '메모', 'ORDER', 1);

INSERT INTO jjabpang.orders (cdt, udt, memo, status, user_no)
VALUES (DEFAULT, DEFAULT, '메모', 'ORDER', 2);

INSERT INTO jjabpang.orders (cdt, udt, memo, status, user_no)
VALUES (DEFAULT, DEFAULT, '메모', 'ORDER', 2);

INSERT INTO jjabpang.orders (cdt, udt, memo, status, user_no)
VALUES (DEFAULT, DEFAULT, '메모', 'ORDER', 3);

INSERT INTO jjabpang.orders (cdt, udt, memo, status, user_no)
VALUES (DEFAULT, DEFAULT, '메모', 'ORDER', 4);
-- 주문 아이템 추가
INSERT INTO jjabpang.order_item (cdt, crt_by, udt, upt_by, price, quantity, item_no, order_no)
VALUES (DEFAULT, null, DEFAULT, null, 5000, 2, 1, 1);

INSERT INTO jjabpang.order_item (cdt, crt_by, udt, upt_by, price, quantity, item_no, order_no)
VALUES (DEFAULT, null, DEFAULT, null, 10000, 3, 1, 2);

INSERT INTO jjabpang.order_item (cdt, crt_by, udt, upt_by, price, quantity, item_no, order_no)
VALUES (DEFAULT, null, DEFAULT, null, 3000, 4, 1, 3);

INSERT INTO jjabpang.order_item (cdt, crt_by, udt, upt_by, price, quantity, item_no, order_no)
VALUES (DEFAULT, null, DEFAULT, null, 4000, 5, 2, 4);

INSERT INTO jjabpang.order_item (cdt, crt_by, udt, upt_by, price, quantity, item_no, order_no)
VALUES (DEFAULT, null, DEFAULT, null, 10000, 6, 2, 5);

INSERT INTO jjabpang.order_item (cdt, crt_by, udt, upt_by, price, quantity, item_no, order_no)
VALUES (DEFAULT, null, DEFAULT, null, 20000, 7, 3, 6);

INSERT INTO jjabpang.order_item (cdt, crt_by, udt, upt_by, price, quantity, item_no, order_no)
VALUES (DEFAULT, null, DEFAULT, null, 5000, 8, 3, 7);

INSERT INTO jjabpang.order_item (cdt, crt_by, udt, upt_by, price, quantity, item_no, order_no)
VALUES (DEFAULT, null, DEFAULT, null, 5000, 2, 3, 1);

-- 장바구니 추가
INSERT INTO jjabpang.cart (cart_no, cdt, crt_by, udt, upt_by, user_no)
VALUES (1, '2022-08-08 17:29:20', null, '2022-08-08 17:29:20', null, 1);

-- 장바구니 아이템 추가
INSERT INTO jjabpang.cart_item (cart_item_no, cdt, crt_by, udt, upt_by, item_count, item_price, cart, item)
VALUES (1, '2022-08-08 17:29:20', null, '2022-08-08 17:29:25', null, 12, 1000, 1, 1);

INSERT INTO jjabpang.cart_item (cart_item_no, cdt, crt_by, udt, upt_by, item_count, item_price, cart, item)
VALUES (null, '2022-08-08 17:29:20', null, '2022-08-08 17:29:25', null, 12, 1000, 1, 2);

INSERT INTO jjabpang.cart_item (cart_item_no, cdt, crt_by, udt, upt_by, item_count, item_price, cart, item)
VALUES (null, '2022-08-08 17:29:20', null, '2022-08-08 17:29:25', null, 12, 1000, 1, 3);

INSERT INTO jjabpang.cart_item (cart_item_no, cdt, crt_by, udt, upt_by, item_count, item_price, cart, item)
VALUES (null, '2022-08-08 17:29:20', null, '2022-08-08 17:29:25', null, 12, 1000, 1, 41);

-- 리뷰 추가
INSERT INTO jjabpang.review (cdt, crt_by, udt, upt_by, del_yn, detail, star_cnt, summary, item_no, user_no)
VALUES (DEFAULT, null, DEFAULT, null, 'n', '디테일', 4, '요약', 1, 1);

INSERT INTO jjabpang.review (cdt, crt_by, udt, upt_by, del_yn, detail, star_cnt, summary, item_no, user_no)
VALUES (DEFAULT, null, DEFAULT, null, 'n', '디테일', 4, '요약', 2, 1);

INSERT INTO jjabpang.review (cdt, crt_by, udt, upt_by, del_yn, detail, star_cnt, summary, item_no, user_no)
VALUES (DEFAULT, null, DEFAULT, null, 'n', '디테일', 4, '요약', 3, 1);

INSERT INTO jjabpang.review (cdt, crt_by, udt, upt_by, del_yn, detail, star_cnt, summary, item_no, user_no)
VALUES (DEFAULT, null, DEFAULT, null, 'n', '디테일', 4, '요약', 4, 1);

INSERT INTO jjabpang.review (cdt, crt_by, udt, upt_by, del_yn, detail, star_cnt, summary, item_no, user_no)
VALUES (DEFAULT, null, DEFAULT, null, 'n', '디테일', 4, '요약', 1, 1);



commit;