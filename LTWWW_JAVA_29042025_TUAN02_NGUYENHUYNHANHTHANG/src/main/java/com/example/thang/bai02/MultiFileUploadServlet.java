package com.example.thang.bai02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MultiFileUploadServlet", urlPatterns = {"/upload"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
                 maxFileSize = 1024 * 1024 * 10,      // 10 MB
                 maxRequestSize = 1024 * 1024 * 50)   // 50 MB
public class MultiFileUploadServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // Always use project source directory for uploads
        String projectRoot = System.getProperty("user.dir");
        String uploadPath = projectRoot + File.separator + "src" + File.separator + "main" + File.separator + "webapp" + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            boolean created = uploadDir.mkdirs();
            if (!created) {
                out.println("<p style='color:red'>Error: Cannot create upload directory at " + uploadPath + ". Check permissions.</p>");
                out.println("</body></html>");
                return;
            }
        }
        if (!uploadDir.canWrite()) {
            out.println("<p style='color:red'>Error: Upload directory is not writable: " + uploadPath + ".</p>");
            out.println("</body></html>");
            return;
        }
        out.println("<html><body>");
        out.println("<h2>Upload Results:</h2>");
        out.println("<p>Upload path: " + uploadPath + "</p>");
        boolean atLeastOneFile = false;
        for (int i = 1; i <= 5; i++) {
            Part filePart = request.getPart("file" + i);
            if (filePart != null && filePart.getSize() > 0) {
                String fileName = getFileName(filePart);
                try {
                    filePart.write(uploadPath + File.separator + fileName);
                    out.println("File #" + i + ": " + fileName + " uploaded successfully.<br>");
                    out.println("Saved at: " + uploadPath + File.separator + fileName + "<br>");
                    atLeastOneFile = true;
                } catch (Exception e) {
                    out.println("File #" + i + ": Error saving file - " + e.getMessage() + "<br>");
                }
            } else {
                out.println("File #" + i + ": No file chosen.<br>");
            }
        }
        if (!atLeastOneFile) {
            out.println("<p>No files were uploaded.</p>");
        }
        out.println("<br><a href='upload.jsp'>Back to Upload Page</a>");
        out.println("</body></html>");
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        for (String token : contentDisp.split(";")) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
