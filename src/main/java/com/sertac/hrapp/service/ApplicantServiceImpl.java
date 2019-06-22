package com.sertac.hrapp.service;

import com.sertac.hrapp.dao.ApplicantDAO;
import com.sertac.hrapp.entity.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    private ApplicantDAO applicantDAO;

    @Autowired
    public ApplicantServiceImpl(ApplicantDAO applicantDAO) {
        this.applicantDAO = applicantDAO;
    }

    @Transactional
    @Override
    public Applicant save(Applicant applicant) {
        return applicantDAO.save(applicant);
    }

    @Transactional
    @Override
    public Applicant update(Applicant applicant) {
        return applicantDAO.save(applicant);
    }

    @Transactional
    @Override
    public void delete(Applicant applicant) {
        applicantDAO.delete(applicant);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        applicantDAO.deleteById(id);
    }

    @Transactional
    @Override
    public List<Applicant> findAll() {
        return applicantDAO.findAll();
    }

    @Transactional
    @Override
    public Applicant findById(Long id) {
        return applicantDAO.findById(id).get();
    }

    @Transactional
    @Override
    public Page<Applicant> findAllPage(Pageable page) {
        return null;
    }

}
