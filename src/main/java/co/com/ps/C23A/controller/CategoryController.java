package co.com.ps.C23A.controller;

import co.com.ps.C23A.domain.Categories;
import co.com.ps.C23A.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping("/name/{name}")
    public ResponseEntity<Categories> getCategoryByName(@PathVariable String name){
        try {
            return  ResponseEntity.ok(categoryService.findByName(name));
        } catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Categories> getCategoryById(@PathVariable Long id){
        try {
            return  ResponseEntity.ok(categoryService.findById(id));
        } catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Categories>> findAll(){
        try {
            return  ResponseEntity.ok(categoryService.findAll());
        } catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Categories> saveCategory(@RequestBody Categories category){
        try{
            return ResponseEntity.ok(categoryService.save(category));
        } catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Categories> updateCategory(@RequestBody Categories category){
        try{
            return ResponseEntity.ok(categoryService.update(category));
        } catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> DeleteByIdCategory(@PathVariable("id") Long id){
        try {
            categoryService.delete(id);
            return  ResponseEntity.ok("ok");
        } catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
