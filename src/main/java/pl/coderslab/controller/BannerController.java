package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.Admin;
import pl.coderslab.entity.Banners;
import pl.coderslab.entity.Rents;
import pl.coderslab.repository.AdminRepository;
import pl.coderslab.repository.BannerRepository;
import pl.coderslab.repository.RentsRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@Repository
public class BannerController {
    @Autowired
    BannerRepository bannerRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    RentsRepository rentsRepository;

    @RequestMapping(value = "/dashboard/info/{id}", method = RequestMethod.GET)
    public String showInfo(Model model, @PathVariable("id") Long id){
        List<Banners> banners = bannerRepository.getBannersById(id);
        model.addAttribute("banner", banners);
        model.addAttribute("id",id);
        return "show-info";
    }
    @RequestMapping(value = "/dashboard/info/{id}", method = RequestMethod.POST)
    public String info(){
        return "redirect:/dashboard/";
    }
    @RequestMapping(value = "/dashboard/delete/{id}", method = RequestMethod.GET)
    public String showDeleteForm( @PathVariable("id") Long id,Model model){
        model.addAttribute("id",id);

        return "delete-form";
    }
    @RequestMapping(value = "/dashboard/delete/{id}", method = RequestMethod.POST)
    public String deleteForm(@PathVariable("id") Long id){
        Banners banners = bannerRepository.getById(id);
        List<Rents> rents = rentsRepository.findByBannerId(id);

        if(rents.isEmpty()){

        }else{
            Rents rents1 = rents.get(0);
            rentsRepository.deleteById(rents1.getId());
        }

        bannerRepository.deleteById(banners.getId());
        return "redirect:/dashboard/";
    }
    @RequestMapping(value = "/dashboard/add", method = RequestMethod.GET)
    public String showAddForm(Model model){
        model.addAttribute("banners", new Banners());
        return "add-banner";
    }
    @RequestMapping(value = "/dashboard/add", method = RequestMethod.POST)
    public String addForm(@Valid Banners banners, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "add-banner";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        Admin admin = adminRepository.getAdminByEmail(email);
        banners.setAdmin(admin);
        bannerRepository.save(banners);
        return "redirect:/dashboard/";
    }
    @RequestMapping(value = "/dashboard/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(Model model){
        model.addAttribute("banners", new Banners());

        return "edit-form";
    }
    @RequestMapping(value = "/dashboard/edit/{id}", method = RequestMethod.POST)
    public String editForm(@Valid Banners banners,@PathVariable("id") Long id){
        String street = banners.getStreet();
        int price = banners.getPrice();
        boolean isRented = banners.getIs_rented();
        bannerRepository.setUserInfoById(street,price,isRented,id);
        return "redirect:/dashboard/";
    }




}
