package com.client.api.account;

import com.client.api.dolar.Dolar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/agregar")
    public Account addAccount(@RequestBody Account addedAccount) {
        return accountService.addAccount(addedAccount);
    }

//    @GetMapping("/{id}")
//    public Account getAccountsById(@PathVariable Long id) {
//        return accountService.getAccountsById(id);
//    }

    @GetMapping("/{id}")
    public Account getAccountsById(@PathVariable Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    @GetMapping
    public List<Account> getAccount() {
        return accountService.getAccounts();
    }

    @DeleteMapping("/{id}")
    public void deleteAccountById(@PathVariable Long id) {
        accountService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody Account updatedAccount) {
        return accountService.updateAccount(id, updatedAccount);
    }

    @GetMapping("/cotizacion")
    public Dolar getCotizacion() {
        return accountService.getCotizacion();
    }

    //mio
    @GetMapping("/cotizacion/compra")
    public Double getCotizacionCompra() {
        Dolar dolar = accountService.getCotizacion();

        return dolar.getCompra();
    }

    @GetMapping("/pesificadas")
    public List<Account> obtenerCuentasPesificadas() {
        return accountService.obtenerCuentasPesificadas();
    }

}