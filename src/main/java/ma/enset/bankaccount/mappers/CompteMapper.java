package ma.enset.bankaccount.mappers;
import ma.enset.bankaccount.entities.*;
import ma.enset.bankaccount.dtos.*;
import org.springframework.stereotype.Component;
@Component public class CompteMapper {
 public CompteDTO toDto(Compte c){return new CompteDTO(c.getId(),c.getDateCreation(),c.getSolde(),c.getType());}
}
