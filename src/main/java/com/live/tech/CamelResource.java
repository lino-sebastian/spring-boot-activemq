package com.live.tech;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelResource extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("timer://sampleTimer?repeatCount=1")
                .log("Starting Router")
                .setBody(constant("Simple Message"))
                .to("{{sample.queue}}");

        from("{{sample.queue}}")
                .log("Data Consumed from Queue : ${body}")
                .end();
    }
}
