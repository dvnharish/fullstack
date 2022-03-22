package com.harish.backend.employee.manager.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String eMail;
    private String jobTitle;
    private String phoneNumber;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String employeeCode;

}
