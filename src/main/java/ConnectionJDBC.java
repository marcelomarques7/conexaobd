import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/digital_innovation_one", "root", "root")) {
            System.out.println("SUCESSO ao se conectar ao banco MySQL!");
        } catch (SQLException e) {
            System.out.println("FALHA ao se conectar ao banco MySQL!");
            e.printStackTrace();
        }

    }

}
