

<1. Servlet버전>
http://yoon940514.cafe24.com/Project/home.jsp (소스 코드는 Project branch에 있습니다.)  
<2. Spring + Mybatis버전>
http://yoon940514.cafe24.com/imageBoard2 (소스 코드는 ImageBoard branch에 있습니다.)  
<3. Spring boots + jpa버전>
http://3.34.94.74:8080 (소스 코드는 jpa branch에 있습니다.)

안녕하세요. 현재 보고 계신 프로젝트는 제가 강남그린컴퓨터아카데미에 6개월 훈련과정을 이수하면서 배운 기술을 토대로 만들었습니다.  
Project와 ImageBoard, jpa 3개의 포트폴리오로 구성되어 있습니다.

이 중에서 Project는 처음부터 끝까지 제가 직접 만들어본 포트폴리오입니다.  

ImageBoard는 처음에 Servlet 버전으로 학원에서 만든 후 Spring framework와 mybatis는 제가 직접 적용시켜 보았습니다.  

jpa는 DB, 엔티티 기획과 서비스 로직 설계쪽은 인터넷 강의를 보고 많이 참고했으며, 엔티티, db 설계, crud 구현, 서버 배포는 제가 직접 해보았습니다.

1. Project : 라이브러리와 스프링의 도움 거의 없이 대부분 순수 자바 코드로 구현했습니다.  
   크게 게시판과 JasonParsing을 통한 restfulApi 구현 (공시정보 실시간 파악), 회원관리 페이지로 나뉩니다.  
   
   게시판은 기본적인 crud 이외에, 파일 입출력, 페이징 등 여러 기능을 넣었습니다.  
   
   restfulApi 구현은 dart 전자공시 사이트의 '단일회사 전체 재무제표 개발가이드' 라는 api를 사용했으며, Gson이라는 json parsing library를 사용하여 ajax 통신으로 뷰를 구현했습니다.  
   그 사이에 http서블릿의 get, post 기능과 session, request model을 적극활용하여 나름 최소한의 코드로 공시정보를 실시간으로 얻는 창을 구현하였습니다.    
    
  회원관리 페이지는 사용자/관리자 페이지를 구분하여 구현하였고, 관리자 검색 페이지에서 동적쿼리도 직접 코드로 구현해보았습니다. 로그인 과정에서 session을 적극 사용했습니다.  
기본 crud 외 ajax로 id/pw 중복검사, jquery+js 유효성검사. Oauth토큰을 이용한 카카오 로그인 api도 구현했습니다. 
view 화면은 bootstrap을 이용했습니다.  
2. ImageBoard : paging 기능과 이미지/ 파일 입출력, 조회수 표시. aop 구현. Junit4의 log4j를 이용하여 간단한 테스트코드 작성. view 화면은 bootstrap을 이용했습니다.  
3. jpa: spring boots와 jpa를 이용해서 crud 구현, spring-boot-starter-validation을 통한 유효성 검사, 간단한 테스트코드 작성. view 화면은 thymeleaf를 이용했습니다.   

22년 04월 25일 20:09  ---->> 1, 3번 프로젝트 서버가 중지되는 오류 고쳤습니다. 다시 한번더 봐주시면 감사하겠습니다.  
22년 04월 28일 1:58 ------>> 카카오 로그인 localhost로 redirect 되는 현상 수정했습니다.

<opendart api 정보>
'단일회사 전체 재무제표 개발가이드' ----------------->>>>>>>>   https://opendart.fss.or.kr/guide/detail.do?apiGrpCd=DS003&apiId=2019020 


