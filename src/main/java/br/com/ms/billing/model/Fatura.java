package br.com.ms.billing.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Document()
public class Fatura {

    @Id
    private String id;
    private String nome;
    private Endereco endereco;
    private String codigo;
    private LocalDate dataFatura;
    private LocalDate vencimentoFatura;
    private BigDecimal valorFatura;
    private BigDecimal descontoFatura;
    private BigDecimal valorTotal;
    private String serviçosFatura;

    public Fatura() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataFatura() {
        return dataFatura;
    }

    public void setDataFatura(LocalDate dataFatura) {
        this.dataFatura = dataFatura;
    }

    public LocalDate getVencimentoFatura() {
        return vencimentoFatura;
    }

    public void setVencimentoFatura(LocalDate vencimentoFatura) {
        this.vencimentoFatura = vencimentoFatura;
    }

    public BigDecimal getValorFatura() {
        return valorFatura;
    }

    public void setValorFatura(BigDecimal valorFatura) {
        this.valorFatura = valorFatura;
    }

    public BigDecimal getDescontoFatura() {
        return descontoFatura;
    }

    public void setDescontoFatura(BigDecimal descontoFatura) {
        this.descontoFatura = descontoFatura;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getServiçosFatura() {
        return serviçosFatura;
    }

    public void setServiçosFatura(String serviçosFatura) {
        this.serviçosFatura = serviçosFatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fatura fatura = (Fatura) o;
        return id.equals(fatura.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static Fatura create(){
        return new Fatura();
    }
}
