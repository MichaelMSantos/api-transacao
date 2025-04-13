package com.backend.api_transacao.controller.dtos;

public record EstatisticaResponseDTO(
        Long count,
        Double sum,
        Double avg,
        Double min,
        Double max
) {};
