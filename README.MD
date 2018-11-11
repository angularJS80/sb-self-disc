start branch
1 프로젝트 생성 
 1) new Project > spring initializer > next
 2) jdk 11선택 > next
 3) 메이븐기본 라이브러리 검색하여 선택 
    jpa, hateoas, web , h2database,postgresql,configuration-processor,lombok

2 모델 클레스 생성  
 1) 모델 클레스에서 lombok 를 사용하는데 프로젝트 생성시 메이븐 기본 라이브러리에서 누락되었다. 
    IntelliJ 에서 메이븐 추가후 나오는 메시지를 유심히 보고 설정해줘야 한다 
 
 2) lombok 를 추가 하였으나, 클레스의 .get , .set  을해도 인식을 못한다. 
    IntelliJ 에서 lombok 플러그인을 설치 해줘야 한다.
    