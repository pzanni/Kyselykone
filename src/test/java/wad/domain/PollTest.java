
package wad.domain;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class PollTest {
    
    Poll poll;
    String title = "Kysely";
    Asker asker;
    List<Option> options = new ArrayList();
    
    public PollTest() {
        
    }
    
    @Before
    public void setUp() {
        this.poll = new Poll();
        poll.setTitle(title);
        this.asker = new Asker();
        poll.setAsker(asker);
        Option option = new Option();
        options.add(option);
        poll.addOption(option);
    }
    
    @Test
    public void getters() {
        assertEquals(title, poll.getTitle());
        assertEquals(asker, poll.getAsker());
        assertEquals(options, poll.getOptions());
    }
    
    @Test
    public void setters() {
        Asker asker2 = new Asker();
        poll.setAsker(asker2);
        poll.setTitle("uusiotsikko");
        
        assertEquals(asker2, poll.getAsker());
        assertEquals("uusiotsikko", poll.getTitle());
    }
    
    @Test
    public void addOptionWorks() {
        Option option2 = new Option();
        poll.addOption(option2);
        
        assertEquals(true, poll.getOptions().contains(option2));
    }
    
}
