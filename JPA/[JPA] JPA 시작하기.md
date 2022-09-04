# [JPA] JPA 시작하기

### JPA의 탄생 이유

- 백엔드 개발자가 가장 많이 하는 작업 => 객체를 관계형 DB에 관리하기

  그러나 객체와 관계형 데이터베이스의 차이로 인해 개발에 번거로움이 발생하고 객체 답게 모델링을 할 수록 SLQ 매핑 작업이 늘어나게 된다.

  객체를 마치 자바 컬렉션에 저장하듯이 DB에 저장하기 위해 JPA가 나타났다.

### JPA

- JPA (Java Persistence API)
- JAVA ORM(Object-relational mapping) 표준
  - 객체 따로 관계형 데이터베이스 따로 설계
- 사용 이유
  - SQL 중심 개발에서 객체 중심 개발 가능
  - 유지 보수 용이
  - 성능
  - 생산성 증가
  - 성능 최적화 기능
    - 1 차 캐시와 동일성 보장
    - 트랜잭션을 지원하는 쓰기 지연
    - 지연 로딩 (option)

### JPA 시작하기

1. Dependency 추가 

   ```xml
       <dependencies>
           <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager -->
           <dependency>
               <groupId>org.hibernate</groupId>
               <artifactId>hibernate-entitymanager</artifactId>
               <version>5.3.10.Final</version>
           </dependency>
           <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
           <dependency>
               <groupId>mysql</groupId>
               <artifactId>mysql-connector-java</artifactId>
               <version>8.0.30</version>
           </dependency>
           <dependency>
               <groupId>javax.xml.bind</groupId>
               <artifactId>jaxb-api</artifactId>
               <version>2.3.1</version>
           </dependency>
       </dependencies>
   ```

2. META-INF에 persistence.xml 작성

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <persistence version="2.2"
                xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
       <!--  EntityManagerFactory 생성 시 사용되는 persistence name -->
       <persistence-unit name="persistence">
           <properties>
               <!-- 필수 속성 -->
               <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
               <property name="javax.persistence.jdbc.user" value="db유저네임명"/>
               <property name="javax.persistence.jdbc.password" value="db비밀번호"/>
               <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/스키마명?characterEncoding=UTF-8&amp;serverTimezone=UTC"/>
               <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect"/>
   
               <!-- 옵션 -->
               <property name="hibernate.show_sql" value="true"/>
               <property name="hibernate.format_sql" value="true"/>
               <property name="hibernate.use_sql_comments" value="true"/>
               <!--<property name="hibernate.hbm2ddl.auto" value="create" />-->
           </properties>
       </persistence-unit>
   </persistence>
   ```

3. 코드 예시

   트랜잭션, JPQL 예시

   ```java
   public class JpaMain {
       public static void main(String[] args) {
           //어플리케이션 로딩시점 딱 한번
           EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
           //트랜잭션 단위마다 생성
           EntityManager em = emf.createEntityManager();
           //jpa는 데이터 변경 작업시 트랜잭션을 실행해야한다.
           EntityTransaction tx = em.getTransaction();
           tx.begin();
   
           try {
               Member member = new Member();
               member.setId(2L);
               member.setName("ww");
   //            em.persist(member);//저장
   //            Member findMember = em.find(Member.class, 1L); //조회
   //            em.remove(findMember); //삭제
   //            findMember.setName("renameKww"); //변경
   //            List<Member> result = em.createQuery("select m from Member m", Member.class)//JPQL
   //                    .setFirstResult(1)//페이징
   //                    .setMaxResults(10)
   //                    .getResultList();//전체조회
               tx.commit();
           } catch (Exception e) {
               tx.rollback();
           } finally {
               em.close();
           }
           em.close();
           emf.close();
       }
   }
   
   ```

   ```java
   @Entity //jpa가 관리해야한다고 알려주기
   //@Table(name = "user") 테이블 이름이 다를때 사용
   public class Member {
   
       @Id //pk가 무엇인지
       private Long id;
   //    @Column(name = "username") 컬럼 이름이 다를때 사용
       private String name;
   
       public Long getId() {
           return id;
       }
   
       public void setId(Long id) {
           this.id = id;
       }
   
       public String getName() {
           return name;
       }
   
       public void setName(String name) {
           this.name = name;
       }
   }
   ```

4.  주의 사항

   1. 엔티티 매니저 팩토리는 하나만 생성
   2. 엔티티 매니저는 쓰레드간 공유하면 안됨
   3. JPA의 모든 데이터 변셩은 트랜잭션 안에서 실행