
package wad.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
public class Category extends AbstractPersistable<Long>{
    
    private String name;
    @OneToMany
    private List<Poll> polls;;
    
    public Category() {
        polls = new ArrayList();
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String n) {
        name = n;
    }
    
    public List<Poll> getPolls() {
        return polls;
    }
    
    public void addPoll(Poll p) {
        polls.add(p);
    }
    
}
