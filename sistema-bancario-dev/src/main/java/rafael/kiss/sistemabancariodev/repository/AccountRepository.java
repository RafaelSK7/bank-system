package rafael.kiss.sistemabancariodev.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import rafael.kiss.sistemabancariodev.model.account.Account;

public interface AccountRepository extends MongoRepository<Account, String> {
}