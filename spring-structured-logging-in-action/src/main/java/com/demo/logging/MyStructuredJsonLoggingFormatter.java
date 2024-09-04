package com.demo.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import org.springframework.boot.json.JsonWriter;
import org.springframework.boot.logging.structured.StructuredLogFormatter;

public class MyStructuredJsonLoggingFormatter implements StructuredLogFormatter<ILoggingEvent> {

    private final JsonWriter<ILoggingEvent> writer = JsonWriter.<ILoggingEvent>of((members) -> {
        members.add("time", (event) -> event.getInstant());
        members.add("level", (event) -> event.getLevel());
        members.add("thread", (event) -> event.getThreadName());
        members.add("message", (event) -> event.getFormattedMessage());
        members.add("application").usingMembers((application) -> {
            application.add("name", "StructuredLoggingDemo");
            application.add("version", "1.0.0-SNAPSHOT");
        });
        members.add("node").usingMembers((node) -> {
            node.add("hostname", "node-1");
            node.add("ip", "10.0.0.7");
        });
    }).withNewLineAtEnd();

    @Override
    public String format(ILoggingEvent event) {
        return this.writer.writeToString(event);
    }
}
