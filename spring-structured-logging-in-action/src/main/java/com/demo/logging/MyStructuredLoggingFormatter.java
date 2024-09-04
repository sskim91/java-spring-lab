package com.demo.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import org.springframework.boot.logging.structured.StructuredLogFormatter;

public class MyStructuredLoggingFormatter implements StructuredLogFormatter<ILoggingEvent> {
    @Override
    public String format(final ILoggingEvent event) {
        return "time=" + event.getTimeStamp() + " level=" + event.getLevel() + " message=" + event.getMessage() + "\n";
    }
}
