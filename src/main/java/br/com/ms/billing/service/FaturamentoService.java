package br.com.ms.billing.service;

import br.com.ms.billing.controller.form.FaturaForm;

public interface FaturamentoService {
    String processarFatura(FaturaForm form);
}
