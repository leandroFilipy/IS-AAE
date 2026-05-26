package com.assosiacao.dos.atacados.eletronicos.repository;

import com.assosiacao.dos.atacados.eletronicos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
