package br.com.ms.billing.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BillingController {

    private static final Logger LOGGER = LogManager.getLogger();

    @GetMapping
    public ResponseEntity testGetBilling(){
        LOGGER.info("Autorização via oauth2 funcionou");
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }
}
