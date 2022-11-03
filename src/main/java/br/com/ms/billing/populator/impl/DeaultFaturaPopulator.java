package br.com.ms.billing.populator.impl;

import br.com.ms.billing.controller.form.EnderecoForm;
import br.com.ms.billing.controller.form.FaturaForm;
import br.com.ms.billing.exception.ObjectNotFoundException;
import br.com.ms.billing.model.Endereco;
import br.com.ms.billing.model.Fatura;
import br.com.ms.billing.populator.Populator;
import br.com.ms.billing.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DeaultFaturaPopulator implements Populator<FaturaForm, Fatura> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public void populate(FaturaForm source, Fatura target) {
        validation(source);
        target.setNome(source.getNome());
        target.setEndereco(salvarEndereco(source.getEndereco()));
        target.setCodigo(source.getCodigo());
        target.setDataFatura(LocalDate.parse(source.getDataFatura(),formatter));
        target.setVencimentoFatura(LocalDate.parse(source.getVencimentoFatura(),formatter));
        target.setValorFatura(BigDecimal.valueOf(Double.valueOf(source.getValorFatura())));
        target.setDescontoFatura(source.getDescontoFatura().isBlank() ? BigDecimal.ZERO : BigDecimal.valueOf(Double.valueOf(source.getDescontoFatura())));
        target.setServiçosFatura(source.getServiçosFatura());
        target.setValorFinal(
                BigDecimal.valueOf(Double.valueOf(source.getValorFatura()))
                        .subtract(source.getDescontoFatura().isBlank() ? BigDecimal.ZERO : BigDecimal.valueOf(Double.valueOf(source.getDescontoFatura()))));

    }

    private Endereco salvarEndereco(EnderecoForm form) {
//        return enderecoRepository.findByCep(endereco.getCep());
        //adicionar o cliente como referencia
        return enderecoRepository.findById(form.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado endereço com o id informado: " + form.getId()));
    }

    private void validation(FaturaForm faturaForm) {
        Assert.notNull(faturaForm,"O formulário não pode ser nulo");
        //outras validações de acordo com regras de negócio
    }
}
