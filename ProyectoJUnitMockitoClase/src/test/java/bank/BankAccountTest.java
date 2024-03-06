package bank;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    BankAccount bankAccount;

    //Creamos la cuenta del banco con un saldo inicial de 100
    @BeforeEach
    void setup() { bankAccount = new BankAccount(100) ;}

    @Test
    @DisplayName("Se retira dinero de la cuenta correctamente")
    void RetirarDineroDelBanco() {
        assertTrue(bankAccount.withdraw(50));
    }

    @Test
    @DisplayName("No se saca dinero de la cuenta si no hay suficiente")
    void RetirarDineroDelBancoInsuficiente() {
        assertFalse(bankAccount.withdraw(150));
    }

    @Test
    @DisplayName("Se desposita correctamente el dinero en la cuenta")
    void DepositarDineroEnLaCuenta() {
        int valorEsperado = 150;

        int valorDepositado = bankAccount.deposit(50);

        assertEquals(valorEsperado, valorDepositado);
    }

    @Test
    @DisplayName("El valor introducido para depositar dinero en la cuenta no puede ser negativo")
    void DepositarDineroNegativo() {
        assertThrows(IllegalArgumentException.class, ()-> bankAccount.deposit(-50));
    }

    @Test
    @DisplayName("Devuelve el dinero de la cuenta correctamente")
    void ObtenerElDineroTotal() {
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Calcula correctamente el pago por mes de un préstamo")
    void CalcularPagoPorMes() {
        double total_amount =10000;
        double interes = 0.001;
        int months = 12;
        double valorEsperado = 838.7599255697181;

        double valorAPagar = bankAccount.payment(total_amount, interes, months);

        assertEquals(valorEsperado, valorAPagar);
    }

    @Test
    @DisplayName("Calcula correctamente el importe pendiente de un prestamo de un mes")
    void CalcularImportePendiente() {
        double total_amount =10000;
        double interes = 0.001;
        int months = 12;
        double valorEsperado = 8341.651388934994;

        double valorPendiente= bankAccount.pending(total_amount, interes, months, 2);

        assertEquals(valorEsperado, valorPendiente);
    }

}
