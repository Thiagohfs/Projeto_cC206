import java.sql.SQLException;
import java.util.ArrayList;

public class JogoDAO extends ConnectionDAO {
    boolean aprovado = false;

    //DAO -DATA ACCESS OBJECT
    public boolean inserirJogo(Jogo jogo) {
        connectToDB();
        String sql = "INSERT INTO jogo (nome, genero,disponivel, codigo) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, jogo.getNome());
            pst.setString(2, jogo.getGenero());
            pst.setBoolean(3, jogo.isDisponivel());
            pst.setInt(4, jogo.getCodigo());

            pst.execute();
            aprovado = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            aprovado = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        return aprovado;
    }
    public boolean atualizarJogo(int id,boolean alug) {
        connectToDB();
        String sql = "UPDATE filme SET disponivel=? where codigo=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setBoolean(1, alug);
            pst.setInt(2, id);
            pst.execute();
            aprovado = true;

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            aprovado = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return aprovado;
    }
    public ArrayList<Jogo> buscaJogos() {
        ArrayList<Jogo> listaJogos = new ArrayList<>();

        connectToDB();

        String sql = "SELECT * FROM jogo";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Jogo jogoAux = new Jogo();
                jogoAux.setNome(rs.getString("nome"));
                jogoAux.setGenero(rs.getString("genero"));
                jogoAux.setCodigo(rs.getInt("codigo"));
                jogoAux.setDisponivel((rs.getBoolean("disponivel")));

                    listaJogos.add(jogoAux);
            }
            aprovado = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            aprovado = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return listaJogos;
    }



}
