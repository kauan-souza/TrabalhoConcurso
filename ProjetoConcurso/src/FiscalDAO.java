import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FiscalDAO implements GenericDAO<Fiscal, String> {

    private Connection conexao;

    public FiscalDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/concurso";
            conexao = DriverManager.getConnection(url, "root", "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Fiscal model) {
        try {
            String sql = "INSERT INTO fiscal VALUES(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, model.getNome());
            preparedStatement.setInt(2, model.getIdade());
            preparedStatement.setString(3, model.getCpf());
            preparedStatement.setString(4, model.getEmail());
            preparedStatement.setString(5, model.getAgencia());
            preparedStatement.setString(6, model.getConta());
            preparedStatement.setString(7, model.getPix());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Fiscal> buscar() {
        List<Fiscal> fiscalCadastrado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM fiscal";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                String nome = result.getString("nome");
                int idade = result.getInt("idade");
                String cpf = result.getString("cpf");
                String email = result.getString("email");
                String conta = result.getString("conta");
                String agencia = result.getString("agencia");
                String pix = result.getString("pix");
                if (pix == null) {
                    Fiscal fiscal = new Fiscal(nome, idade, cpf, email, conta, agencia);
                    fiscalCadastrado.add(fiscal);
                } else {
                    Fiscal fiscal = new Fiscal(nome, idade, cpf, email, pix);
                    fiscalCadastrado.add(fiscal);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fiscalCadastrado;
    }

    @Override
    public Fiscal filtrarPorId(String id) {
        try {
            String sql = "select * from fiscal f where f.cpf " + id;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            String nome = result.getString("nome");
            int idade = result.getInt("idade");
            String cpf = result.getString("cpf");
            String email = result.getString("email");
            String conta = result.getString("conta");
            String agencia = result.getString("agencia");
            String pix = result.getString("pix");
            if (pix == null) {
                return new Fiscal(nome, idade, cpf, email, conta, agencia);

            } else {
                return new Fiscal(nome, idade, cpf, email, pix);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    private boolean existeFiscal(String cpf, String nome){
        try {
            String sql = "select * from fiscal f where f.cpf " + cpf + "";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            return result.next();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }


    public void deletarTodos() {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE * FROM fiscal");
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
