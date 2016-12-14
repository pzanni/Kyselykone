
package wad.domain;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Asker extends AbstractPersistable<Long>{
    
    private String username;
    private String password;
    @ElementCollection(fetch=FetchType.EAGER)
    private List<String> authorities;
    
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
    
    public List<String> getAuthorities() {
        return authorities;
    }
    
    public void setAuthorities(List<String> au) {
        authorities = au;
    }
}
