
package wad.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Asker;
import wad.repository.AskerRepository;


@Controller
@RequestMapping("/register")
public class RegistrationController {
    
   @Autowired
   AskerRepository askerRepo;
    
    @RequestMapping(method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("asker", new Asker());
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("insider", auth.getName());
        
        return "form";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String addAsker(@Valid @ModelAttribute Asker asker, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "form";
        }
        
        asker.addAuthority("USER");
        askerRepo.save(asker);
        return "redirect:/login";
    }
    
}
