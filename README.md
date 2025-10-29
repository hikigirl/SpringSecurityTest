# SecurityTest
## Spring Security
- new - spring legacy project - spring mvc project
- project name: `SecurityTest`
- root package: `com.test.java`

---

#### 자바 버전과 pom.xml 수정

- 프로젝트 우클릭 -> Project Facets -> Java 11
- properties 태그에 있는 java-version 11
- 그 아래 스프링 버전 5.0.7.RELEASE로
- 맨 아래쪽 plugin 태그 -> maven plugin 내부
  - configuration 태그 내부 source, target 내부 11로 변경

---

#### 파일, 패키지

##### src/main/java - Controller
- com.test.java.model
  - `SecurityMapper.java`(I)

- com.test.java.server
  - `.java`
  - `.java`
- com.test.java.domain
  - `.java`: 

##### src/test/java - 단위테스트
- com.test.java.model
  - `DBTests.java`: 인터페이스 매퍼 단위테스트

##### src/main/webapp - View
- WEB-INF/views
  - `.jsp`: 클라이언트
  - `.jsp`: 접속 화면(대화명 입력 + 단톡방 들어가기)
  - `.jsp`: 대화 화면
