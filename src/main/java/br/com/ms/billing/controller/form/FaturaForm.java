package br.com.ms.billing.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class FaturaForm {

    @NotBlank(message = "Nome não pode ser em branco")
    private String nome;
    @NotNull
    private EnderecoForm endereco;
    @NotBlank(message = "Código não pode ser em branco")
    private String codigo;
    @NotBlank(message = "Data não pode ser em branco")
    @Pattern(regexp = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)")
    private String dataFatura;
    @NotBlank(message = "Data não pode ser em branco")
    @Pattern(regexp = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)")
    private String vencimentoFatura;
    @NotBlank(message = "Valor não pode ser em branco")

    private String valorFatura;
    private String descontoFatura;
    @NotBlank(message = "Data não pode ser em branco")
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
