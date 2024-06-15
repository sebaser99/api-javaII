package co.com.ps.C23A.service;

import co.com.ps.C23A.domain.Products;
import co.com.ps.C23A.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService implements  IProductService{
    private final ProductRepository productRepository;
    @Transactional(readOnly = true)
    @Override
    public Products findById(Long idProduct) {
        Optional<Products> productTmp = productRepository.findById(idProduct);
        if(productTmp.isPresent()){
            return productTmp.get();
        } else {
            throw new RuntimeException("Product not found" + idProduct);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Products findByName(String name) {
        Optional<Products> productTmp = productRepository.findByProductName(name);
        if(productTmp.isPresent()){
            return productTmp.get();
        } else {
            throw new RuntimeException("Product not found" + name);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Products> findAll() {
        return productRepository.findAll();
    }
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public Products save(Products product) {
        return productRepository.save(product);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public Products update(Products product) {
        if(productRepository.existsById(product.getProductId())) {
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found with id" + product.getProductId());
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public void delete(Long idProduct) {
        if(productRepository.existsById(idProduct)){
            productRepository.existsById(idProduct);
        } else {
            throw new RuntimeException("Product not found with id" + idProduct);
        }

    }
}
