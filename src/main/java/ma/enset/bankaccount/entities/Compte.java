package ma.enset.bankaccount.entities;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity @Table(name="comptes")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Compte {
 @Id private String id;
 @Column(nullable=false,updatable=false) private LocalDate dateCreation;
 @Column(nullable=false,precision=19,scale=2) private BigDecimal solde;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private TypeCompte type;
}
