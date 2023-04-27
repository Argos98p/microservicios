package com.turisup.rdfservice.Stardog;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "stardog")
public class StardogProperties {
    private String dbname;
    private String server;
    private String username;
    private String pass;
    public void setDbName(String dbName) {
        this.dbname = dbName;
    }

    public String getDbName() {
        return dbname;
    }

    public String getServer() {
        return server;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
