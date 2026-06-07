package com.client.api;

import com.client.api.account.Account;
import com.client.api.account.AccountRepository;
import com.client.api.account.AccountService;
import com.client.api.account.Currency;
import com.client.api.dolar.Dolar;
import com.client.api.dolar.DolarClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private DolarClient dolarClient;

    @InjectMocks
    private AccountService accountService;

    @Test
    void deberiaPesificarCuentaEnDolares() {

        Account cuenta = new Account();
        cuenta.setMoneda(Currency.USD);
        cuenta.setSaldo(BigDecimal.valueOf(100));

        when(accountRepository.findAll())
                .thenReturn(List.of(cuenta));

        when(dolarClient.getDolar())
                .thenReturn(
                        new Dolar(
                                "USD",
                                "blue",
                                "Blue",
                                1000.0,
                                1010.0,
                                LocalDate.now()
                        )
                );

        List<Account> resultado = accountService.obtenerCuentasPesificadas();

        assertEquals(
                BigDecimal.valueOf(100000.0),
                resultado.get(0).getSaldo()
        );

        assertEquals(
                Currency.ARS,
                resultado.get(0).getMoneda()
        );
    }

    @Test
    void noDeberiaPesificarCuentaEnPesos() {

        Account cuenta = new Account();
        cuenta.setMoneda(Currency.ARS);
        cuenta.setSaldo(BigDecimal.valueOf(50000));

        when(accountRepository.findAll())
                .thenReturn(List.of(cuenta));

        Dolar dolar = new Dolar();
        dolar.setCompra(1415.0);

        when(dolarClient.getDolar())
                .thenReturn(dolar);

        List<Account> resultado = accountService.obtenerCuentasPesificadas();

        assertEquals(
                BigDecimal.valueOf(50000),
                resultado.get(0).getSaldo()
        );

        assertEquals(
                Currency.ARS,
                resultado.get(0).getMoneda()
        );
    }
}