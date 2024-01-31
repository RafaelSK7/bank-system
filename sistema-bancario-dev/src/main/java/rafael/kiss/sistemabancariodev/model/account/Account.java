package rafael.kiss.sistemabancariodev.model.account;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import rafael.kiss.sistemabancariodev.model.account.enums.AccountStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@Document(collection = "accounts")
@NoArgsConstructor
public class Account {


    @Id
    private String id;
    private Long accountNumber;
    private BigDecimal balance;
    private String accountHolder;
    private String password;
    private LocalDateTime openingDate;
    // List<Transaction> transactions
    private AccountStatus accountStatus;


    public Account(AccountDTO accountDTO) {
        this.balance = BigDecimal.ZERO;
        this.accountHolder = accountDTO.accountHolder();
        this.openingDate = LocalDateTime.now();
        this.password = encryptPassword(accountDTO.password());
        this.accountStatus = AccountStatus.ACTIVE;
    }

    public String encryptPassword(String rawPassword){
        return new BCryptPasswordEncoder().encode(rawPassword);
    }
}