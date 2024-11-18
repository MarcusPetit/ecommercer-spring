package br.com.marcus.ecommerce.dto;

import br.com.marcus.ecommerce.entities.Category;

public class CategoryDTO {
    private Long id;
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
