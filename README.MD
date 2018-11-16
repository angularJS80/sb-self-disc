
1. 프로젝트 생성 (start branch)
   1) new Project > spring initializer > next
   2) jdk 11선택 > next
   3) 메이븐기본 라이브러리 검색하여 선택 
    jpa, hateoas, web , h2database,postgresql,configuration-processor,lombok


2. 모델 클레스 생성  (web-test branch)
   1) 모델 클레스에서 lombok 를 사용하는데 프로젝트 생성시 메이븐 기본 라이브러리에서 누락되었다. 
    IntelliJ 에서 메이븐 추가후 나오는 메시지를 유심히 보고 설정해줘야 한다 
   2) lombok 를 추가 하였으나, 클레스의 .get , .set  을해도 인식을 못한다. 
    IntelliJ 에서 lombok 플러그인을 설치 해줘야 한다.
   3) MvcMock 을 이용한 기본 웹 어플리케이션 호출 테스트 

3. 유효성 검사 처리
   1) 별도 dto 클레스를 만들어서 요청 받을때 dto 형태로 받는다.
   2) dto 클레스에서 기본 널체크 , 최대값 , 최소값 수준의 유효성체크 어노테이션 추가
   3) 컨트롤러에서 인자값 앞에 @Valid 어노테이션으로 유효성을 추가하고 오류시 담아줄 Errors 추가
   4) enum 을 이용한 eventstatus 상태 리턴은  MapperObject 를 이용해서 dto 클래스가 아닌 원래 event 에 담아서 결과 리턴
   5) org.modelmapper 라이브러리 maven 추가
   6) 기본적인 수준의 유효성이외 별도 validator 클레스를 작성하고 비지니스 수준의 유효성 체크를 작성한다. 
   7) MockMvc 클라이언트 테스트 코드에서 andExpect 에 예상 결과 포함여부 유효성 처리 

4. hateoas link 
   1) Resource 클래스 작성
   2) 호출결과 반환시 Resource 로 감싸서 반환
   3) Resource 에 링크 정보 추가 

5. 참로 링크 추가 및 문서화
   1) 문서 작성 관련 컨피그 클레스 작성
   2) 테스트 컨트롤러 문서 작성 관련 컨피그 임포트 어노테이션 추가 
   3) 컨트롤러 호출시 반환값으로 스피넷 작성
   4) asscii 관련 메이븐 라이브러리 추가 및 빌드시 자동 아웃풋 설정
   5) main/asciidoc 문서 템플릿 페이지 작성
   
6. 스프링 시큐리티 적용
   0) 스프링 시큐리티 라이브러리 추가(pom.xml)
      - org.springframework.security
      - org.springframework.security.oauth.boot
   1) Account,AccountRoles 클레스 작성
   2) AccountRepository 데이터 접근클래스 작성
   3) AccountAdapter 권한 주고받는 어뎁터 설정
   4) 계정 생성 및 계정로그인 용 서비스 생성
   5) SecurityConfig 작성 ( 위에 작성된 권한에 필요한 로그인처리를 권한관리자에 
      적용한 웹시큐리티 어뎁터  
      인증에 사용될 로그인 서비스 설정 및 미인증처리 필터링
   6) AuthServerConfig 작성 ( 시큐리티 컨피그의 권한관리자를 이용해서 권한 설정 어뎁터 작성
      인증기간등의 설정
   7) ResourceServerConfig 작성 
      - 리소스 접근에 대한 필터링 
      ? 이벤트 리소스 관련 여부 확인
   8)test application.properties 작성
      - H2 Database 접근용 
   9)OAuthTokenTest ,ControllerTests 클래스 작성 
      - 기능 테스트 
     
       
      
Next--------------------------------------------------------------------------------------
7. 유효성 검사 문제 에 대한 표기 

8. 인증 전 후에 따른 참조 링크 처리 
