package br.com.ms.billing.service;

import br.com.ms.billing.controller.dto.FaturaPagamentoDTO;
import br.com.ms.billing.controller.form.FaturaForm;

import java.util.List;

public interface FaturamentoService {
    String processarFatura(FaturaForm form);

    List<FaturaPagamentoDTO> buscarFaturasSalvasParaProcessarPagamento();
}
