package ca.sheridancollege.minhaja.testa4.beans;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHORNAME")
    private String authorName;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "QUANTITY")
    private int quantity;
}
