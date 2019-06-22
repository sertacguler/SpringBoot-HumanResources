package com.sertac.hrapp.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "joblisting")
public class JobListing extends BaseEntity {

    @Column(name = "is_unvani")
    private String isUnvani;

    @Column(name = "is_tanimi")
    private String isTanimi;

    @Column(name = "eleman_sayisi")
    private Integer elemanSayisi;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "basvuru_tarihi")
    private Date basvuruTarihi;

    /*@ManyToMany
    @JoinTable(name = "joblisting_applicant"
            , joinColumns = {@JoinColumn(name = "joblisting_id")}
            , inverseJoinColumns = {@JoinColumn(name = "applicant_id")})
    private List<Applicant> applicantList;*/

    @Column(name = "state")
    private Boolean state;

}
