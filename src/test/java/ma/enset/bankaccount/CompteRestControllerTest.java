package ma.enset.bankaccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest @AutoConfigureMockMvc class CompteRestControllerTest {
 @Autowired MockMvc mvc;
 @Test void listAccounts() throws Exception {mvc.perform(get("/api/comptes")).andExpect(status().isOk()).andExpect(jsonPath("$[0].id").exists());}
 @Test void createAccount() throws Exception {mvc.perform(post("/api/comptes").contentType(MediaType.APPLICATION_JSON).content("{\"solde\":1250.50,\"type\":\"COURANT\"}")).andExpect(status().isCreated()).andExpect(jsonPath("$.id").exists());}
}
