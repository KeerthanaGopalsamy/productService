package dev.keerthana.productservice.dto;

import lombok.NoArgsConstructor;


public class createProductResponseDTO {
    private String title;
    private String description;
    private categoryRequestDTO category;
    private String imageURL;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public categoryRequestDTO getCategory() {
        return new categoryRequestDTO();
    }

    public void setCategory(categoryRequestDTO category) {
        this.category = category;
    }

    public String getImage() {
        return imageURL;
    }

    public void setImage(String image) {
        this.imageURL = image;
    }
}
