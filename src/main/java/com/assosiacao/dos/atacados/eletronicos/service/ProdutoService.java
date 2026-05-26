package com.assosiacao.dos.atacados.eletronicos.service;

import com.assosiacao.dos.atacados.eletronicos.dto.ProdutoDTO;
import com.assosiacao.dos.atacados.eletronicos.mapper.ProdutoMapper;
import com.assosiacao.dos.atacados.eletronicos.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    public List<ProdutoDTO> listar() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProdutoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }

    public ProdutoDTO salvar(ProdutoDTO dto) {
        var entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    public ProdutoDTO atualizar(Long id, ProdutoDTO dto) {
        repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
        dto.setId(id);
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public void deletar(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
        repository.deleteById(id);
    }
}
