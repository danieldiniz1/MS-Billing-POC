package br.com.ms.billing.controller.dto;

import br.com.ms.billing.model.Fatura;

public class FaturaPagamentoDTO {

    private String codigo;
    private String valor;
    private String dataefetivacao;

    public FaturaPagamentoDTO() {
    }

    public FaturaPagamentoDTO(String codigo, String valor, String dataefetivacao) {
        this.codigo = codigo;
        this.valor = valor;
        this.dataefetivacao = dataefetivacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getValor() {
        return valor;
    }

    public String getDataefetivacao() {
        return dataefetivacao;
    }

    public static FaturaPagamentoDTO valueOf(Fatura fatura){
        return new FaturaPagamentoDTO(fatura.getCodigo(), fatura.getValorFinal().toString(),fatura.getVencimentoFatura().toString());
    }
}
