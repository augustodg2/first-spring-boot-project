package dev.augustodias.firstproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @Setter(value = AccessLevel.NONE)
    @OneToMany(mappedBy = "category")
    @GeneratedValue
    private List<Product> products = new ArrayList<>();

    public Category(String name){
        this.name = name;
    }
}

