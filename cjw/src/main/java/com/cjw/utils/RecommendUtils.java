package com.cjw.utils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.mahout.cf.taste.impl.model.jdbc.ConnectionPoolDataSource;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author qucl
 * @date 2018/11/12 18:40
 */
@Component
@Slf4j
public class RecommendUtils {
    @Value("${spring.datasource.druid.url}")
    private String url;
    @Value("${spring.datasource.druid.username}")
    private String userName;
    @Value("${spring.datasource.druid.password}")
    private String password;

    private JDBCDataModel model;


    public JDBCDataModel getModel() {
        if (model == null) {
            createMysqlDataModel();
        }
        return this.model;
    }

    /**
     * mysql
     *
     * @return
     */
    private void createMysqlDataModel() {
        MysqlDataSource dataSource = new MysqlDataSource();
        try {
            dataSource.setUrl(url);
            dataSource.setUser(userName);
            dataSource.setPassword(password);

            ConnectionPoolDataSource connectionPool = new ConnectionPoolDataSource(dataSource);
            this.model = new MySQLJDBCDataModel(connectionPool, "position_interest", "user_id", "position_id", "preference", null);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
