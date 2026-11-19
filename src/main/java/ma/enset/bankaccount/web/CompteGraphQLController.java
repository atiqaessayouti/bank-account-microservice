package ma.enset.bankaccount.web;
import ma.enset.bankaccount.dtos.*;
import ma.enset.bankaccount.entities.TypeCompte;
import ma.enset.bankaccount.services.CompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import java.math.BigDecimal;
import java.util.List;
@Controller @RequiredArgsConstructor
public class CompteGraphQLController {
 private final CompteService service;
 @QueryMapping public List<CompteDTO> allComptes(){return service.findAll();}
 @QueryMapping public CompteDTO compteById(@Argument String id){return service.findById(id);}
 @MutationMapping public CompteDTO addCompte(@Argument CompteInput compte){return service.create(new CompteRequest(BigDecimal.valueOf(compte.solde()),compte.type()));}
 @MutationMapping public CompteDTO updateCompte(@Argument String id,@Argument CompteInput compte){return service.update(id,new CompteRequest(BigDecimal.valueOf(compte.solde()),compte.type()));}
 @MutationMapping public boolean deleteCompte(@Argument String id){service.delete(id);return true;}
 public record CompteInput(double solde,TypeCompte type) {}
}
