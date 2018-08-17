package com.spring.data;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDbApplicationTests {

    @Autowired
    private DataSource dateSource;
    @Test
    public void contextLoads() throws SQLException {
        System.out.println(dateSource.getClass());

        Connection connection = dateSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}
