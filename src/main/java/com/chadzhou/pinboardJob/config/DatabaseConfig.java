package com.chadzhou.pinboardJob.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.chadzhou.pinboardJob.repository")
@EnableTransactionManagement
public class DatabaseConfig {

}
