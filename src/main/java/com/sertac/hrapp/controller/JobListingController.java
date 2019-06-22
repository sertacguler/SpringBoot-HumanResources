package com.sertac.hrapp.controller;

import com.sertac.hrapp.entity.JobListing;
import com.sertac.hrapp.service.JobListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class JobListingController {

    private final JobListingService jobListingService;

    @Autowired
    public JobListingController(JobListingService jobListingService) {
        this.jobListingService = jobListingService;
    }

    /*@GetMapping("/login")
     public String login() {
         return "login";
     }ÇALIŞMADI TEKRAR BAKARIZ*/

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
    public String listings(Model model) {
        model.addAttribute("datas", jobListingService.findAllState(true));
        return "listing";
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
    public String details(Long id, Model model) {
        JobListing jobListing = jobListingService.findById(id);
        model.addAttribute("id", jobListing.getId());
        model.addAttribute("yayinlanma", jobListing.getCreateDate());
        model.addAttribute("isUnvani", jobListing.getIsUnvani());
        model.addAttribute("isTanimi", jobListing.getIsTanimi());
        model.addAttribute("elemanSayisi", jobListing.getElemanSayisi());
        model.addAttribute("basvuruTarihi", jobListing.getBasvuruTarihi());
        boolean degisken = true;
        model.addAttribute("giris", degisken);
        return "detail";
    }

    @GetMapping("/findById")
    @ResponseBody
    public JobListing findById(Long id) {
        return jobListingService.findById(id);
    }

}
