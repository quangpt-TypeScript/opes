package com.example.demo.model;

import com.mongodb.lang.NonNull;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Id;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
@Document(collection = "employee")
public class Employee{
    @Id
    private @NonNull String id;
    private @NonNull String email;
    private @NonNull String password;
    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull String departmentId;
    private String genderType;

    @Transient
    private String message;
    @CreatedDate
    private Date created;
    @CreatedBy
    private String creator;
    @LastModifiedDate
    private Date updated;
    @LastModifiedBy
    private String updater;

}
