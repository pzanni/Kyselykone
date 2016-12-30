
package wad.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Asker extends AbstractPersistable<Long>{
    
    @NotBlank
    @Length(min = 3, max = 20)
    private String username;
    @NotBlank
    @Length(min = 5, max = 20)
    private String password;
    @ElementCollection(fetch=FetchType.EAGER)
    private List<String> authorities;
    
    public Asker() {
        authorities = new ArrayList();
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
    
    public void addAuthority(String au) {
        authorities.add(au);
    }
    
}
