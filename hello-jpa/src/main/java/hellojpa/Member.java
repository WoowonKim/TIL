package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
