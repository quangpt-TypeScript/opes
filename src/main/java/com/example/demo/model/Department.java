package com.example.demo.model;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "department")
public class Department {
    @Id
    private @NonNull String id;
    private @NonNull String name;
    private @NonNull String created;
    private @NonNull String updated;
    private @NonNull String creator;
    private @NonNull String updater;
}
