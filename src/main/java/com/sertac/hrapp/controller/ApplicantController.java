package com.sertac.hrapp.controller;

import com.sertac.hrapp.entity.Applicant;
import com.sertac.hrapp.entity.JobListing;
import com.sertac.hrapp.service.ApplicantService;
import com.sertac.hrapp.service.JobListingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ApplicantController {

    private ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @Autowired
    private JobListingServiceImpl jobListingService;

    //---------- Save
    @GetMapping("/detay/basvurs")
    public String basvurJobListing(Applicant applicant, @RequestParam Long id, Model model) {
        model.addAttribute("job_id", id);
        return "basvur";
    }

    @PostMapping("/ff/{j_id}")
    public String save(Applicant applicant, @PathVariable("j_id") Long j_id) {

        JobListing jobListing = jobListingService.findById(j_id);

        applicant.setJobListing(jobListing);
        applicant.setCreateDate(new Date());
        applicantService.save(applicant);
        return "basvuruson";
    }
    //----------

}
