package com.assosiacao.dos.atacados.eletronicos.mapper;

import com.assosiacao.dos.atacados.eletronicos.dto.ProdutoDTO;
import com.assosiacao.dos.atacados.eletronicos.model.Fornecedor;
import com.assosiacao.dos.atacados.eletronicos.model.Produto;
import com.assosiacao.dos.atacados.eletronicos.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProdutoMapper {

    private final FornecedorRepository fornecedorRepository;

    public Produto toEntity(ProdutoDTO dto) {
        Fornecedor fornecedor = null;
        if (dto.getFornecedorId() != null) {
            fornecedor = fornecedorRepository.findById(dto.getFornecedorId()).orElse(null);
        }
        return Produto.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .preco(dto.getPreco())
                .quantidade(dto.getQuantidade())
                .categoria(dto.getCategoria())
                .fornecedor(fornecedor)
                .ativo(dto.getAtivo() != null ? dto.getAtivo() : true)
                .build();
    }

    public ProdutoDTO toDTO(Produto entity) {
        return ProdutoDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .preco(entity.getPreco())
                .quantidade(entity.getQuantidade())
                .categoria(entity.getCategoria())
                .fornecedorId(entity.getFornecedor() != null ? entity.getFornecedor().getId() : null)
                .fornecedorNome(entity.getFornecedor() != null ? entity.getFornecedor().getNome() : null)
                .ativo(entity.getAtivo())
                .build();
    }
}
