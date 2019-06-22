package com.sertac.hrapp.service;

import com.sertac.hrapp.entity.Applicant;
import com.sertac.hrapp.entity.JobListing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ApplicantService {

    Applicant save(Applicant applicant);

    Applicant update(Applicant applicant);

    void delete(Applicant applicant);

    void deleteById(Long id);

    List<Applicant> findAll();

    Applicant findById(Long id);

    Page<Applicant> findAllPage(Pageable page);

}
