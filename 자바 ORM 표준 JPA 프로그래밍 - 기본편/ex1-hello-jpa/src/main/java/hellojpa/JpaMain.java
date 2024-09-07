package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try { //준영속 상태로 만들기

            //영속
            Member member = em.find(Member.class, 150L);
            member.setName("zzz");

            em.detach(member); //영속성 컨텍스트에서 더이상 관리 x

            System.out.println("==========");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

//        try { //변경감지 테스트
//
//            //영속
//            Member member = em.find(Member.class, 150L);
//            member.setName("zzz");
////            em.persist(member); -> 안해줘도 됨 : 변경감지!
//            System.out.println("==========");
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//        emf.close();
//        try { //insert 쿼리 날아가는 시점 테스트
//
//            //영속
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("==========");
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//        emf.close();
//        try {  //회원 생성 영속 비영속 생명주기 테스트
//            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("jea");
//
//            //영속
//            System.out.println("== BEFORE ==");
//            em.persist(member); //여기서 1차캐시에 저장
//            System.out.println("== AFTER ==");
//
//            Member findMember = em.find(Member.class, 101L);
//
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//        emf.close();

//        try {   //회원 삭제
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//        emf.close();
//
//        try {   //회원 수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("jimmy");
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//        emf.close();
    }
}
