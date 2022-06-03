package com.femio.staff.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "staffs")
public class StaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
