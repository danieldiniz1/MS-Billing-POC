package br.com.ms.billing.service.impl;

import br.com.ms.billing.controller.form.FaturaForm;
import br.com.ms.billing.model.Fatura;
import br.com.ms.billing.populator.Populator;
import br.com.ms.billing.repository.FaturaRepository;
import br.com.ms.billing.service.FaturamentoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultFaturamentoService implements FaturamentoService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private FaturaRepository faturaRepository;

    @Autowired
    private Populator<FaturaForm,Fatura> faturaPopulator;


    @Override
    public String processarFatura(FaturaForm form) {
        // tratar infos e popular model
        Fatura fatura = converterToModel(form);

        //salvar infos no mongoDB
        faturaRepository.save(fatura);

        return String.valueOf(fatura.getId());
    }

    private Fatura converterToModel(FaturaForm form) {
        Fatura fatura = Fatura.create();
        faturaPopulator.populate(form,fatura);
        return fatura;
    }
}
