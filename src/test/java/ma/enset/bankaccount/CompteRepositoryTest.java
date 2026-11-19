package ma.enset.bankaccount;
import ma.enset.bankaccount.entities.*;
import ma.enset.bankaccount.repositories.CompteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest class CompteRepositoryTest {
 @Autowired CompteRepository repository;
 @Test void saveAndFind(){String id=UUID.randomUUID().toString();repository.save(new Compte(id,LocalDate.now(),new BigDecimal("500.00"),TypeCompte.COURANT));assertThat(repository.findById(id)).isPresent();}
}
