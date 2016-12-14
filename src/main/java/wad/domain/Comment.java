
package wad.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Comment extends AbstractPersistable<Long> {
    
    private String content;
    @ManyToOne
    private Asker asker;
    @ManyToOne
    private Poll poll;
    
    public Comment() {
        
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String c) {
        content = c;
    }
    
    public Asker getAsker() {
        return asker;
    }
    
    public void setAsker(Asker a) {
        asker = a;
    }
    
    public Poll getPoll() {
        return poll;
    }
    
    public void setPoll(Poll p) {
        poll = p;
    }
     
}
