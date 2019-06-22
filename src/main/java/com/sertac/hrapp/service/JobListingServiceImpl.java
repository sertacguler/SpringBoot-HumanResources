package com.sertac.hrapp.service;

import com.sertac.hrapp.dao.JobListingDAO;
import com.sertac.hrapp.entity.JobListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobListingServiceImpl implements JobListingService {

    private JobListingDAO jobListingDAO;

    @Autowired
    public JobListingServiceImpl(JobListingDAO jobListingDAO) {
        this.jobListingDAO = jobListingDAO;
    }

    @Transactional
    @Override
    public JobListing save(JobListing jobListing) {
        return jobListingDAO.save(jobListing);
    }

    @Transactional
    @Override
    public JobListing update(JobListing jobListing) {
        return jobListingDAO.save(jobListing);
    }

    @Transactional
    @Override
    public void delete(JobListing jobListing) {
        jobListingDAO.delete(jobListing);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        jobListingDAO.deleteById(id);
    }

    @Transactional
    @Override
    public List<JobListing> findAll() {
        return jobListingDAO.findAll();
    }

    @Transactional
    @Override
    public JobListing findById(Long id) {
        return jobListingDAO.findById(id).get();
    }

    @Override
    public void state(Long id) {
        JobListing jobListing = findById(id);
        if (jobListing.getState().equals(true)) {
            jobListing.setState(false);
        } else {
            jobListing.setState(true);
        }
        jobListingDAO.save(jobListing);
    }

    @Transactional
    @Override
    public Page<JobListing> findAllPage(Pageable page) {
        return jobListingDAO.findAll(page);
    }

    @Transactional
    @Override
    public List<JobListing> findAllState(Boolean state) {
        //return jobListingDAO.findAllState(state);
        return jobListingDAO.findJobListingByStateEquals(state);
    }

}
