package br.edu.infnet.ms_avaliacao;

import br.edu.infnet.ms_avaliacao.repository.AvaliacaoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AvaliacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AvaliacaoRepository repository;

    @Test
    void deveCadastrarEBuscarAvaliacaoComSucesso() throws Exception {
        String jsonPayload = "{\"restauranteId\":1,\"nota\":5,\"comentario\":\"Comida excelente!\"}";

        mockMvc.perform(post("/avaliacoes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.comentario").value("Comida excelente!"))
                .andExpect(jsonPath("$.nota").value(5));

        mockMvc.perform(get("/avaliacoes/restaurante/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].comentario").value("Comida excelente!"));
    }
}