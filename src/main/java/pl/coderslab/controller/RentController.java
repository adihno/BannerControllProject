package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.Banners;
import pl.coderslab.entity.Renters;
import pl.coderslab.entity.Rents;
import pl.coderslab.repository.BannerRepository;
import pl.coderslab.repository.RentersRepository;
import pl.coderslab.repository.RentsRepository;

import javax.validation.Valid;
import java.util.List;

@Repository
@Controller
public class RentController {
    @Autowired
    RentsRepository rentsRepository;
    @Autowired
    RentersRepository rentersRepository;
    @Autowired
    BannerRepository bannerRepository;

    @RequestMapping(value = "/dashboard/add-rent/{id}", method = RequestMethod.GET)
    public String showAddRentForm(Model model){
        model.addAttribute("rent", new Rents());
        List<Renters> rentersList = rentersRepository.findAll();
        model.addAttribute("renters", rentersList);
        return "add-rent";
    }
    @RequestMapping(value = "/dashboard/add-rent/{id}", method = RequestMethod.POST)
    public String AddRentForm(@Valid Rents rents, BindingResult bindingResult, @PathVariable("id") Long id,Model model){
        if (bindingResult.hasErrors()) {
            return "add-rent";
        }
        List<Banners> bannersList = bannerRepository.getBannersById(id);
        rents.setBanner(bannersList.get(0));
        rentsRepository.save(rents);
        return "redirect:/dashboard/";
    }
}
