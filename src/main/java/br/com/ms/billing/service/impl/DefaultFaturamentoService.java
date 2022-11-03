package br.com.ms.billing.service.impl;

import br.com.ms.billing.controller.dto.FaturaImpressaoDTO;
import br.com.ms.billing.controller.dto.FaturaPagamentoDTO;
import br.com.ms.billing.controller.form.FaturaForm;
import br.com.ms.billing.exception.ObjectNotFoundException;
import br.com.ms.billing.model.Endereco;
import br.com.ms.billing.model.Fatura;
import br.com.ms.billing.populator.Populator;
import br.com.ms.billing.repository.EnderecoRepository;
import br.com.ms.billing.repository.FaturaRepository;
import br.com.ms.billing.service.FaturamentoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DefaultFaturamentoService implements FaturamentoService {

    private static final Logger LOGGER = LogManager.getLogger();
    @Autowired
    private FaturaRepository faturaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private Populator<FaturaForm,Fatura> faturaPopulator;

    @Override
    public String processarFatura(FaturaForm form) {
        // tratar infos e popular model
        tratamentoEndereco(form);
        Fatura fatura = converterToModel(form);

        //salvar infos no mongoDB
        faturaRepository.save(fatura);
        return String.valueOf(fatura.getId());
    }

    @Override
    public List<FaturaPagamentoDTO> buscarFaturasSalvasParaProcessarPagamento() {
        List<Fatura> faturas = getFaturas();
        List<FaturaPagamentoDTO> faturasDTO = faturas.stream().map(fatura -> FaturaPagamentoDTO.valueOf(fatura)).collect(Collectors.toList());
        faturasDTO.forEach(f -> LOGGER.info(f.getCodigo()));
        return faturasDTO;
    }

    @Override
    public List<FaturaImpressaoDTO> buscarFaturasSalvasParaProcessarImpressao() {
        List<Fatura> faturas = getFaturas();
        List<FaturaImpressaoDTO> faturasDTO = faturas.stream().map(fatura -> FaturaImpressaoDTO.valueOf(fatura)).collect(Collectors.toList());
        faturasDTO.forEach(f -> LOGGER.info(f.getCodigo()));
        return faturasDTO;
    }

    private List<Fatura> getFaturas() {
        List<Fatura> faturas = faturaRepository.findAll();
        if (faturas.isEmpty()){
            throw new ObjectNotFoundException("Não existem faturas disponíveis para processar pagamento");
        }
        return faturas;
    }

    private void tratamentoEndereco(FaturaForm form) {
        Endereco endereco = enderecoRepository.save(Endereco.create(form.getEndereco()));
        form.getEndereco().setId(endereco.getId());
    }

    private Fatura converterToModel(FaturaForm form) {
        Fatura fatura = Fatura.create();
        faturaPopulator.populate(form,fatura);
        return fatura;
    }
}
