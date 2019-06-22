package com.sertac.hrapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date createDate;

}
