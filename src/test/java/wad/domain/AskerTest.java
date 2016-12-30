
package wad.domain;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;



public class AskerTest {
    
    Asker asker;
    String username = "jani";
    String password = "poniponi";
    
    public AskerTest() {
        
    }
    
    @Before
    public void setUp() {
        this.asker = new Asker();
        asker.setPassword(password);
        asker.setUsername(username);
    }
    
    @Test
    public void getters() {
        assertEquals(username, asker.getUsername());
        assertEquals(password, asker.getPassword());
    }
    
    @Test
    public void setters() {
        asker.setUsername("sabina");
        asker.setPassword("sabina123");
        
        assertEquals("sabina", asker.getUsername());
        assertEquals("sabina123", asker.getPassword());
    }
    
}
