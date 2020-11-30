package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(Long id, String title, List<Product> products) {
        this.id = id;
        this.title = title;
        this.products = products;
    }

    public String getStringId() {
        return id.toString();
    }

    @Override
    public String toString() {
        return String.format("Category [id = %d, title = %s]", id, title);
    }
}