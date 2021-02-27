import java.sql.*;
import java.sql.SQLException;

public class jdbc {

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            /*String connectionUrl = "jdbc:sqlserver://59.0.236.177:1433;database=SMARTLIB;integratedSecurity=true";*/
            String connectionUrl = "jdbc:sqlserver://59.0.236.177;database=SMARTLIB;user=importken;password=12345";
            Connection conn = DriverManager.getConnection(connectionUrl);
            Statement stmt = conn.createStatement();
            System.out.println("MS-SQL 서버 접속에 성공하였습니다.");
            ResultSet rs = stmt.executeQuery("SELECT TOP 2 ranking, region FROM raw_loanitemsrch_sub");
            while( rs.next() ) {
                   int field1 = rs.getInt("ranking");
                   int field2 = rs.getInt("region");
                   System.out.print(field1 + "\t");
                   System.out.println(field2);
                  }
            rs.close();
            stmt.close();   
            conn.close();
        } catch (SQLException sqle) {
            System.out.println("SQLException : " + sqle);
        }
    }

}