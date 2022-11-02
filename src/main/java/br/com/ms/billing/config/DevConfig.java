package br.com.ms.billing.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private DataBaseService dataBaseService;

    @Value("${initiatedatabase}")
    private String strategyDB;

    public Boolean instantiateDatabase(){
        if (!strategyDB.equals("true")){
            LOGGER.info("Banco de dados já está criado e populado");
            return Boolean.FALSE;
        }
        dataBaseService.instantiateBasicDatabase();
        LOGGER.info("O Banco de dados foi populado com sucesso!");
        return Boolean.TRUE;
    }
}
