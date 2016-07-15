import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Package: PACKAGE_NAME
 * ClassName: SQLTest
 * Author: zhoulijun89@gmail.com
 * Description:
 * CreateDate: 2016-07-15
 * Version: 1.0
 */
public class SQLTest {

    public static void main(String[] args) {
        Connection conn=MyConnection.newInstance().getConnection();
        Statement stmt;
        if (conn!=null){
            try {
                stmt = conn.createStatement();
                String sql = "select * from XLPC_PCXX";//dept这张表有deptno，deptname和age这三个字段
                ResultSet rs = stmt.executeQuery(sql);//执行sql语句
                while (rs.next()){
                    System.out.println(rs.getString("KKMC"));
                    System.out.println(rs.getString("PCSJ"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
