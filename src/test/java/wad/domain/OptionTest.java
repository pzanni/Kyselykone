
package wad.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class OptionTest {
    
    Option option;
    String content = "content";
    Poll poll;
    
    public OptionTest() {
        
    }
    
    @Before
    public void setUp() {
        this.option = new Option();
        option.setContent(content);
        this.poll = new Poll();
        option.setPoll(poll);
    }
    
    @Test
    public void getters() {
        assertEquals(content, option.getContent());
        assertEquals("0", option.getVotes());
        assertEquals(poll, option.getPoll());
    }
    
    @Test
    public void setters() {
        option.setContent("mooi");
        Poll poll2 = new Poll();
        option.setPoll(poll2);
        
        assertEquals("mooi", option.getContent());
        assertEquals(poll2, option.getPoll());
    }
    
    @Test
    public void addVoteWorks() {
        option.addVote();
        assertEquals("1",  option.getVotes());
    }
}
