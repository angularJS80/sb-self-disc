package com.example.demo.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;

    @PostMapping
    public String createAccount(@RequestBody  Account account){
        this.accountService.createAccount(account);
        return "Ok";
    }

    @GetMapping
    public List<Account> getAccounts(){
        return this.accountRepository.findAll();
    }

}
