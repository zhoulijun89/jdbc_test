import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Package: PACKAGE_NAME
 * ClassName: MyConnection
 * Author: zhoulijun89@gmail.com
 * Description:
 * CreateDate: 2016-07-15
 * Version: 1.0
 */
public class MyConnection {
    private static Properties prop;

    private static MyConnection myConnection=null;

    private MyConnection(){

    }

    public static MyConnection newInstance(){
        if (myConnection==null){
            myConnection=new MyConnection();
        }
        return myConnection;
    }

    static {
        try {
            prop=new Properties();
            InputStream in = Object.class.getResourceAsStream("/resources.properties");
            prop.load(in);     ///加载属性列表
            Class.forName(prop.getProperty("jdbc.driver"));//加载mysql驱动
        } catch (FileNotFoundException e) {
            System.out.println("没有找到文件");
            e.printStackTrace();
        }catch (IOException e){
            System.out.println("读取resources.properties文件出错");
        }catch (ClassNotFoundException e) {
            System.out.println("驱动加载错误");
            e.printStackTrace();//打印出错详细信息
        }
    }


    public Connection getConnection(){
        Connection conn=null;
        try {
            conn = DriverManager.getConnection(prop.getProperty("jdbc.url"),prop.getProperty("jdbc.user"),prop.getProperty("jdbc.password"));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
