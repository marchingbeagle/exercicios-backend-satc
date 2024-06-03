import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping()
public class PayPalController {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    AccountRepository accountRepository;


    @PostMapping("/payments")
    public ResponseEntity<?> createPayment(@RequestBody Payment payment) {
        try {
            if (payment == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados ausentes no request.");
            }

            if (payment.recipient == null || payment.amount == null || payment.currency == null || payment.paymentMethod == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos obrigatórios ausentes.");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(payment);

        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatus()).body(null);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/payments/{id}")
    public ResponseEntity<?> getPayment(@PathVariable Long id) {
        try {
            // Valida se o ID é nulo ou inválido
            if (id == null || id < 1) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido.");
            }

            Payment payment = paymentRepository.findById(id);

            if (payment != null) {
                return ResponseEntity.status(HttpStatus.OK).body(payment);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado.");
            }
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getReason());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor.");
        }
    }

    @PostMapping("/accounts")
    public ResponseEntity<?> createAccount(@RequestBody UserAccount userAccount) {
        try {
            if (userAccount == null || userAccount.email == null || userAccount.password == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos obrigatórios ausentes.");
            }

            if (accountRepository.findByEmail(userAccount.email)) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Conta já existente com este email.");
            }

            accountRepository.save(userAccount);

            return ResponseEntity.status(HttpStatus.CREATED).body(userAccount);

        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getReason());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor.");
        }
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<?> getUserAccount(@PathVariable Long id) {
        try {
            UserAccount userAccount = accountRepository.findById(id);

            if (id == null || id < 1) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido.");
            }

            if (userAccount != null) {
                return ResponseEntity.status(HttpStatus.OK).body(userAccount);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada.");
            }
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getReason());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor.");
        }
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<?> updateUserAccount(@PathVariable Long id, @RequestBody UserAccount updatedAccount) {
        try {
            if (id == null || id < 1) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido.");
            }

            if (updatedAccount == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados para atualização ausentes.");
            }

            UserAccount existingAccount = accountRepository.findById(id);

            if (existingAccount != null) {
                existingAccount.name = updatedAccount.name;
                existingAccount.phone = updatedAccount.phone;
                return ResponseEntity.status(HttpStatus.OK).body(existingAccount);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada.");
            }
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getReason());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor.");
        }
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<Void> deleteUserAccount(@PathVariable Long id) {
        try {
            if (id == null || id < 1) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido.");
            }

            UserAccount userAccount = accountRepository.findById(id);

            if (userAccount != null) {
                accountRepository.removeById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada.");
            }
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatus()).body(null);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
