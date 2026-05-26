package com.assosiacao.dos.atacados.eletronicos.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpfCnpj;
    private String email;
    private String telefone;
    private String endereco;
    private Boolean ativo;
}
