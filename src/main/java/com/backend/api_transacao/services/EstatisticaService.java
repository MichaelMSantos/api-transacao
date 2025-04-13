package com.backend.api_transacao.services;

import com.backend.api_transacao.controller.dtos.EstatisticaResponseDTO;
import com.backend.api_transacao.controller.dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticaService {
    public final TransacaoService transacaoService;

    public EstatisticaResponseDTO calcEstatisticas(Integer intervalo){
        log.info("Iniciando a busca de estatisticas dos ultimos " + intervalo + " segundos");

        long start = System.currentTimeMillis();

        List<TransacaoRequestDTO> transactions = transacaoService.getTransactions(intervalo);

        if (transactions.isEmpty()) {
            return new EstatisticaResponseDTO(0L, .0, .0, .0, .0);
        }

        DoubleSummaryStatistics estatisticas = transactions
                .stream().mapToDouble(TransacaoRequestDTO::valor)
                .summaryStatistics();

        long finish = System.currentTimeMillis();
        long tempoExecucao = finish - start;

        System.out.println("Tempo de requisição: " + tempoExecucao + "ms");
        log.info("Estatisticas retornadas com sucesso!");

        return new EstatisticaResponseDTO(
                estatisticas.getCount(),
                estatisticas.getSum(),
                estatisticas.getAverage(),
                estatisticas.getMin(),
                estatisticas.getMax());
    }
}
