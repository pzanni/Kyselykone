
package wad.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Option;
import wad.domain.Poll;
import wad.repository.AskerRepository;
import wad.repository.CategoryRepository;
import wad.repository.OptionRepository;
import wad.repository.PollRepository;

@Controller
@RequestMapping("/polls")
public class PollController {
    
    @Autowired
    private PollRepository pollRepo;
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private OptionRepository optionRepo;
    @Autowired 
    private AskerRepository askerRepo;
    
    @RequestMapping(method = RequestMethod.GET)
    public String polls(Model model) {
        model.addAttribute("polls", pollRepo.findAll());
        return "index";
    }
    
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String categories(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        return "index";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String poll(Model model, @PathVariable Long id) {
        model.addAttribute("poll", pollRepo.findOne(id));
        model.addAttribute("options", pollRepo.findOne(id).getOptions());
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        model.addAttribute("asker", askerRepo.findByUsername(username));
        return "poll";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String addOption(Model model, @PathVariable Long id, @RequestParam String content) {
        Option option = new Option();
        option.setPoll(pollRepo.findOne(id));
        option.setContent(content);
        option = optionRepo.save(option);
        
        pollRepo.findOne(id).addOption(option);
        pollRepo.save(pollRepo.findOne(id));
        
        return "redirect:/polls/" + pollRepo.findOne(id).getId();
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addpoll(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        return "addpoll";
    }
    
    //@Secured("USER")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String create(Model model, @RequestParam String title) {
        Poll poll = new Poll();
        poll.setTitle(title);
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.isAuthenticated()) {
            String username = auth.getName();
            poll.setAsker(askerRepo.findByUsername(username));
        }
        
        pollRepo.save(poll);
        model.addAttribute("poll", poll);
        return "redirect:/polls/" + poll.getId();
    }
}
