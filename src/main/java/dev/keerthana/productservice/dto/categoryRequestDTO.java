package dev.keerthana.productservice.dto;

import lombok.NoArgsConstructor;


public class categoryRequestDTO {
    private String title;
    private Integer id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
