
package wad.domain;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class CategoryTest {
    
    Category category;
    String name = "name";
    List<Poll> polls = new ArrayList();
    
    public CategoryTest() {
        
    }
    
    @Before
    public void setUp() {
        this.category = new Category();
        category.setName(name);
        category.setPolls(polls);
    }
    
    @Test
    public void getters() {
        assertEquals(name, category.getName());
        assertEquals(polls, category.getPolls());
    }
    
    @Test
    public void setters() {
        category.setName("hmmm");
        Poll p = new Poll();
        polls.add(p);
        category.addPoll(p);
        assertEquals(polls, category.getPolls());
    }
}
