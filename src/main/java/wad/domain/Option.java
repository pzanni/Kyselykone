

package wad.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Option extends AbstractPersistable<Long>{
    
    private String content;
    private Integer votes;
    @ManyToOne
    private Poll poll;
    
    public Option() {
        
    }

    public String getContent() {
        return content;
    }
    
    public void setContent(String c) {
        content = c;
    }
    
    public int getVotes() {
        return votes;
    }
    
    public void addVote() {
        votes++;
    }
    
    public Poll getPoll() {
        return poll;
    }
    
    public void setPoll(Poll p) {
        poll = p;
    }
}
