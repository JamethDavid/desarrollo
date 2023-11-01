package com.example.desrrollo.config;

import com.example.desrrollo.Repository.RepositoryEmpresa;
import org.springframework.beans.factory.annotation.Qualifier;;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = RepositoryEmpresa.class,
        entityManagerFactoryRef = "todosEntityManagerFactory",
        transactionManagerRef = "todosTransactionManager"
)
public class ClienteConfig {
    @Bean
    public LocalContainerEntityManagerFactoryBean todosEntityManagerFactory(
            @Qualifier("dataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean localContainer =
                new LocalContainerEntityManagerFactoryBean();
        localContainer.setDataSource(dataSource);
        localContainer.setPersistenceUnitName("mysql");
        localContainer.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Map<String,String> addItemProps = new HashMap<>();
        addItemProps.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        return localContainer;
    }
    @Bean
    public PlatformTransactionManager todosTransactionManager(
            @Qualifier("todosEntityManagerFactory") LocalContainerEntityManagerFactoryBean todosEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(todosEntityManagerFactory.getObject()));
    }



}




