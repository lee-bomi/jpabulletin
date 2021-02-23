package jpastudy1.jpabulletin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

//    @PersistenceContext       //엔티티매니저 주입   cf)@PersistenceUnit : emf주입
//    EntityManager em;

    //@RequiredArgsConstructor은 생성자주입과 JPA em주입도 가능하다
    private final EntityManager em;


    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name= :name", Member.class)
                .setParameter("name", name)           //JQPL에 넣은 조건식의 name을 파라미터 name으로 넣어준다
                .getResultList();
    }


}
