
package wad.controller;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import wad.domain.Asker;
import wad.domain.Option;
import wad.domain.Poll;
import wad.repository.AskerRepository;
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
    
    @PostConstruct
    public void init() {
        if(askerRepo.findOne(1L) == null) {
            Asker asker = new Asker();
            asker.setUsername("milla");
            asker.setPassword("milla");
            askerRepo.save(asker);
            
            Poll poll = new Poll();
            poll.setAsker(asker);
            poll.setTitle("Paras unicafe ateria");
            
            Option option = new Option();
            option.setContent("vegepuikot");
            option.setPoll(poll);
            //option.addVote();
            
            Option option2 = new Option();
            option.setContent("kaalilaatikko");
         
            pollRepo.save(poll);
            option.setPoll(poll);
            optionRepo.save(option);
            optionRepo.save(option2);
            poll.addOption(option);
            poll.addOption(option2);
            optionRepo.save(option);
            optionRepo.save(option2); 
            pollRepo.save(poll);
        }
    }
    
    @RequestMapping("*")
    public String handleDefault() {
        return "redirect:/";
    }
}
