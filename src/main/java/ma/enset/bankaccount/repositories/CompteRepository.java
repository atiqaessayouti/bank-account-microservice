package ma.enset.bankaccount.repositories;
import ma.enset.bankaccount.entities.Compte;
import ma.enset.bankaccount.projections.CompteProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource(path="comptes",excerptProjection=CompteProjection.class)
public interface CompteRepository extends JpaRepository<Compte,String> {}
