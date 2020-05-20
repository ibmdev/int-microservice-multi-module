package fr.sma.bw.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "fr.sma.bw.repositories.mybatis", sqlSessionTemplateRef = "SessionTemplate")
public class DataSourceConfig {

    @Value("${spring.profiles.active:default}")
    private String activeProfile;


    /* JDBC TEMPLATE */
    @Bean(name="JdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("DataSource") DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        jdbcTemplate.setQueryTimeout(300000);
        return jdbcTemplate;
    }

    /* DATASOURCE */
    @Bean(name = "DataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource DataSource(@Value("${spring.datasource.hikari.schema:undefined}") String schema) throws Exception {
        DataSource ds = DataSourceBuilder.create().build();
        if(("undefined".equalsIgnoreCase(schema) || "".equalsIgnoreCase(schema)) && "prod".equalsIgnoreCase(activeProfile)) {
           throw new Exception("Veuillez spécifier un schema dans la configuration spring.datasource.hikari");
        }
        else if(!"undefined".equalsIgnoreCase(schema) && "prod".equalsIgnoreCase(activeProfile)) {
            ((HikariDataSource)ds).setSchema(schema);
        }
        return ds;
    }

    /*  SessionFactory */
    @Bean(name = "SessionFactory")
    public SqlSessionFactory SessionFactory(@Qualifier("DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    /*  DataSourceTransactionManager */
    @Bean(name = "TransactionManager")
    public DataSourceTransactionManager TransactionManager(@Qualifier("DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /* SqlSessionTemplate  */
    @Bean(name = "SessionTemplate")
    public SqlSessionTemplate SessionTemplate(@Qualifier("SessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
