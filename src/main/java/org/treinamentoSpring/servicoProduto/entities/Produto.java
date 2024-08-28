package org.treinamentoSpring.servicoProduto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome", length = 100, nullable=false)
    private String nome;

    @Column(name = "quantidade", nullable=false)
    private Integer quantidade;
}
