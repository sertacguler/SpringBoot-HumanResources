package com.sertac.hrapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "applicant")
public class Applicant extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "y_opinion")
    private String yOpinion;

    /*@ManyToMany(mappedBy = "applicantList", fetch = FetchType.LAZY)
    private List<JobListing> jobListingList;*/

    @Column(name = "job_id")
    private Long jobId;

}
