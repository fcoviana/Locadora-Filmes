package tests;

import dao.FilmeDao;
import java.sql.SQLException;
import model.Filme;
import utils.Mensagens;

public class TesteInserirFilme {
    
    public static void main(String[] args) {
        Filme filme = new Filme("Deus não estar morto", "Religioso", "Melhor filme religioso de 2015", 1, 5, 25.5);
        FilmeDao dao = new FilmeDao();
        
        try {
            dao.inserir(filme);
            Mensagens.mensagemAviso("Inserido com sucesso!");
        } catch (SQLException e) {
            Mensagens.mensagemErro(e.getMessage());
        }
    }
    
}
