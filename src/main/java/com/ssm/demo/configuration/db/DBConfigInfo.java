package com.ssm.demo.configuration.db;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "dbconfig")
public class DBConfigInfo {
    DBInfo mysql;
}
