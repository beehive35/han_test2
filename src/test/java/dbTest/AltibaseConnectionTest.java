package dbTest;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

public class AltibaseConnectionTest {

    // MySQL Connector 의 클래스. DB 연결 드라이버 정의
    private static final String DRIVER = "Altibase.jdbc.driver.AltibaseDriver";
    // DB 경로
    private static final String URL = "jdbc:Altibase://192.168.15.107:20300/telusdb";
    private static final String USER = "telusadm";
    private static final String PASSWORD = "telusadm#03";

    @Test
    public void testConnection() throws Exception {
        // DBMS에게 DB 연결 드라이버의 위치를 알려주기 위한 메소드
        Class.forName(DRIVER);
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(connection.isValid(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
