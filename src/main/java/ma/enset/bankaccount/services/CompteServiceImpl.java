package ma.enset.bankaccount.services;
import ma.enset.bankaccount.entities.*;
import ma.enset.bankaccount.repositories.*;
import ma.enset.bankaccount.dtos.*;
import ma.enset.bankaccount.mappers.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.time.LocalDate;
import java.util.*;
@Service @RequiredArgsConstructor @Transactional
public class CompteServiceImpl implements CompteService {
 private final CompteRepository repository; private final CompteMapper mapper;
 @Transactional(readOnly=true) public List<CompteDTO> findAll(){return repository.findAll().stream().map(mapper::toDto).toList();}
 @Transactional(readOnly=true) public CompteDTO findById(String id){return mapper.toDto(required(id));}
 private Compte required(String id){return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Compte introuvable"));}
 public CompteDTO create(CompteRequest request){Compte c=new Compte(UUID.randomUUID().toString(),LocalDate.now(),request.solde(),request.type());return mapper.toDto(repository.save(c));}
 public CompteDTO update(String id,CompteRequest request){Compte c=required(id);c.setSolde(request.solde());c.setType(request.type());return mapper.toDto(repository.save(c));}
 public void delete(String id){repository.delete(required(id));}
}
