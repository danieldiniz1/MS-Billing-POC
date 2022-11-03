package br.com.ms.billing.controller;

import br.com.ms.billing.controller.dto.FaturaImpressaoDTO;
import br.com.ms.billing.controller.dto.FaturaPagamentoDTO;
import br.com.ms.billing.controller.form.FaturaForm;
import br.com.ms.billing.service.FaturamentoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/faturamento")
public class FaturamentoController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private FaturamentoService faturamentoService;

    @PostMapping
    public ResponseEntity faturarCliente(@RequestBody @Valid FaturaForm form){
        LOGGER.info("Inicio do processo de faturamento");
        String id = faturamentoService.processarFatura(form);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        LOGGER.info("Fim do processo de faturamento");
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/pagamento") // Endpoint para busca das faturas para iniciar procesos de envio aos banco para pagamento.
    public ResponseEntity<List<FaturaPagamentoDTO>> buscarTodasFaturasSalvasParaPagamento(){
        return ResponseEntity.status(HttpStatus.OK).body(faturamentoService.buscarFaturasSalvasParaProcessarPagamento());
    }

    @GetMapping("/impressao") // Endpoint para busca das faturas para iniciar procesos de envio ao serviço de impressão.
    public ResponseEntity<List<FaturaImpressaoDTO>> buscarTodasFaturasSalvasParaImpressao() {
        return ResponseEntity.status(HttpStatus.OK).body(faturamentoService.buscarFaturasSalvasParaProcessarImpressao());
    }
}
