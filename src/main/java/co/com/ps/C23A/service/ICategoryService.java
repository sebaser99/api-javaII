package co.com.ps.C23A.service;

import co.com.ps.C23A.domain.Categories;

import java.util.List;


public interface ICategoryService {
    Categories findById(Long idCategory);
    Categories findByName(String nombre);
    List<Categories> findAll();
    Categories save(Categories category);
    Categories update(Categories category);
    void delete(Long idCategory);
}
