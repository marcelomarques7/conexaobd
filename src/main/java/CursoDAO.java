import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    /// CONSULTA TODOS
    public List<Curso> list() {

        List<Curso> cursos = new ArrayList<>();

        try(Connection conn = ConnectionFactory.getConnection()){

            String sql = "SELECT * FROM curso";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int duracao_horas = rs.getInt("duracao_horas");

                cursos.add(new Curso(
                   id,
                   nome,
                   duracao_horas
                ));
            }

        } catch (SQLException e){
            System.out.println("Listagem de cursos FALHOU!");
            e.printStackTrace();
        }

        return cursos;

    }

    //CONSULTA FILTRO
    public Curso getById(int id) {

        Curso curso = new Curso();

        try(Connection connn = ConnectionFactory.getConnection()){

            String sql = "SELECT * FROM curso WHERE id = ?";

            PreparedStatement stmt = connn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setDuracao_horas(rs.getInt("duracao_horas"));
            }

        } catch (SQLException e){
            System.out.println("Listagem de cursos FALHOU!");
            e.printStackTrace();
        }

        return curso;

    }

    //INSERÇÃO
    public void create(Curso curso){

        try(Connection connn = ConnectionFactory.getConnection()){

            String sql = "INSERT INTO curso(nome, duracao_horas) VALUES (?, ?)";

            PreparedStatement stmt = connn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getDuracao_horas());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Inserção BEM SUCEDIDA! Foi adicionada "+rowsAffected+" linha.");

        } catch (SQLException e){
            System.out.println("Inserção FALHOU!");
            e.printStackTrace();
        }

    }

    //DELETE
    public void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //Preparar SQL para deletar uma linha.
            String sql = "DELETE FROM curso WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1 , id);

            //Executa delete e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Delete BEM SUCEDIDA! Foi deletada " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Delete FALHOU!");
            e.printStackTrace();
        }
    }

    //ATUALIZAR
    public void update(Curso curso){
        try (Connection conn = ConnectionFactory.getConnection()) {

            //Preparar SQL para atualizar linhas.
            String sql = "UPDATE curso SET nome = ?, duracao_horas = ? WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getDuracao_horas());
            stmt.setInt(3, curso.getId());

            //Executa atualização e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Atualização BEM SUCEDIDA! Foi atualizada: " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Atualização FALHOU!");
            e.printStackTrace();
        }
    }


}



















