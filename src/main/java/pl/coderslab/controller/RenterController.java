package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.Renters;
import pl.coderslab.repository.BannerRepository;
import pl.coderslab.repository.RentersRepository;
import pl.coderslab.repository.RentsRepository;

import javax.validation.Valid;

@Repository
@Controller
public class RenterController {
    @Autowired
    RentersRepository rentersRepository;
    @Autowired
    RentsRepository rentsRepository;
    @Autowired
    BannerRepository bannerRepository;

    @RequestMapping(value = "/dashboard/add-renter",method = RequestMethod.GET)
    public String showAddRenterForm(Model model){
        model.addAttribute("renter", new Renters());
        return "add-renter";
    }
    @RequestMapping(value = "/dashboard/add-renter", method = RequestMethod.POST)
    public String AddRenterForm(@Valid Renters renters, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "add-renter";
        }
        rentersRepository.save(renters);
        return "redirect:/dashboard/";
    }
}
