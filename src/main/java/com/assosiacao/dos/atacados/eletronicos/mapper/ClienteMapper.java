package com.assosiacao.dos.atacados.eletronicos.mapper;

import com.assosiacao.dos.atacados.eletronicos.dto.ClienteDTO;
import com.assosiacao.dos.atacados.eletronicos.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteDTO dto) {
        return Cliente.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .cpfCnpj(dto.getCpfCnpj())
                .email(dto.getEmail())
                .telefone(dto.getTelefone())
                .endereco(dto.getEndereco())
                .ativo(dto.getAtivo() != null ? dto.getAtivo() : true)
                .build();
    }

    public ClienteDTO toDTO(Cliente entity) {
        return ClienteDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .cpfCnpj(entity.getCpfCnpj())
                .email(entity.getEmail())
                .telefone(entity.getTelefone())
                .endereco(entity.getEndereco())
                .ativo(entity.getAtivo())
                .build();
    }
}
