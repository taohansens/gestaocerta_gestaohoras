package com.gestaocerta.microgestaohoras.services;

import com.gestaocerta.microgestaohoras.entities.BancoHoras;
import com.gestaocerta.microgestaohoras.repositories.BancoHorasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BancoHorasService {
    private final BancoHorasRepository repository;
    private final LogProducer log;

    @Transactional(readOnly = true)
    public List<BancoHoras> findByEmpregadoId(Long id) {
        List<BancoHoras> list = repository.findAllByEmpregadoId(id);
        sendAuditMessage(String.format("%s - CONSULTA Banco de Horas ID %d.", LocalDateTime.now(), id));
        return list;
    }

    public void save(BancoHoras bancoDeHoras) {
        repository.save(bancoDeHoras);
        sendAuditMessage(String.format("%s - PONTO VALIDADO RECEBIDO Banco de Horas ID %d.", LocalDateTime.now(), bancoDeHoras.getId()));
    }

    private void sendAuditMessage(String message) {
        try {
            log.sendAuditMessage(message);
        } catch (Exception e) {
            System.err.println("Falha ao enviar log para o RabbitMQ: " + e.getMessage());
        }
    }


}
