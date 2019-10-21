package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "opes_details")
public class OpesDetails {
    @Id
    private @NonNull String id;
    private @NonNull String reviewer;
    private @NonNull String stage;
    private @NonNull Enum status;
    private @NonNull String created;
    private @NonNull String updated;
    private @NonNull String creator;
    private @NonNull String updater;
    private @NonNull String opesDetailId;
}
