package co.com.ps.C23A.controller;

import co.com.ps.C23A.domain.Products;
import co.com.ps.C23A.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final IProductService productService;

    @GetMapping("/name/{name}")
    public ResponseEntity<Products> getProductByName(@PathVariable String name){
        try {
            return  ResponseEntity.ok(productService.findByName(name));
        } catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long id){
        try {
            return  ResponseEntity.ok(productService.findById(id));
        } catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Products>> findAll(){
        try {
            return  ResponseEntity.ok(productService.findAll());
        } catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Products> saveProduct(@RequestBody Products product){
        try{
            return ResponseEntity.ok(productService.save(product));
        } catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Products> updateProduct(@RequestBody Products product){
        try{
            return ResponseEntity.ok(productService.update(product));
        } catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> DeleteByIdProduct(@PathVariable("id") Long id){
        try {
            productService.delete(id);
            return  ResponseEntity.ok("ok");
        } catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
