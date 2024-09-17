package com.gestaocerta.microgestaohoras.repositories;

import com.gestaocerta.microgestaohoras.entities.BancoHoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BancoHorasRepository extends JpaRepository<BancoHoras, Long> {
    List<BancoHoras> findAllByEmpregadoId(Long empregadoId);
}