package com.assosiacao.dos.atacados.eletronicos.mapper;

import com.assosiacao.dos.atacados.eletronicos.dto.FornecedorDTO;
import com.assosiacao.dos.atacados.eletronicos.model.Fornecedor;
import org.springframework.stereotype.Component;

@Component
public class FornecedorMapper {

    public Fornecedor toEntity(FornecedorDTO dto) {
        return Fornecedor.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .cnpj(dto.getCnpj())
                .email(dto.getEmail())
                .telefone(dto.getTelefone())
                .endereco(dto.getEndereco())
                .ativo(dto.getAtivo() != null ? dto.getAtivo() : true)
                .build();
    }

    public FornecedorDTO toDTO(Fornecedor entity) {
        return FornecedorDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .cnpj(entity.getCnpj())
                .email(entity.getEmail())
                .telefone(entity.getTelefone())
                .endereco(entity.getEndereco())
                .ativo(entity.getAtivo())
                .build();
    }
}
