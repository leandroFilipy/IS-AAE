package com.assosiacao.dos.atacados.eletronicos.repository;

import com.assosiacao.dos.atacados.eletronicos.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
