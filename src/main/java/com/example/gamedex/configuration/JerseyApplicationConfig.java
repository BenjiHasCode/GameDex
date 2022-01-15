package com.example.gamedex.configuration;

import com.example.gamedex.webapi.GameApi;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/rest")
public class JerseyApplicationConfig extends ResourceConfig {
    public JerseyApplicationConfig() {
        System.out.println("JerseyApplicationConfig booting");
        register(GameApi.class);
    }
}