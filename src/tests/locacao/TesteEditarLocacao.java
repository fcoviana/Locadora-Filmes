package tests.locacao;

import dao.ClienteDao;
import dao.FilmeDao;
import dao.LocacaoDao;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import model.Cliente;
import model.Filme;
import model.Locacao;
import utils.Convert;
import utils.Mensagens;

public class TesteEditarLocacao {

    public static void main(String[] args) throws ParseException {

        FilmeDao daoF = new FilmeDao();
        ClienteDao daoC = new ClienteDao();
        LocacaoDao daoL = new LocacaoDao();

        try {
            List<Cliente> listaC = daoC.listar();
            List<Filme> listaF = daoF.listar();
            List<Locacao> listaL = daoL.listar();

            Filme f = listaF.get(1);
            Cliente c = listaC.get(1);
            Locacao lo =  listaL.get(0);

            lo.setCliente(c);
            lo.setFilme(f);
            lo.setDataLocacao(Convert.convertBySQL("20/04/2019"));
            lo.setDataDevolucao(Convert.convertBySQL("20/06/2019"));
            lo.setStatus("Devolvido");
            daoL.editar(lo);

            Mensagens.mensagemConfirmacao("Atualizado");

        } catch (SQLException e) {
            Mensagens.mensagemErro(e.getMessage());
        }

    }

}
