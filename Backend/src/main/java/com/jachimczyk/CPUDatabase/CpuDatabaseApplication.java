package com.jachimczyk.CPUDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CpuDatabaseApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(CpuDatabaseApplication.class, args);
    }
}
