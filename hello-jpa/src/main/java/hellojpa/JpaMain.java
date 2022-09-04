package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

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
