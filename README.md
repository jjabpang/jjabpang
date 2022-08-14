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

### 스웨거 사용

프론트엔드 개발자나 다른 개발자들에게 문서화된 REST API 를 전달하기 위해 스웨거 적용

스웨거 url 접속을 편하게 하기 위하여
![img_1.png](img_1.png)

스웨거 리다이렉터 컨트롤러 작성

![img_2.png](img_2.png)

### 기본적인 게시물 CRUD

게시물에 대한 기본적인 CRUD를 모두 구현하였습니다.

### 카테고리 깊이 구현 및 추후 깊이관련 기능 추가예정

카테고리의 깊이를 구현하였습니다.
![img_3.png](img_3.png)
컬럼에 별도의 부모No 를 추가하여 해당 컬럼의 부모 컬럼을 지정하였습니다.

DB에서 조회시에는 오라클에서는 start with connect by 구문을 활용하여 쉽게 상위 부모에 대한 하위 깊이 데이터를 불러올 수 있지만,
MYSQL에서는 8버전 이상인 경우에만 재귀함수로 해당 기능을 구현가능합니다. 하지만 5버전의 경우 해당 기능을 구현은 가능하지만 상대적으로 불편한 것으로 알고 있습니다.

그래서 향후, 8버전으로 올리려고 합니다.

### 에러처리

에러 처리의 경우 자바의 Optional 을 사용, orelsethrow > customError 혹은 자바 자체의 illegalStateException 등을 활용하여 api로 에러 코드를 전달할 수 있도록
하였습니다.

또한 ResponseEnitity로 message와 header status를 전달하는 방식을 채용했습니다.

### Qdsl 동적 정렬 및 동적 조건

![img_4.png](img_4.png)

OrderSpecifier 를 반환값으로 하여 boardSort 기능 구현하였습니다
boardSort의 경우 api requestBody안에 sort &

### CI/CD 무중단 배포

애플리케이션 출시에 있어서 지속적 통합과 지속적 배포를 위해 깃헙, travis, AWS CodeDeploy를 사용했으며 빌드와 배포를 분리하기 위해 github Action과 AWS s3를 이용했습니다.

![시스템 구조](img.png)

깃헙으로 push된 프로젝트는 action 에서 설정에 따라 자동화 테스트를 거쳐 빌드되며 빌드된 jar는 AWS S3에 저장됩니다.

이후 배포요청을 받은 CodeDeploy는 S3에서 jar 파일을 넘겨받아 ec2로 파일을 넘겨주며 이때 배포 수명 주기의 순서대로 설정된 스크립트를 실행하게 됩니다.

- appspec 설정
  ![appspec 설정](img_5.png)[appspec 설정](https://github.com/jinia91/blog/blob/main/appspec.yml)

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

