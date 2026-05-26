package com.assosiacao.dos.atacados.eletronicos.service;

import com.assosiacao.dos.atacados.eletronicos.dto.ClienteDTO;
import com.assosiacao.dos.atacados.eletronicos.mapper.ClienteMapper;
import com.assosiacao.dos.atacados.eletronicos.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public List<ClienteDTO> listar() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    public ClienteDTO salvar(ClienteDTO dto) {
        var entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    public ClienteDTO atualizar(Long id, ClienteDTO dto) {
        repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        dto.setId(id);
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public void deletar(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        repository.deleteById(id);
    }
}
