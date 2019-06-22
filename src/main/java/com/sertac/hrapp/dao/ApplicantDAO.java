package com.sertac.hrapp.dao;

import com.sertac.hrapp.entity.Applicant;
import com.sertac.hrapp.entity.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantDAO extends JpaRepository<Applicant, Long> {

}
