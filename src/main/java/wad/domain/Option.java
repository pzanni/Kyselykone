

package wad.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Option extends AbstractPersistable<Long>{
    
    private String content;
    private String votes;
    @ManyToOne
    private Poll poll;
    
    public Option() {
        votes = "0";
    }

    public String getContent() {
        return content;
    }
    
    public void setContent(String c) {
        content = c;
    }
    
    public String getVotes() {
        return votes;
    }
    
    public void addVote() {
        Integer vot = Integer.parseInt(votes);
        vot++;
        votes = vot.toString();
    }
    
    public Poll getPoll() {
        return poll;
    }
    
    public void setPoll(Poll p) {
        poll = p;
    }
}
