package ma.enset.bankaccount.dtos;
import jakarta.validation.constraints.*;
import ma.enset.bankaccount.entities.TypeCompte;
import java.math.BigDecimal;
public record CompteRequest(@NotNull @DecimalMin("0.00") BigDecimal solde,@NotNull TypeCompte type) {}
