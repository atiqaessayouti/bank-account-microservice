package ma.enset.bankaccount.dtos;
import ma.enset.bankaccount.entities.TypeCompte;
import java.math.BigDecimal;
import java.time.LocalDate;
public record CompteDTO(String id,LocalDate dateCreation,BigDecimal solde,TypeCompte type) {}
