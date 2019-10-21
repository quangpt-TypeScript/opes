package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NonNull
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "opes_details")
public class OpesDetail {
    @Id
    private @NonNull String id;
    private @NonNull String category;
    private @NonNull String content;
    private @NonNull String target;
    private @NonNull String percent;
    private @NonNull String result;
    private @NonNull String userReport;
    private @NonNull String reviewerReport;
    private @NonNull String bumReport;
    private @NonNull String userRating;
    private @NonNull String reviewerRating;
    private @NonNull String bumRating;
    private @NonNull String created;
    private @NonNull String updated;
    private @NonNull String creator;
    private @NonNull String updater;

}
