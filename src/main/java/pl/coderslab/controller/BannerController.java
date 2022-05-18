package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.dao.BannerDao;
import pl.coderslab.entity.Banners;

import java.util.List;

@Controller
public class BannerController {
    @Autowired
    BannerDao bannerDao;

    @GetMapping(value = "/dashboard/{id}")
    public String showInfo(Model model, @PathVariable("id") int id){
//        List<Banners> banners = bannerDao.getBannerById(id);
//        model.addAttribute("banner", banners);
        return "dashboard";

    }



}
