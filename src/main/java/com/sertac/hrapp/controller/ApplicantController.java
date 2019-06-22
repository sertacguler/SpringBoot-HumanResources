package com.sertac.hrapp.controller;

import com.sertac.hrapp.entity.Applicant;
import com.sertac.hrapp.entity.JobListing;
import com.sertac.hrapp.service.ApplicantService;
import com.sertac.hrapp.service.JobListingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

   /* @Autowired
    private JobListingServiceImpl jobListingService;*/

    private Long job_id;

    //---------- Save
    @GetMapping("/detail/basvurs")
    public String basvurJobListing(Applicant applicant, @RequestParam Long id) {
        job_id = id;
        System.err.println("job_id" + id);
        return "basvur";
    }

    @PostMapping("/ff")
    public String save(Applicant applicant) {
        /*JobListing jobListing = jobListingService.findById(job_id);
        System.err.println("joblist : " + jobListing);
        List<JobListing> jobListingList = new ArrayList<>();
        jobListingList.add(jobListing);
        System.err.println("joblist : " + jobListingList);
        applicant.setJobListingList(jobListingList);*/

        applicant.setCreateDate(new Date());
        applicantService.save(applicant);
        return "basvuruson";
    }
    //----------

}
