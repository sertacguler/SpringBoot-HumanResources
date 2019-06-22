package com.sertac.hrapp.dao;

import com.sertac.hrapp.entity.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.event.ListDataEvent;
import java.util.List;

@Repository
public interface JobListingDAO extends JpaRepository<JobListing, Long> {

    //List<JobListing> findAllState(Boolean state);

    List<JobListing> findJobListingByStateEquals(Boolean state);

}
