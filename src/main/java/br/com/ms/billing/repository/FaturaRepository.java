package br.com.ms.billing.repository;

import br.com.ms.billing.model.Fatura;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaturaRepository extends MongoRepository<Fatura,String> {
}
