

<1. Servlet버전>
http://yoon940514.cafe24.com/Project/home.jsp (소스 코드는 Project branch에 있습니다.)

<2. Spring + Mybatis버전>
http://yoon940514.cafe24.com/imageBoard2 (소스 코드는 ImageBoard branch에 있습니다.)

안녕하세요. 현재 보고 계신 프로젝트는 제가 강남그린컴퓨터아카데미에 6개월 훈련과정을 이수하면서 배운 기술을 토대로 만들었습니다. 
Project와 ImageBoard 2개의 포트폴리오로 구성되어 있습니다.
이 중에서 Project는 처음부터 끝까지 제가 직접 만들어본 포트폴리오입니다. ImageBoard는 처음에 Servlet 버전으로 학원에서 만든 후 Spring은 제가 직접 적용시켜봤습니다. 

Project (게시판 + 회원관리): servlet mvc, jsp, jstl, dbcp socket, connection pool 관리

ImageBoard (게시판): spring mvc, maven, jsp, jstl, mybatis, Junit4

ps) Tool: eclipe, filezilla, putty, tomcat, mysql

Project (서블릿버전): 라이브러리와 스프링의 도움 거의 없이 대부분 순수 자바 코드로 구현했습니다. db 접속도 순수 jdbc + dbcp로 구현했습니다. 직접 알고리즘을 짜서 Model + view에서 동적쿼리도 직접 구현해보고. 로그인 과정에서 session을 사용. 기본 crud 외 ajax로 id/pw 중복검사, jquery로 유효성검사를 했습니다. Oauth토큰을 이용한 카카오 로그인 api도 구현했습니다. view 화면은 bootstrap을 이용했습니다.

ImageBoard (스프링버전): paging 기능과 이미지/ 파일 입출력, 조회수 표시. aop 구현. Junit4의 log4j를 이용하여 간단한 테스트코드 작성. view 화면은 bootstrap을 이용했습니다.

학원에서는 순수 jdbc와 dbcp, 순수 servlet + jsp 위주로 학습하여서 3월 중순에 수료 후 현재 spring framework와 spring boots를 공부하며 더 나은 프로젝트 포트폴리오를 구현중에 있습니다.
호스팅은 cafe24로 도메인 구입후 외장톰캣을 이용하여 배포했습니다.
