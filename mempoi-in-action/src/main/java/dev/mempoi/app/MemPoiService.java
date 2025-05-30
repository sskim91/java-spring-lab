package dev.mempoi.app;

import it.firegloves.mempoi.MemPOI;
import it.firegloves.mempoi.builder.MempoiBuilder;
import it.firegloves.mempoi.domain.MempoiSheet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author sskim
 */
@Service
@RequiredArgsConstructor
public class MemPoiService {

    private final UserMapper userMapper;
    private final DataSource dataSource;

    public List<User> searchAllUsers() {
        return userMapper.findAllUsers();
    }

    public List<User> searchUsersByAgeGreaterThan(int age) {
        return userMapper.findByAgeGreaterThan(age);
    }

    public byte[] exportToExcel() throws Exception{
        String sql = """
                    SELECT * FROM USERS
                """;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement prepStmt = connection.prepareStatement(sql)) {
            // MemPOI 설정
            MemPOI memPOI = MempoiBuilder.aMemPOI()
                .addMempoiSheet(new MempoiSheet(prepStmt))
                .build();
            CompletableFuture<byte[]> fut = memPOI.prepareMempoiReportToByteArray();
            return fut.get(); // 엑셀 파일의 바이트 배열 반환
        }
    }
}
