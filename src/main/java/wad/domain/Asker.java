
package wad.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Asker extends AbstractPersistable<Long>{
    
    private String username;
    private String password;
    
    public Asker() {
        
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String un) {
        username = un;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String pw) {
        password = pw;
    }
}
