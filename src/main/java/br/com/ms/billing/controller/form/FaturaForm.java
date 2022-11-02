package br.com.ms.billing.controller.form;

public class FaturaForm {

    private String nome;
    private EnderecoForm endereco;
    private String codigo;
    private String dataFatura;
    private String vencimentoFatura;
    private String valorFatura;
    private String descontoFatura;
    private String serviçosFatura;

    public FaturaForm() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnderecoForm getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoForm endereco) {
        this.endereco = endereco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDataFatura() {
        return dataFatura;
    }

    public void setDataFatura(String dataFatura) {
        this.dataFatura = dataFatura;
    }

    public String getVencimentoFatura() {
        return vencimentoFatura;
    }

    public void setVencimentoFatura(String vencimentoFatura) {
        this.vencimentoFatura = vencimentoFatura;
    }

    public String getValorFatura() {
        return valorFatura;
    }

    public void setValorFatura(String valorFatura) {
        this.valorFatura = valorFatura;
    }

    public String getDescontoFatura() {
        return descontoFatura;
    }

    public void setDescontoFatura(String descontoFatura) {
        this.descontoFatura = descontoFatura;
    }

    public String getServiçosFatura() {
        return serviçosFatura;
    }

    public void setServiçosFatura(String serviçosFatura) {
        this.serviçosFatura = serviçosFatura;
    }
}
