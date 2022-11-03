package br.com.ms.billing.populator.impl;

import br.com.ms.billing.controller.form.FaturaForm;
import br.com.ms.billing.model.Fatura;
import br.com.ms.billing.populator.Populator;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DeaultFaturaPopulator implements Populator<FaturaForm, Fatura> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void populate(FaturaForm source, Fatura target) {
        validation(source);
        target.setNome(source.getNome());
//        target.setEndereco(Endereco.create());
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

    private void validation(FaturaForm faturaForm) {
        Assert.notNull(faturaForm,"O formulário não pode ser nulo");
        //outras validações de acordo com regras de negócio
    }
}
