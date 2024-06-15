package co.com.ps.C23A.service;

import co.com.ps.C23A.domain.Categories;
import co.com.ps.C23A.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService implements  ICategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    @Override
    public Categories findById(Long idCategory) {
        Optional<Categories> categoryTmp = categoryRepository.findById(idCategory);
        if(categoryTmp.isPresent()){
            return categoryTmp.get();
        } else {
            throw new RuntimeException("Category not found" + idCategory);
        }
    }
    @Transactional(readOnly = true)
    @Override
    public Categories findByName(String name) {
        Optional<Categories> categoryTmp = categoryRepository.findByCategoryName(name);
        if(categoryTmp.isPresent()){
            return categoryTmp.get();
        } else {
            throw new RuntimeException("Category not found" + name);
        }
    }
    @Transactional(readOnly = true)
    @Override
    public List<Categories> findAll() {
        return categoryRepository.findAll();
    }
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    @Override
    public Categories save(Categories category) {
        return categoryRepository.save(category);
    }
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public Categories update(Categories category) {
        if (categoryRepository.existsById(category.getCategoryId())){
            return categoryRepository.save(category);
        }else{
            throw new RuntimeException("Category not found with id: " + category.getCategoryId());
        }
    }
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public void delete(Long idCategory) {
        if (categoryRepository.existsById(idCategory)) {
            categoryRepository.deleteById(idCategory);
        }else {
            throw new RuntimeException("Category not found with id: " + idCategory);
        }
    }
}
