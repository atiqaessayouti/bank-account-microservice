package ma.enset.bankaccount;
import ma.enset.bankaccount.entities.*;
import ma.enset.bankaccount.repositories.CompteRepository;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
@SpringBootApplication
public class BankAccountApplication {
 public static void main(String[] args){SpringApplication.run(BankAccountApplication.class,args);}
 @Bean CommandLineRunner demo(CompteRepository repo){return args->{
  repo.save(new Compte(UUID.randomUUID().toString(),LocalDate.now(),new BigDecimal("15000.00"),TypeCompte.COURANT));
  repo.save(new Compte(UUID.randomUUID().toString(),LocalDate.now(),new BigDecimal("25000.00"),TypeCompte.EPARGNE));
  repo.findAll().forEach(System.out::println);
 };}
}
