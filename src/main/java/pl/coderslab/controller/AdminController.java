package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AdminDao;
import pl.coderslab.dao.BannerDao;
import pl.coderslab.dao.RentsDao;
import pl.coderslab.entity.Admin;
import pl.coderslab.entity.Banners;
import pl.coderslab.entity.Rents;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class AdminController {
    @Autowired
    AdminDao adminDao;
    @Autowired
    BannerDao bannerDao;
    @Autowired
    RentsDao rentsDao;



    private final Validator validator;
    public AdminController(Validator validator) {
        this.validator = validator;
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm(Model model){
            Admin admin = new Admin();
            model.addAttribute("admin",admin);
            return "register-form";

    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerForm(@RequestParam String email, @RequestParam String password){
        Admin admin = new Admin();
        Set<ConstraintViolation<Admin>> violations = validator.validate(admin);
        if(violations.isEmpty()){
            adminDao.saveAdmin(admin);
            admin.setEmail(email);
            admin.setPassword(password);
            return "success";

        }else{
            for (ConstraintViolation<Admin> violation : violations){
                System.out.println(violation.getPropertyPath()+"-----> "+violation);
            }
            return "register";
        }

    }

    @GetMapping(value = "/login")
    public String showLoginForm(){
        return "login-form";
    }
    @GetMapping(value = "/access-denied")
    public String showAccessDenied(){

        return "access-denied";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String showDashboard(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        Admin admin = adminDao.getAdminByEmail(email);
        int adminId = admin.getId();
        List<Banners> bannerList = bannerDao.getBannersListByAdminId(adminId);
        model.addAttribute("banners",bannerList);
        return "dashboard";
    }
    @RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    public String dashboard(){
        return "dashboard";
    }


//    @RequestMapping(value = "/dashboard/info/{id}", method = RequestMethod.GET)
//    public String showInfo(Model model, @PathVariable("id") int id){
//        List<Banners> banners = bannerDao.getBannerById(id);
//        model.addAttribute("banner", banners);
//        return "showInfo";
//
//    }
//    @RequestMapping(value = "/dashboard/info/{id}", method = RequestMethod.POST)
//    public String info(){
//        return "redirect:/dashboard";
//    }


}
