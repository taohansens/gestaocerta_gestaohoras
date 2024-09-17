package com.gestaocerta.microgestaohoras.controller;

import com.gestaocerta.microgestaohoras.entities.BancoHoras;
import com.gestaocerta.microgestaohoras.services.BancoHorasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gestao")
public class GestaoController {
    private final BancoHorasService service;

    @Operation(summary = "Retorna a lista de registros pelo Id do Empregado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a lista de registros pr empregado", content = {@Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = BancoHoras.class)))})})
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<BancoHoras>> findById(
            @Parameter(description = "ID do empregado a ser buscado", required = true)
            @PathVariable Long id) {
        List<BancoHoras> bancoHoras = service.findByEmpregadoId(id);
        return ResponseEntity.ok().body(bancoHoras);
    }
}
