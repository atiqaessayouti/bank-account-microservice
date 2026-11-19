package ma.enset.bankaccount.projections;
import ma.enset.bankaccount.entities.*;
import org.springframework.data.rest.core.config.Projection;
import java.math.BigDecimal;
@Projection(name="solde",types=Compte.class)
public interface CompteProjection {String getId(); BigDecimal getSolde(); TypeCompte getType();}
