package com.sertac.hrapp.service;

import com.sertac.hrapp.entity.JobListing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JobListingService {

    JobListing save(JobListing jobListing);

    JobListing update(JobListing jobListing);

    void delete(JobListing jobListing);

    void deleteById(Long id);

    List<JobListing> findAll();

    JobListing findById(Long id);

    void state(Long id);

    Page<JobListing> findAllPage(Pageable page);

    List<JobListing> findAllState(Boolean state);

}
