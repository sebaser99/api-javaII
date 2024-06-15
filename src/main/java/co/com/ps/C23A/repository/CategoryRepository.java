package co.com.ps.C23A.repository;

import co.com.ps.C23A.domain.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Categories,Long> {
    Optional<Categories> findByCategoryName(String name);
}
