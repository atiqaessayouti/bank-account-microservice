package ma.enset.bankaccount.web;
import ma.enset.bankaccount.dtos.*;
import ma.enset.bankaccount.services.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
@RestController @RequestMapping("/api/comptes") @RequiredArgsConstructor
public class CompteRestController {
 private final CompteService service;
 @GetMapping public List<CompteDTO> all(){return service.findAll();}
 @GetMapping("/{id}") public CompteDTO one(@PathVariable String id){return service.findById(id);}
 @PostMapping public ResponseEntity<CompteDTO> create(@Valid @RequestBody CompteRequest request){CompteDTO dto=service.create(request);return ResponseEntity.created(URI.create("/api/comptes/"+dto.id())).body(dto);}
 @PutMapping("/{id}") public CompteDTO update(@PathVariable String id,@Valid @RequestBody CompteRequest request){return service.update(id,request);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable String id){service.delete(id);}
}
