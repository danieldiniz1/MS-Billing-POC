package br.com.ms.billing.controller.dto;

import br.com.ms.billing.model.Fatura;

public class FaturaImpressaoDTO {

    private String nome;
    private String valorFatura;
    private String desconto;
    private String valorFinal;
    private String servicos;
    private String codigo;

    public FaturaImpressaoDTO() {
    }

    public FaturaImpressaoDTO(String nome, String totalFatura, String desconto, String totalPagamento, String servicos, String codigo) {
        this.nome = nome;
        this.valorFatura = totalFatura;
        this.desconto = desconto;
        this.valorFinal = totalPagamento;
        this.servicos = servicos;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getValorFatura() {
        return valorFatura;
    }

    public String getDesconto() {
        return desconto;
    }

    public String getValorFinal() {
        return valorFinal;
    }

    public String getServicos() {
        return servicos;
    }

    public String getCodigo() {
        return codigo;
    }

    public static FaturaImpressaoDTO valueOf(Fatura fatura){
        return new FaturaImpressaoDTO(fatura.getNome(),
                fatura.getValorFatura().toString(),
                fatura.getDescontoFatura().toString(),
                fatura.getValorFinal().toString(),
                fatura.getServiçosFatura(),
                fatura.getCodigo());
    }
}
