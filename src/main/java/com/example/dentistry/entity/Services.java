package com.example.dentistry.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public")
public class Services {

    @Id
    private Integer id;
}
