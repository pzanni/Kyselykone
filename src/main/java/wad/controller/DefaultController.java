
package wad.controller;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import wad.domain.Asker;
import wad.domain.Category;
import wad.domain.Option;
import wad.domain.Poll;
import wad.repository.AskerRepository;
import wad.repository.CategoryRepository;
import wad.repository.OptionRepository;
import wad.repository.PollRepository;


@Controller
public class DefaultController {
    
    @Autowired
    PollRepository pollRepo;
    @Autowired
    AskerRepository askerRepo;
    @Autowired
    OptionRepository optionRepo;
    @Autowired
    CategoryRepository categoryRepo;
    
    @PostConstruct
    public void init() {
        if(askerRepo.findOne(1L) == null) {
            Asker asker = new Asker();
            asker.setUsername("milla");
            asker.setPassword("milla");
            asker.addAuthority("USER");
            asker = askerRepo.save(asker);
            
            Category category = new Category();
            category.setName("Ohjelmointi");
            category = categoryRepo.save(category);
            Category category2 = new Category();
            category2.setName("Politiikka");
            category2 = categoryRepo.save(category2);
            
            Poll poll = new Poll();
            poll.setAsker(asker);
            poll.setTitle("Paras ohjelmointikieli");
            poll = pollRepo.save(poll);
            Poll poll2 = new Poll();
            poll2.setAsker(asker);
            poll2.setTitle("Paras unicafe ruoka");
            poll2 = pollRepo.save(poll2);
            
            Option option = new Option();
            option.setPoll(poll);
            option.setContent("Java");
            option = optionRepo.save(option);
            Option option2 = new Option();
            option2.setContent("Vegepuikot");
            option2.setPoll(poll2);
            option2 = optionRepo.save(option2);
            
            category.addPoll(poll);
            categoryRepo.save(category);
            category2.addPoll(poll2);
            categoryRepo.save(category2);
            
            poll.addOption(option);
            pollRepo.save(poll);
            poll2.addOption(option2);
            pollRepo.save(poll2);
            
            Category category3 = new Category();
            category3.setName("Elokuvat ja tv-sarjat");
            categoryRepo.save(category3);
        }
    }
    
    @RequestMapping("*")
    public String handleDefault() {
        return "redirect:/polls";
    }
}
