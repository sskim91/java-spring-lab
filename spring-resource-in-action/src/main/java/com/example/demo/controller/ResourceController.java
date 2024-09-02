package com.example.demo.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.*;

/**
 * @author sskim
 */
@RestController
public class ResourceController {

    @GetMapping("/resource")
    public ResponseEntity<?> resource() throws IOException {


        final ClassPathResource classPathResource = new ClassPathResource("test.json.gz");
        final File file = classPathResource.getFile();

        final StreamingResponseBody streamingResponseBody = outputStream -> {
            try (final InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
                FileCopyUtils.copy(inputStream, outputStream);
            }
        };

        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_ENCODING, "gzip");
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName().replace(".gz", ""));

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(streamingResponseBody);

    }

    @GetMapping("/resource2")
    public ResponseEntity<StreamingResponseBody> resourceType() throws IOException {


        final ClassPathResource classPathResource = new ClassPathResource("test.json.gz");
        final File file = classPathResource.getFile();

        final StreamingResponseBody streamingResponseBody = outputStream -> {
            try (final InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
                FileCopyUtils.copy(inputStream, outputStream);
            }
        };

        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_ENCODING, "gzip");
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName().replace(".gz", ""));

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(streamingResponseBody);

    }

    @GetMapping("/resource3")
    public ResponseEntity<StreamingResponseBodyImpl> resource3() throws IOException {

        final StreamingResponseBodyImpl streamingResponseBody = new StreamingResponseBodyImpl();
        final File file = streamingResponseBody.getFile();

        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_ENCODING, "gzip");
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName().replace(".gz", ""));

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(streamingResponseBody);

    }
}
