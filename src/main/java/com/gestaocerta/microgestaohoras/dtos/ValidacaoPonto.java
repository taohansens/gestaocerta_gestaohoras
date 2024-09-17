package com.gestaocerta.microgestaohoras.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ValidacaoPonto {
    private Long id;
    private Long pontoEletronicoId;
    private Long empregadoId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataValidacao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataTrabalhada;
    private String comentario;

    private String codigoSituacao;

    private Double horasTrabalhadas;
    private Double horasExtras;
}
