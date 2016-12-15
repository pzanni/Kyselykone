
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Option;
import wad.repository.OptionRepository;


@Controller
@RequestMapping("/options")
public class OptionController {
    
    @Autowired
    OptionRepository optionRepo;
    
    @RequestMapping(value = "/{id}/vote", method = RequestMethod.GET) 
    public String vote(@PathVariable Long id) {
        Option option = optionRepo.findOne(id);
        option.addVote();
        optionRepo.save(option);
        return "redirect:/polls/" + option.getPoll().getId().toString();
    }
}

