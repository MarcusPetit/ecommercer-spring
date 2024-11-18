package br.com.marcus.ecommerce.services;

import br.com.marcus.ecommerce.dto.ProductDTO;
import br.com.marcus.ecommerce.entities.Product;
import br.com.marcus.ecommerce.repositories.ProductRepository;
import br.com.marcus.ecommerce.services.exeptions.ResourceNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired


    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream().map(ProductDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        return productRepository.findById(id).map(ProductDTO::new).orElseThrow(() -> new ResourceNotFoundExeption("Produto não encontrado"));
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findByPage(int page, int size, String sortBy, String direction) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(direction), sortBy);
        return productRepository.findAll(pageable).map(ProductDTO::new);
    }

    public ProductDTO insert(ProductDTO dto) {
        Product product = new Product();
        copyDtoToEntity(dto, product);
        productRepository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        Product product = productRepository.getOne(id);
        copyDtoToEntity(dto, product);
        productRepository.save(product);
        return new ProductDTO(product);
    }

    private void copyDtoToEntity(ProductDTO dto, Product product) {
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImgUrl(dto.getImgUrl());
        productRepository.saveAndFlush(product);

    }

    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }


}
