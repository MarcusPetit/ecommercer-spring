package br.com.marcus.ecommerce.dto;

import br.com.marcus.ecommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public class ProductDTO {

    private Long id;
    @NotBlank(message = "Campo obrigatorio")
    @Size(message = "minimo 3 e maximo 80", min = 3, max = 80)
    private String name;

    @Size(min = 10)
    private String description;


    @Positive(message = "Preço deve ser positivo")
    private Double price;
    @URL(message = "Deve ser uma URL válida")
    private String imgUrl;


    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.imgUrl = product.getImgUrl();
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
