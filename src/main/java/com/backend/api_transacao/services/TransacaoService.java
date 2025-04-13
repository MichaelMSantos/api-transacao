package com.backend.api_transacao.services;

import com.backend.api_transacao.controller.dtos.TransacaoRequestDTO;
import com.backend.api_transacao.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {
    private final List<TransacaoRequestDTO> listTransactions = new ArrayList<>();

    public void addTransactions(TransacaoRequestDTO dto) {
        log.info("Salvando a transação: {dto}");
        if (dto.dataHora().isAfter(OffsetDateTime.now())) {

            log.error("A data e hora inseridas são maiores que as atuais.");
            throw new UnprocessableEntity("A data e hora inseridas são maiores que as atuais.");
        }

        if (dto.valor() < 0) {
            log.error("O valor não pode ser negativo.");
            throw new UnprocessableEntity("O valor não pode ser negativo.");
        }
        listTransactions.add(dto);
        log.info("Transação adicionada com sucesso!");
    }

    public void deleteTransactions(){
        log.info("Executando serviço para deletar as transações...");
        listTransactions.clear();
        log.info("Transações deletadas com sucesso!");
    }

    public List<TransacaoRequestDTO> getTransactions(Integer intervalo){
        log.info("Iniciada a busca de transações");
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervalo);

        return listTransactions.stream()
                .filter(transaction -> transaction.dataHora()
                        .isAfter(dataHoraIntervalo)).toList();
    }
}
