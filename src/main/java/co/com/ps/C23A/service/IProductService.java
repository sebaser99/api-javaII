package co.com.ps.C23A.service;

import co.com.ps.C23A.domain.Products;

import java.util.List;

public interface IProductService {

    Products findById(Long idProduct);
    Products findByName(String nombre);
    List<Products> findAll();
    Products save(Products product);
    Products update(Products category);
    void delete(Long idProduct);
}
