
http://yoon940514.cafe24.com/Project/home.jsp (소스 코드는 Project branch에 있습니다.)

http://yoon940514.cafe24.com/imageBoard2 (소스 코드는 ImageBoard branch에 있습니다.)

안녕하세요. 현재 보고 계신 프로젝트는 제가 강남그린컴퓨터아카데미에 6개월 훈련과정을 이수하면서 배운 기술을 토대로 직접 만들어본 포트폴리오입니다. 저의 포트폴리오는 로그인 회원관리 화
면이랑 게시판 2개로 구성되어 있습니다.

Project (게시판 + 회원관리): servlet mvc, jsp, jstl

ImageBoard (게시판): spring mvc, maven, jsp, jstl, mybatis, Junit4

ps) Tool: eclipe, filezilla, putty, tomcat, mysql

Project (서블릿버전): 라이브러리와 스프링의 도움 거의 없이 대부분 순수 자바 코드로 구현했습니다. db 접속도 순수 jdbc + dbcp로 구현했습니다. 직접 알고리즘을 짜서 Model + view로 동적쿼리 구
현. 로그인 session 사용. 

ImageBoard (스프링버전): paging 기능과 이미지/ 파일 입출력, 조회수 표시. aop 구현. Junit4의 log4j를 이용하여 간단한 테스트코드 작성.
