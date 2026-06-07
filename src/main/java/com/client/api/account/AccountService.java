package com.client.api.account;

import com.client.api.account.Account;
import com.client.api.dolar.Dolar;
import com.client.api.dolar.DolarClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private DolarClient dolarClient;

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Account addAccount(Account addedAccount) {
        return accountRepository.save(addedAccount);
    }

    public Account getAccountsById(Long id) {
        return accountRepository.getReferenceById(id);
    }

//    public void deleteById(Long id) {
//        accountRepository.deleteById(id);
//    }

    public void deleteById(Long id) {

        try {

            Account account = accountRepository.findById(id)
                    .orElseThrow(() -> new AccountNotFoundException(id));

            accountRepository.delete(account);

        } catch (AccountNotFoundException e) {

            System.out.println("Cuenta no encontrada con id: " + id);

            throw e;
        }
    }


    public Account updateAccount(Long id, Account updatedAccount) {

        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));

        //existingAccount.setAccountId(updatedAccount.getAccountId());
        existingAccount.setActivo(updatedAccount.getActivo());
        existingAccount.setFechaCreacion(updatedAccount.getFechaCreacion());
        existingAccount.setFechaModificacion(updatedAccount.getFechaModificacion());
        existingAccount.setMoneda(updatedAccount.getMoneda());
        existingAccount.setNumeroCuenta(updatedAccount.getNumeroCuenta());
        existingAccount.setSaldo(updatedAccount.getSaldo());
        existingAccount.setClientId(updatedAccount.getClientId());

        return accountRepository.save(existingAccount);
    }

    public Dolar getCotizacion() {
        return dolarClient.getDolar();
    }

    public Double getCotizacionCompra() {
        return getCotizacion().getCompra();
    }

    //mio
    public List<Account> obtenerCuentasPesificadas() {

        Double cotizacion = getCotizacionCompra();

        List<Account> cuentas = accountRepository.findAll();

        for (Account cuenta : cuentas) {

            if (Currency.USD.equals(cuenta.getMoneda())) {

                cuenta.setSaldo(
                        cuenta.getSaldo()
                                .multiply(BigDecimal.valueOf(cotizacion))
                );

                cuenta.setMoneda(Currency.ARS);
            }
        }

        return cuentas;
    }

}