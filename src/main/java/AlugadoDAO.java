import java.sql.SQLException;

public class AlugadoDAO extends  ConnectionDAO {

        boolean aprovado = false;
        JogoDAO jogoDA01 = new JogoDAO();

        //DAO -DATA ACCESS OBJECT
        public boolean inserirAlugado(Alugado alugado) {
            connectToDB();
            String sql = "INSERT INTO alugado (data_Alugado, data_Devolucao,codigo_jogo) values(?,?,?)";
            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, alugado.getDataAlugado());
                pst.setString(2, alugado.getDataDevolucao());
                pst.setInt(3, alugado.getCodigo_jogo());

                jogoDA01.atualizarJogo(alugado.getCodigo_jogo(),true);

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
        public boolean deletarAlugado(int codigo) {
        connectToDB();
        String sql = "DELETE FROM alugado where codigo_jogo=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, codigo);
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

}



