package com.sample.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author sskim
 */
@Slf4j
@Controller
public class UploadController {

    //todo 서버업로드 경로 설정
    public static final String UPLOAD_FOLDER = "/Users/sskim/Documents/ckeditor/";

    /**
     * cKeditor 이미지 서버에 전송
     */
    @RequestMapping({"/image/upload", "image/drag"})
    public void imageUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile upload) throws Exception {
        // 랜덤 문자 생성
        UUID uid = UUID.randomUUID();

        OutputStream out = null;
        PrintWriter printWriter = null;

        //인코딩
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        try {

            //파일 이름 가져오기
            String fileName = upload.getOriginalFilename();
            byte[] bytes = upload.getBytes();

            //이미지 경로 생성
            String uploadFolder = UPLOAD_FOLDER;
            String uploadFolderPath = getFolder();
            //make folder
            File uploadPath = new File(uploadFolder, uploadFolderPath);
            log.info("uploadPath = " + uploadPath);

            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }

            String ckUploadFileName = uid + "_" + fileName;

            out = new FileOutputStream(new File(uploadPath, ckUploadFileName));
            out.write(bytes);
            out.flush(); // outputStram에 저장된 데이터를 전송하고 초기화

            String callback = request.getParameter("CKEditorFuncNum");
            printWriter = response.getWriter();
            String fileUrl = "/image/ckUploadResult?uid=" + uid + "&fileName=" + fileName + "&regDate=" + getFolder();  // 작성화면

            // 업로드시 메시지 출력
            printWriter.println("{\"filename\" : \"" + fileName + "\", \"uploaded\" : 1, \"url\":\"" + fileUrl + "\"}");
            printWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return;
    }

    /**
     * cKeditor 서버로 전송된 이미지 뿌려주기
     */
    @RequestMapping(value = "/image/ckUploadResult")
    public void ckSubmit(@RequestParam(value = "uid") String uid,
                         @RequestParam(value = "fileName") String fileName,
                         @RequestParam(value = "regDate") String regDate,
                         HttpServletResponse response) throws IOException {

        //서버에 저장된 이미지 경로
        String uploadFolder = UPLOAD_FOLDER;

        String ckUploadFileName = uid + "_" + fileName;

        File imgFile = new File(uploadFolder + regDate, ckUploadFileName);

        log.info("imgFile = " + imgFile);

        //사진 이미지 찾지 못하는 경우 예외처리로 빈 이미지 파일을 설정한다.
        if (imgFile.isFile()) {
            byte[] buf = new byte[1024];
            int readByte = 0;
            int length = 0;
            byte[] imgBuf = null;

            FileInputStream fileInputStream = null;
            ByteArrayOutputStream outputStream = null;
            ServletOutputStream out = null;

            try {
                fileInputStream = new FileInputStream(imgFile);
                outputStream = new ByteArrayOutputStream();
                out = response.getOutputStream();

                while ((readByte = fileInputStream.read(buf)) != -1) {
                    outputStream.write(buf, 0, readByte);
                }

                imgBuf = outputStream.toByteArray();
                length = imgBuf.length;
                out.write(imgBuf, 0, length);
                out.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                outputStream.close();
                fileInputStream.close();
                out.close();
            }
        }
    }

    /**
     * 폴더 생성 메서드
     *
     * @return
     */
    private String getFolder() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();

        String str = sdf.format(date);

        return str.replace("-", File.separator);
    }
}
