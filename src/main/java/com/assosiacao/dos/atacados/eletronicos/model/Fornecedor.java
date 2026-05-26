package com.assosiacao.dos.atacados.eletronicos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fornecedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
    private String endereco;

    @Builder.Default
    private Boolean ativo = true;
}
