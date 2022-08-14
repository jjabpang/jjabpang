# 짭팡 (jjab_pang)

---

### 1. Project Progress

1. Initial ERD

>

2. Mock-Up

> 쿠팡 사이트클론 : https://www.figma.com/file/Fm62pxMOLegL4XotlC7IJc/%EC%BF%A0%ED%8C%A1%EB%AA%A9%EC%97%85?node-id=0%3A1

3. Skills
    1. Spring boot 2.2.2 REALESE
    2. Spring Data Jpa
    3. QueryDsl
    4. JWT & Spring Security

# JjabPang

쿠팡 클론 프로젝트

※ 백엔드 + 프론트 엔드 협업 프로젝트

# 목차

- [개발 환경](#개발-환경)
- [사용 기술](#사용-기술)
    * [백엔드](#백엔드)
    * [프론트엔드](#프론트엔드)
    * [기타 주요 라이브러리](#기타-주요-라이브러리)
- [핵심 키워드](#핵심-키워드)
- [시스템 아키텍쳐](#시스템-아키텍쳐)
- [WAS 아키텍처](#WAS-아키텍처)
- [E-R 다이어그램](#e-r-다이어그램)
- [프로젝트 목적](#프로젝트-목적)
    * [블로그 프로젝트를 기획한 이유?](#블로그-프로젝트를-기획한-이유?)
- [핵심 기능](#핵심-기능)
    * [헥사고날 아키텍처로 리아키텍처링](#헥사고날-아키텍처로-리아키텍처링)
    * [소셜 로그인](#소셜-로그인)
    * [로그 추적기](#로그-추적기)
    * [반응형 웹](#반응형-웹)
    * [Toast Ui editor](#toast-ui-editor)
        + [글작성은 마크다운으로](#글작성은-마크다운으로)
        + [이미지와 썸네일 삽입시는 깃허브 이미지 서버로](#이미지와-썸네일-삽입시는-깃허브-이미지-서버로)
        + [트러블 슈팅: 컨텐츠 렌더링은 SSR으로](#트러블-슈팅~컨텐츠-렌더링은-SSR으로)
    * [기본적인 게시물 CRUD](#기본적인-게시물-CRUD)
    * [댓글과 대댓글 구현](#댓글과-대댓글-구현)
        + [트러블 슈팅 : 개행 반복 입력 문제](#트러블-슈팅~개행-반복-입력-문제)
    * [계층형 카테고리](#계층형-카테고리)
    * [카테고리 편집기 구현](#카테고리-편집기-구현)
    * [작성중인 게시물 자동저장](#작성중인-게시물-자동저장)
    * [에러처리](#에러처리)
    * [캐싱](#캐싱)
    * [게시물 포스팅시 깃헙 자동 백업](#게시물-포스팅시-깃헙-자동-백업)
    * [공유하기](#공유하기)
    * [태그검색, 키워드 검색](#태그검색,-키워드-검색)
    * [오프셋 페이징을 사용한 페이징박스와 커서 페이징을 사용한 무한 스크롤](#오프셋-페이징을-사용한-페이징박스와-커서-페이징을-사용한-무한-스크롤)
    * [CI/CD 무중단 배포](#CI/CD-무중단-배포)
    * [SEO 최적화](#seo-최적화)
        + [도메인과 https 프로토콜](#도메인과-https-프로토콜)
        + [SEO 최적화](#SEO-최적화)
- [프로젝트를 통해 느낀점](#프로젝트를-통해-느낀점)
- [프로젝트 관련 추가 포스팅](#프로젝트-관련-추가-포스팅)

## 개발 환경

### 백엔드 (박상준)

- IntelliJ
- Postman
- Intellij .http
- GitHub
- Intellij Git
- DataGrip
-

### 프론트엔드 (김신협, 이주상)

## 사용 기술

### 백엔드

#### 주요 프레임워크 / 라이브러리

- Java 11 openjdk
- SpringBoot 2.2.2
- SpringBoot Security
- Spring Data JPA
- Json Web Token
- Qdsl

#### Build tool

- Gradle

#### Database

- Mysql

#### Infra

- AWS EC2
- AWS S3
- Github Actions
- AWS CodeDeploy
- AWS RDS

### 프론트엔드

- HTML / CSS
- REACT
- REDUX

### 기타 주요 라이브러리

- Lombok
- ModelMapper
- p6spy

## 핵심 키워드

- 스프링 부트, 스프링 시큐리티를 사용하여 웹 애플리케이션 생애 주기 기획부터 배포 유지 보수까지 전과정 개발과 운영 경험 확보
- AWS / 리눅스 기반 CI/CD 무중단 배포 인프라 구축
- JPA, Hibernate를 사용한 도메인 설계
- MVC 프레임워크 기반 백엔드 서버 구축

## 시스템 아키텍쳐

![img.png](img.png)https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FnBCGB%2FbtrFzNmbwAR%2FroFSU19mpzgDfwNktBaBEK%2Fimg.png

## WAS 아키텍처

## E-R 다이어그램

<a href="https://ibb.co/p4WXczg"><img src="https://i.ibb.co/6DvszP2/coupang.png" alt="coupang" border="0"></a>

## 프로젝트 목적

### 쿠팡 클론 프로젝트를 기획한 이유?

처음에는 프로젝트는 기존 사이트의 불편한 점을 개선해야한다는 생각과 클론사이트는 의미가 없지 않느냐 라는 생각을 가지고 있었습니다

하지만 기존 사이트야 말로 실제로 개발자들이 수년간 유지보수및 개발을 진행하면서 수 많은 시행착오를 거친 그 부산물이라고 생각되어 쿠팡 사이트의 일부분을 클론하게 되었습니다.

현재 2022.08.14 일 기준으로는 어드민 사이트를 별도로 구현하지는 못하였습니다. 하지만 시큐리티의 정수인 어드민과 일반 유저가의 접속 권한에 따른 분기를 설정하기 위하여 앞으로 구현할 생각이 있습니다.

## 핵심 기능(릴리즈 후 추가 개선)

---

## 핵심 기능(릴리즈 전)

### ModelMapper 사용으로 코드 간략화

기존에는 리플렉션을 통해 객체 매핑을 해주는 `ModelMapper` 를 사용

### QueryDsl To JPQL

QueryDsl로 모든 쿼리를 작성할 이유가 없어짐 되려 어디에서 어디를 참고하고 있는지 그 파일의 위치만 분산되는거 같아 기존 QueryDsl 을 JPQL로 변경함.. 동적으로 쿼리를 만들어야하는 경우는 QDsl를
사용해야하지만, 그렇지 않은 경우는 `QueryMethod` 나 `JPQL`을 사용하는 것이 좋다고 생각됨,

### github 액션 + AWS CODE DEPLOY + AWS EC2

배포 자동화를 사용하여 개발자가 코드를 푸쉬 혹은 `PR` 을 신청할 때마다 EC2 서버에 반영되도록 하였습니다.

#### 이미지와 썸네일 삽입시는 ~~깃허브~~ aws s3 이미지 서버로

(2022.03.21)

Toast Ui editor는 기본적으로 컨텐츠 내의 이미지 삽입을 blob으로 컨텐츠와 함께 병기하게 되는데 이경우 장황한 바이너리 코드로 DB에 부담이 되고

차후 검색엔진 최적화에 지장이 갈것으로 판단하여

1. 이미지 삽입시 후킹으로 blob 코드를 낚아챈 후
2. 아작스로 해당 이미지 blob을 앱 서버로 보내기

3. ~~3. 앱서버에서 깃허브 api를 사용해 깃허브 레포지토리에 업로드~~
4. was에서 aws s3로 업로드
5. 그리고 이미지의 blob대신 업로드된 url을 반환

깃헙 레포를 사용할경우 이미지 업로드시 무의미한 커밋이 찍혀 전략 패턴을 사용해 업로드 로직을 분리, 고도화한다음 aws S3로 업로드 서버를 변경하였습니다.

해당 과정은 아래 포스팅주소에서 확인할 수 있습니다.

[이미지 업로드를 전략패턴으로 재설계한뒤 aws s3로 전환하기](https://www.jiniaslog.co.kr/article/view?articleId=1103)

[아작스로 이미지 업로드](https://github.com/jinia91/blog/blob/a1d9381d8675ef01fbe3cf7371fe642a1847a943/src/main/resources/static/js/thumbnail.js#L13)

### 스웨거 사용

프론트엔드 개발자나 다른 개발자들에게 문서화된 REST API 를 전달하기 위해 스웨거 적용

스웨거 url 접속을 편하게 하기 위하여
![img_1.png](img_1.png)

스웨거 리다이렉터 컨트롤러 작성

![img_2.png](img_2.png)

### 기본적인 게시물 CRUD

게시물에 대한 기본적인 CRUD를 모두 구현하였습니다.

### 카테고리 깊이 구현

카테고리의 깊이를 구현하였습니다.
![img_3.png](img_3.png)
컬럼에 별도의 부모No 를 추가하여 해당 컬럼의 부모 컬럼을 지정하였습니다.

DB에서 조회시에는 오라클에서는 start with connect by 구문을 활용하여 쉽게 상위 부모에 대한 하위 깊이 데이터를 불러올 수 있지만,
MYSQL에서는

#### 트러블 슈팅~개행 반복 입력 문제

또한 댓글 입력 방식을 textaria로 하였더니 개행이 저장되지 않고, 개행을 저장하도록 태그 수정을 했더니 개행이 문자열 1개자리만 차지하여 최대 255번의 개행만 입력될수 있는 문제점을 발견했습니다.

이를 해결하기 위해 입력받은 문자열중 개행이 2번이상 중복되는경우 1번으로 연쇄적으로 압축시키는 알고리즘을 작성하였습니다.

[중복개행 연쇄제거 알고리즘](https://github.com/jinia91/blog/blob/a1d9381d8675ef01fbe3cf7371fe642a1847a943/src/main/java/myblog/blog/comment/service/CommentService.java#L101)

### 계층형 카테고리

카테고리 역시 위의 댓글처럼 계층 레벨을 표현하는 컬럼을 사용하고 셀프조인으로 계층을 형성하도록 엔티티 구조를 설계하였으며 레이아웃상에 카테고리를 보여주기 위하여

조회된 카테고리들을 dfs 알고리즘으로 계층화된 트리구조로 객체생성, 차후 정책에 따라 무한히 계층으로 표현할수 있도록 설계했습니다.

[dfs 알고리즘으로 계층화 트리구조 생성 static factory method](https://github.com/jinia91/blog/blob/a1d9381d8675ef01fbe3cf7371fe642a1847a943/src/main/java/myblog/blog/category/dto/CategoryForView.java#L38)

### 카테고리 편집기 구현

카테고리 추가, 삭제, 상위 카테고리로 이동, 하위 카테고리로 이동, 카테고리 순서 변경이 가능한 관리자용 API를 구현하여 블로그 운영을 보다 용이하게 만들었습니다.

![카테고리 편집](https://github.com/jinia91/blogBackUp/blob/main/img/bcd4b616-d5b9-4202-96ee-c6e243ad62a1.gif?raw=true)

[카테고리 편집 화면]

클라이언트단에서는 바닐라 자바스크립트를 통해 DTO를 수정하고 DOM을 조작하여 구현하였고 변경된 카테고리 리스트를 DTO로 백단으로 넘기면

백단에서는 변경된 카테고리리스트와 기존 카테고리리스트 두개를 큐로 처리하여 비교대조를 통해 신규 카테고리생성, 기존카테고리 이름과 순서 변경, 카테고리 삭제 로직을 수행토록 했습니다.

### 작성중인 게시물 자동저장

글작성시 자바스크립트로 1분마다 아작스 요청을 통해 글을 임시 저장하는 기능을 추가했습니다.

![자동저장](https://github.com/jinia91/blogBackUp/blob/main/img/9cf13435-f570-4672-90f1-ac0810030b72.gif?raw=true)

### 에러처리

로그인시 에러가 나는경우 이를 처리하기위해 커스텀 LoginFailHandler 클래스를 구현했으며, 기본적으로 외부 파라미터를 받는 컨트롤러 전면에

Validated로 유효성 빈검사를 수행하여 실패 원자성을 유지하였습니다.

또한 이러한 에러들을 ExceptionControllerAdvice가 받아 로깅을 남기도록 했고 에러화면을 출력하기 위해 커스텀 ExceptionController를 구현했습니다.

[예외처리 로직들](https://github.com/jinia91/blog/tree/main/src/main/java/myblog/blog/exception)

![에러화면](https://github.com/jinia91/blogBackUp/blob/main/img/bcb0c9a7-02e9-4137-b0cc-27d9c84c4f6b.png?raw=true)
[커스텀 에러화면]

### 캐싱

고정된 레이아웃상에 카테고리 목록들, 최신 댓글은 물론 메인화면상의 최신 게시물이나 인기게시물등 화면을 렌더링하기 위해 상당히 많은 데이터가 필요하고

해당 데이터들을 구하기위해 모든 클라이언트의 모든 조회시마다 DB에 쿼리를 날린다면 성능상으로 상당히 부하가 될것이라 판단하였습니다.

따라서 자주 사용되는 메서드들에 대하여 EhCache 를 통해 캐시 처리를 하고 만약 해당 캐시에 대한 데이터 정합성이 깨지는 메서드들을 사용할경우

캐시를 폐기하는 정책을 사용하였습니다.

[캐시 설정 클래스](https://github.com/jinia91/blog/blob/a1d9381d8675ef01fbe3cf7371fe642a1847a943/src/main/java/myblog/blog/base/config/CacheConfig.java#L16)

또한 캐시 생명주기를 6시간으로 설정하여 별도의 메서드 없이도 6시간마다 캐시를 폐기하여 데이터 정합성을 유지하도록 설정했습니다.

### 게시물 포스팅시 깃헙 자동 백업

게시물을 작성할 경우 깃헙 api를 통해 해당 게시물을 백업용 레포지토리에 push하여 컨텐츠를 백업하도록 하였습니다.

[깃헙 push 로직](https://github.com/jinia91/blog/blob/a1d9381d8675ef01fbe3cf7371fe642a1847a943/src/main/java/myblog/blog/article/service/ArticleService.java#L182)
[깃헙 레포지토리, 백업 서버로 사용](https://github.com/jinia91/blogBackUp/tree/main)

### 공유하기

페이스북, 네이버 블로그, 카카오톡에 게시물을 공유하는 기능을 넣어 블로그의 접근성을 보다 높였습니다.

![카카오톡 공유](https://github.com/jinia91/blogBackUp/blob/main/img/22ca4613-b448-4401-8d24-60ffba06794c.png?raw=true)

[카카오톡 공유 예시]

### 태그검색, 키워드 검색

tagify 라이브러리를 사용하여 태그 기능을 구현하였고 태그나 게시물 컨텐츠의 특정 문자열에 대하여 검색하는 기능을 만들었습니다.

검색 쿼리의 경우 "Like %s%" 를 사용하였기에 인덱스를 사용하지 못하기 때문에

차후 성능상 문제가 있을 경우 형태소 분석기를 설치하여 mysql의 FTS기능을 지원하도록 개선해볼 예정입니다.

### 오프셋 페이징을 사용한 페이징박스와 커서 페이징을 사용한 무한 스크롤

카테고리별 게시물 조회, 태그검색, 키워드 검색시 오프셋 페이징 쿼리를 이용해 페이징처리를 했으며 해당 페이지 넘버를 관리하기 위해

별도의 페이징 박스 핸들러 클래스를 만들어 페이징 박스를 렌더링 하도록 하였습니다.

또한 쿼리 파라미터를 통해 비정상적 페이지를 조회하는 케이스도 방지하도록 유효성 검사를 하였습니다.

[페이징 박스 핸들러](https://github.com/jinia91/blog/blob/a1d9381d8675ef01fbe3cf7371fe642a1847a943/src/main/java/myblog/blog/article/dto/PagingBoxDto.java#L11)

메인화면의 경우 최신게시물순으로 5개씩 끊어서 스크롤 감지에 따라 다음 게시물들을 조회하는 무한 스크롤 페이징을 구현했으며

최초에는 토탈 카운트 쿼리를 날리지 않는 JPA의 Slice 인터페이스를 사용해서 페이징 처리를 했으나

보다 성능개선을 위해 커서페이징으로 리팩토링하였습니다.

[자바스크립트 무한 스크롤 렌더링 로직](https://github.com/jinia91/blog/blob/a1d9381d8675ef01fbe3cf7371fe642a1847a943/src/main/resources/static/js/infinityScroll.js#L5)

[오프셋 페이징을 커서페이징으로 리팩토링하기](https://www.jiniaslog.co.kr/article/view?articleId=202)

### CI/CD 무중단 배포

애플리케이션 출시에 있어서 지속적 통합과 지속적 배포를 위해 깃헙, travis, AWS CodeDeploy를 사용했으며 빌드와 배포를 분리하기 위해 travis와 AWS s3를 이용했습니다.

![image](https://github.com/jinia91/blogBackUp/blob/main/img/57d1dfd7-22c1-4a5f-b6d5-ef635ae49307.png?raw=true)

깃헙으로 push된 프로젝트는 travis에서 설정에따라 자동화 테스트를 거쳐 빌드되며 빌드된 jar는 AWS S3에 저장됩니다.

[travis 설정파일](https://github.com/jinia91/blog/blob/main/.travis.yml)

이후 배포요청을 받은 CodeDeploy는 S3에서 jar 파일을 넘겨받아 ec2로 파일을 넘겨주며 이때 배포 수명 주기의 순서대로 설정된 스크립트를 실행하게 됩니다.

[appspec 설정](https://github.com/jinia91/blog/blob/main/appspec.yml)

여기서 무중단 배포를 구현하기 위하여 EC2의 8081과 8082 포트에 프로젝트 jar 두개를 구동시키고 엔진엑스로 8080포트를 열되

엔진엑스는 81과 82중 하나의 포트만 리버스 프록시하도록 했습니다.

이때 바라보지 않는 포트의 앱이 새로 배포되는 대상이 됩니다.

우선 새로 배포되는 앱을 AfterInstall 수명 주기에 멈춘뒤 ApplicationStart 주기에 해당 포트에 새로운 버전의 앱을 실행합니다.

이후 ValidateService 주기에 health.sh 스크립트로 정상배포를 확인하고 정상적일경우 엔진엑스의 프록시를 신규 버전 포트로 돌려(reload) 배포를 완료합니다.

[무중단 배포를 위한 쉘스크립트 파일들](https://github.com/jinia91/blog/tree/main/scripts)

### SEO 최적화

#### 도메인과 https 프로토콜

배포된 웹 앱을 제대로 서비스하기위해 letsencrypt로 ssl 인증을 받아 https 보안 프로토콜을 적용했으며, 가비아에서 도메인을 구입하고 AWS Route 53을 이용하여 도메인을 연결하였습니다.

#### SEO 최적화

1. RSS Feed 발행

앱 서버내에서 모든 게시물들을 조회한 뒤 해당 게시물들을 RSS 포멧에 맞는 xml로 작성하여 발행하도록 로직을 작성했으며 RSS 작성시 만들어지는 객체생성과 게시물 조회의 비용을 생각하여

해당 로직을 캐싱처리토록 했습니다.

2. sitemap

또한 현재 존재하는 카테고리들의 url을 이용해 sitemap xml을 동적으로 작성하도록 하였으며 역시나 캐싱처리를 통해 비용에 대한 부담을 경감시켰습니다.

3. 동적 메타태그 작성

모든 게시물들은 해당 컨텐츠를 이용해 서버사이드에서 동적으로 메타태그를 작성토록하여 seo 최적화를 구축했습니다.

4. robot설정

크롤링대상이 되는 url과 조회할 필요없는 url을 분류하여 robot.txt를 작성했습니다.

5. 네이버 검색 어드바이저와 구글 서치콘솔에 등록

각 검색 서비스에 소유 인증을 하고 rss와 sitemap 제출을 하여 적극적인 크롤링 요청을 하였습니다.

![검색](https://github.com/jinia91/blogBackUp/blob/main/img/1aacfe5e-a6d3-47c8-80d1-b1f4165bd85e.png?raw=true)

[구글 검색창에서 조회결과]

## 프로젝트를 통해 느낀점

## 프로젝트 관련 추가 포스팅

