package com.northwind.northwind.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Data
public class CategoryDto implements Serializable {
    @JsonProperty("category_id")
    private final Integer category_id;

    @JsonProperty("categoryName")
    private final String categoryName;

    @JsonProperty("description")
    private final String description;

    public CategoryDto(Integer category_id, String categoryName, String description) {
        this.category_id = category_id;
        this.categoryName = categoryName;
        this.description = description;
    }
}
