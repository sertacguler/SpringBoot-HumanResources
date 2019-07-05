package com.sertac.hrapp.controller;

import com.sertac.hrapp.entity.JobListing;
import com.sertac.hrapp.entity.User;
import com.sertac.hrapp.service.JobListingService;
import com.sertac.hrapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class JobListingController {

    private final JobListingService jobListingService;

    @Autowired
    public JobListingController(JobListingService jobListingService) {
        this.jobListingService = jobListingService;
    }

    @Autowired
    private UserService userService;

    //---------- Login
    // Login form with error
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

    @GetMapping("/login")
    public String login(User user) {
        return "login";
    }

    @PostMapping("/login")
    public String logins(User user) {
        user.setId(1L);
        boolean x = userService.login(user);
        if (x) {
            return "redirect:/";
        } else {
            return "login.html";
        }
    }
    //----------

    @GetMapping("/")
    public String showPage(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("data", jobListingService.findAllPage(new PageRequest(page, 5)));
        model.addAttribute("currentPage", page);
        return "index";
    }

    //---------- Save
    @GetMapping("/save")
    public String savePage(JobListing jobListing, Model model) {
        model.addAttribute("yayinlanma", new Date());
        return "savejob";
    }

    @PostMapping("/saves")
    public String save(JobListing jobListing) {
        jobListing.setCreateDate(new Date());
        jobListingService.save(jobListing);
        return "redirect:/";
    }
    //----------

    @GetMapping("/listing")
    public ModelAndView listings(Model model) {
        ModelAndView mv = new ModelAndView("Listing.html");

        List<JobListing> jobListings = new ArrayList<>();
        jobListings = jobListingService.findAllState(true);

        model.addAttribute("datas", jobListingService.findAllState(true));
        mv.addObject("datas", jobListings);

        return mv;
    }

    @GetMapping("/delete")
    public String deleteJobListing(Long id) {
        jobListingService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/state")
    public String state(Long id) {
        jobListingService.state(id);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public ModelAndView details(Long id, Model model) {
        JobListing jobListing = jobListingService.findById(id);

        boolean degisken = true;
        model.addAttribute("giris", degisken);

        ModelAndView mv = new ModelAndView("detail.html");
        mv.addObject("datas", jobListing);
        return mv;
    }

    @GetMapping("/findById")
    @ResponseBody
    public JobListing findById(Long id) {
        return jobListingService.findById(id);
    }

}
