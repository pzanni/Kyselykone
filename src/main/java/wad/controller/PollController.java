
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        return "poll";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addpoll(Model model) {
        return "addpoll";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String create(Model model, @RequestParam String title) {
        Poll poll = new Poll();
        poll.setTitle(title);
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        poll.setAsker(askerRepo.findByUsername(username));
        
        pollRepo.save(poll);
        model.addAttribute("poll", poll);
        return "addpoll";
    }
}
