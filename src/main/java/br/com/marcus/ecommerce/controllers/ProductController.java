package br.com.marcus.ecommerce.controllers;

import br.com.marcus.ecommerce.dto.ProductDTO;
import br.com.marcus.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping(value = "/page")
    public Page<ProductDTO> findByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                       @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                       @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                       @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        return productService.findByPage(page, linesPerPage, orderBy, direction);
    }

    @PostMapping
    public ProductDTO insert(@RequestBody ProductDTO dto) {
        return productService.insert(dto);
    }

    @PutMapping(value = "/{id}")
    public ProductDTO update(@PathVariable Long id, @RequestBody ProductDTO dto) {
        return productService.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
