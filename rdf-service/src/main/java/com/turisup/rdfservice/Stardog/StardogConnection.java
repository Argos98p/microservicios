package com.turisup.rdfservice.Stardog;

import com.complexible.stardog.api.Connection;
import com.complexible.stardog.api.ConnectionConfiguration;

public class StardogConnection {


    public static Connection createConnection()  {
        return  ConnectionConfiguration
                .to("Turismo2")
                .server("https://sd-90ffdb51.stardog.cloud:5820")
                .credentials("ricardo", "Chocolate619")
                .connect();
    }
}
