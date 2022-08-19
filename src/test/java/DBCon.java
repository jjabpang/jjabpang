import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.springframework.test.util.AssertionErrors.fail;

/**
 * packageName    : PACKAGE_NAME
 * fileName       : DBCon
 * author         : qkrtkdwns3410
 * date           : 2022-08-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-19        qkrtkdwns3410       최초 생성
 */
public class DBCon {
      
      static {
            try {
                  Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }//static
      
      @Test
      public void testConnection() {
            try (Connection con =
                       DriverManager.getConnection(
                             "jdbc:mysql://jjabpang.c4ccun7w5hlo.ap-northeast-2.rds.amazonaws.com:3306/jjabpang?useSSL=false&serverTimezone=Asia/Seoul&characterEncoding=UTF-8",
                             "jjabpang",
                             "34103410")) {
                  System.out.println("DB connection" + con);
            } catch (Exception e) {
                  fail(e.getMessage());
            }
      }//testConnection
      
}//DBCon
