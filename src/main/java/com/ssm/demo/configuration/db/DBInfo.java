package com.ssm.demo.configuration.db;

import lombok.Data;

/**
 * 数据库连接基础配置信息
 */
@Data
public class DBInfo {
    String driver;
    String url;
    String databaseName;
    String username;
    String password;
}
