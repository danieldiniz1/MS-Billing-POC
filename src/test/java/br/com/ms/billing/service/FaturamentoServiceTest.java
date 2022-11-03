package br.com.ms.billing.service;

import br.com.ms.billing.controller.form.EnderecoForm;
import br.com.ms.billing.controller.form.FaturaForm;
import br.com.ms.billing.exception.ObjectNotFoundException;
import br.com.ms.billing.repository.EnderecoRepository;
import br.com.ms.billing.repository.FaturaRepository;
import br.com.ms.billing.service.impl.DefaultFaturamentoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


@ExtendWith(MockitoExtension.class)
public class FaturamentoServiceTest {

    @InjectMocks
    private DefaultFaturamentoService faturamentoService;

    @Mock
    private FaturaRepository faturaRepository;

    @Mock
    private EnderecoRepository enderecoRepository;

    private FaturaForm faturaFormVazia;
    private FaturaForm faturaFormCompleta;

    @BeforeEach
    public void setup(){
        faturaFormCompleta = new FaturaForm();
        faturaFormVazia = new FaturaForm();
        populateFaturaForm(faturaFormCompleta);

    }

    @Test
    public void deveProcessarAChamadaParaImpressaoSemLancarErro(){
        // como estamos validando prcesso e não conectados com mongodb, deve retornar erro de não existir objetos.
        Assertions.assertThrows(ObjectNotFoundException.class,() -> faturamentoService.buscarFaturasSalvasParaProcessarPagamento());
        Assertions.assertThrows(ObjectNotFoundException.class,() -> faturamentoService.buscarFaturasSalvasParaProcessarPagamento());
    }

    @Test
    public void deveDevolverUmaExceptionCasoOFormEstejaNuloOuEmBranco(){
        Assertions.assertThrows(Exception.class, () ->faturamentoService.processarFatura(null));
        Assertions.assertThrows(Exception.class, () ->faturamentoService.processarFatura(faturaFormVazia));
    }

    private void populateFaturaForm(FaturaForm faturaForm) {
        faturaForm.setNome("nome de Teste");
        faturaForm.setCodigo("XYZ659874");
        faturaForm.setDataFatura("03/11/2022");
        faturaForm.setVencimentoFatura("03/11/2022");
        faturaForm.setValorFatura("100.90");
        faturaForm.setDescontoFatura("10.9");
        faturaForm.setEndereco(populateEnderecoForm());
    }

    private EnderecoForm populateEnderecoForm() {
        EnderecoForm enderecoForm = new EnderecoForm();
        enderecoForm.setId("");
        enderecoForm.setLogradouro("Rua de teste");
        enderecoForm.setComplemento("Complemento de Endereço");
        enderecoForm.setCep("12345698");
        enderecoForm.setCidade("Cidade de Teste");
        enderecoForm.setEstado("Estado de Teste");
        enderecoForm.setNumero("100");
        return enderecoForm;
    }
}
