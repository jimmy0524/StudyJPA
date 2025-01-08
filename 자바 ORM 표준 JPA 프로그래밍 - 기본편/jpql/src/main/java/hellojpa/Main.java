package hellojpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(0);
            member.changeTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            String inner = "select m from Member m inner join m.team t";
            List<Member> result1 = em.createQuery(inner, Member.class)
                    .getResultList();

            em.clear();

            String outer = "select m from Member m left outer join m.team t";
            List<Member> result2 = em.createQuery(outer, Member.class)
                    .getResultList();

            em.clear();

            String theta = "select m from Member m, Team t where m.username = t.name";
            List<Member> result3 = em.createQuery(theta, Member.class)
                    .getResultList();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}