

<1. Servlet버전>
http://yoon940514.cafe24.com/Project/home.jsp (소스 코드는 Project branch에 있습니다.)

<2. Spring + Mybatis버전>
http://yoon940514.cafe24.com/imageBoard2 (소스 코드는 ImageBoard branch에 있습니다.)

<3. Spring boots + jpa버전>
http://3.34.94.74:8080 (소스 코드는 jpa branch에 있습니다.)







안녕하세요. 현재 보고 계신 프로젝트는 제가 강남그린컴퓨터아카데미에 6개월 훈련과정을 이수하면서 배운 기술을 토대로 만들었습니다. 

Project와 ImageBoard, jpa 3개의 포트폴리오로 구성되어 있습니다.

이 중에서 Project는 처음부터 끝까지 제가 직접 만들어본 포트폴리오입니다. ImageBoard는 처음에 Servlet 버전으로 학원에서 만든 후 Spring은 제가 직접 적용시켜봤습니다.

jpa는 DB, 엔티티 기획과 서비스 로직 설계쪽은 인터넷 강의를 보고 많이 참고했으며, 엔티티, db 설계, crud 구현, 서버 배포는 제가 직접 해보았습니다.







Project : 라이브러리와 스프링의 도움 거의 없이 대부분 순수 자바 코드로 구현했습니다. db 접속도 순수 jdbc + dbcp로 구현했습니다. 직접 알고리즘을 짜서 Model + view에서 동적쿼리도 직접 구현해보고, 로그인 과정에서 session을 적극 사용했습니다. 기본 crud 외 ajax로 id/pw 중복검사, jquery+js 유효성검사. Oauth토큰을 이용한 카카오 로그인 api도 구현. view 화면은 bootstrap을 이용했습니다.

ImageBoard : paging 기능과 이미지/ 파일 입출력, 조회수 표시. aop 구현. Junit4의 log4j를 이용하여 간단한 테스트코드 작성. view 화면은 bootstrap을 이용했습니다.

jpa: spring boots와 jpa를 이용해서 crud 구현, spring-boot-starter-validation을 통한 유효성 검사, view 화면은 thymeleaf를 이용했습니다. 







Project (게시판 + 회원관리): servlet mvc, jsp, dbcp socket, connection pool 관리, jstl

ImageBoard (게시판): spring mvc, maven, jsp, mybatis, Junit4, jstl, lombok, cos

jpa (상품관리): spring boots mvc, gradle, thymeleaf, jpa, junit4, lombok
