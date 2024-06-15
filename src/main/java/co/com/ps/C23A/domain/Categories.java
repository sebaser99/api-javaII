package co.com.ps.C23A.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Genera get and set
@NoArgsConstructor //genera constructor sin argumentos
@AllArgsConstructor //genera constructor con argumentos full
@Entity //entidad de la base de datos
@Table(name="categories") // que tabla representa en la base de datos.
@Builder //Patron de diseño
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "category_id", length = 100)
    private Long categoryId;

    @Column(columnDefinition = "category_name", nullable = false, length = 255)
    private String categoryName;

    @Column(columnDefinition = "description")
    private String description;
}
