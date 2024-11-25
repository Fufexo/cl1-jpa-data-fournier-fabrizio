package pe.edu.i202225488.cl1_jpa_data_fournier_fabrizio.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConexionesConfig {

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setMaximumPoolSize(30);
        hikariConfig.setMinimumIdle(4);
        hikariConfig.setIdleTimeout(4 * 6 * 1000);
        hikariConfig.setConnectionTimeout(45 * 1000);

        hikariConfig.setJdbcUrl(System.getenv("DB_WORLD_URL"));
        hikariConfig.setUsername(System.getenv("DB_WORLD_USER"));
        hikariConfig.setPassword(System.getenv("DB_WORLD_PASS"));
        hikariConfig.setDriverClassName(System.getenv("DB_WORLD_DRIVER"));

        return new HikariDataSource(hikariConfig);
    }
}