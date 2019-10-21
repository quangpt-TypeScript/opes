package com.example.demo.model;

import com.mongodb.lang.NonNull;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "profile")
public class EmployeeProfile {
    @Id
    private @NonNull String rank;
    private int accountStatus;
    private String position;
    private String dateOfBirth;
    private String image;

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
