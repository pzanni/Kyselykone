
package wad.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Poll extends AbstractPersistable<Long>{
    
    @Length(min = 2, max = 150)
    private String title;
    @ManyToOne
    private Asker asker;
    @OneToMany
    private List<Option> options;
    private String maker;
    @ManyToMany(mappedBy = "polls")
    private List<Category> categories;
    
    
    public Poll() {
        options = new ArrayList();
        categories = new ArrayList();
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String t) {
        title = t;
    }
    
    public Asker getAsker() {
        return asker;
    }
    
    public String getMaker() {
        return maker;
    }
    
    public void setAsker(Asker a) {
        asker = a;
        maker = a.getUsername();
    }
    
    public List<Option> getOptions() {
        return options;
    }
    
    public void addOption(Option o) {
        options.add(o);
    }
    
    public List<Category> getCategories() {
        return categories;
    }
    
    public void addCategory(Category c) {
        categories.add(c);
    }

}
