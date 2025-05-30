package dev.mempoi.app;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sskim
 */
@RestController
public class UserController {

    private final MemPoiService memPoiService;

    public UserController(MemPoiService memPoiService) {
        this.memPoiService = memPoiService;
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData() throws Exception {
        byte[] excelData = memPoiService.exportToExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "data.xlsx");

        return new ResponseEntity<>(excelData, headers, HttpStatus.OK);
    }
}
