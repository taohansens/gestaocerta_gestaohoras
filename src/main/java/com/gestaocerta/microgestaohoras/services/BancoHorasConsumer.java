package com.gestaocerta.microgestaohoras.services;

import com.gestaocerta.microgestaohoras.dtos.ValidacaoPonto;
import com.gestaocerta.microgestaohoras.entities.BancoHoras;
import com.gestaocerta.microgestaohoras.repositories.BancoHorasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BancoHorasConsumer {
    private final BancoHorasRepository bancoDeHorasRepository;
    private final BancoHorasService bancoHorasService;

    @RabbitListener(queues = "filaBancoDeHoras")
    public void processarValidacao(ValidacaoPonto pontoValidado) {
        BancoHoras bancoDeHoras = new BancoHoras();
        bancoDeHoras.setEmpregadoId(pontoValidado.getEmpregadoId());
        bancoDeHoras.setPontoEletronicoId(pontoValidado.getPontoEletronicoId());
        bancoDeHoras.setData(pontoValidado.getDataTrabalhada().toLocalDate());
        bancoDeHoras.setSaldo(pontoValidado.getHorasExtras());

        bancoHorasService.save(bancoDeHoras);

        System.out.println("Mensagem processada e banco de horas atualizado.");
    }
}
