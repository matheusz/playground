package com.playground.springevents.eventlisteners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.web.reactive.context.ReactiveWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ApplicationEventListeners {

    @Bean
    public ApplicationListener<ApplicationStartedEvent> applicationStartedEventApplicationListener() {
        return event -> {
            log.info("Application started!");
        };
    }

    @Bean
    public ApplicationListener<ReactiveWebServerInitializedEvent> reactiveWebServerInitializedEventApplicationListener() {
        return event -> {
            log.info("Reactive web server is running at "
                    + event.getApplicationContext().getEnvironment().getProperty("local.server.port")
                    + " port"
            );
        };
    }

}
