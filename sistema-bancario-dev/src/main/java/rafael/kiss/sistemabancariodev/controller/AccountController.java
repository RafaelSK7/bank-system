package rafael.kiss.sistemabancariodev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rafael.kiss.sistemabancariodev.model.account.Account;
import rafael.kiss.sistemabancariodev.model.account.AccountDTO;
import rafael.kiss.sistemabancariodev.service.AccountService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody AccountDTO accountDTO){
        Account newAccount = this.service.createAccount(accountDTO);
        return ResponseEntity.ok().body(newAccount);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAll(){
        List<Account> categories = this.service.getAll();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Account>> findById(@PathVariable("id") String id){
        Optional<Account> newAccount = this.service.getById(id);
        return ResponseEntity.ok().body(newAccount);
    }

}
