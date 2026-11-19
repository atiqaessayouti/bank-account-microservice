package ma.enset.bankaccount.services;
import ma.enset.bankaccount.dtos.*;
import java.util.List;
public interface CompteService {
 List<CompteDTO> findAll(); CompteDTO findById(String id);
 CompteDTO create(CompteRequest request); CompteDTO update(String id,CompteRequest request);
 void delete(String id);
}
