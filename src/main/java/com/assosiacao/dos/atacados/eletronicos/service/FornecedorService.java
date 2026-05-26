package com.assosiacao.dos.atacados.eletronicos.service;

import com.assosiacao.dos.atacados.eletronicos.dto.FornecedorDTO;
import com.assosiacao.dos.atacados.eletronicos.mapper.FornecedorMapper;
import com.assosiacao.dos.atacados.eletronicos.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FornecedorService {

    private final FornecedorRepository repository;
    private final FornecedorMapper mapper;

    public List<FornecedorDTO> listar() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public FornecedorDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));
    }

    public FornecedorDTO salvar(FornecedorDTO dto) {
        var entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    public FornecedorDTO atualizar(Long id, FornecedorDTO dto) {
        repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));
        dto.setId(id);
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public void deletar(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));
        repository.deleteById(id);
    }
}
