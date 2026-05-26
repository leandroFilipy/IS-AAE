package com.assosiacao.dos.atacados.eletronicos.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FornecedorDTO {

    private Long id;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
    private String endereco;
    private Boolean ativo;
}
