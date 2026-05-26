package com.assosiacao.dos.atacados.eletronicos.dto;

import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidade;
    private String categoria;
    private Long fornecedorId;
    private String fornecedorNome;
    private Boolean ativo;
}
