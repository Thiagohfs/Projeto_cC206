import java.sql.SQLException;

public class ClienteDAO extends ConnectionDAO{
    boolean aprovado = false;

    //DAO -DATA ACCESS OBJECT
    public boolean inserirCliente(Cliente cliente) {
        connectToDB();
        String sql = "INSERT INTO cliente (nome, CPF, endereco) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCpf());
            pst.setString(3, cliente.getEndereco());
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

}
