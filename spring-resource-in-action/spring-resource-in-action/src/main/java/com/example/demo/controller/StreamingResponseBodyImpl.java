package com.example.demo.controller;

import lombok.Getter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.*;

/**
 * @author sskim
 */
@Getter
@Component
public class StreamingResponseBodyImpl implements StreamingResponseBody {

    private final File file;

    public StreamingResponseBodyImpl() throws IOException {
        final ClassPathResource classPathResource = new ClassPathResource("test.json.gz");
        this.file = classPathResource.getFile();
    }

    @Override
    public void writeTo(final OutputStream outputStream) throws IOException {
        try (final InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            FileCopyUtils.copy(inputStream, outputStream);
        }
    }
}
