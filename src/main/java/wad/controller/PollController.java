
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.repository.CategoryRepository;
import wad.repository.PollRepository;

@Controller
@RequestMapping("/polls")
public class PollController {
    
    @Autowired
    private PollRepository pollRepo;
    @Autowired
    private CategoryRepository categoryRepo;
    
    @RequestMapping(method = RequestMethod.GET)
    public String polls(Model model) {
        model.addAttribute("polls", pollRepo.findAll());
        return "index";
    }
    
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        return "index";
    }
}
