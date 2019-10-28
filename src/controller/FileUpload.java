/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:FileUpload
 * Time:2019/10/2514:28
 * Description:
 */
package controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class FileUpload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        DiskFileItemFactory itemFactory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
        try {
            List<FileItem> list = fileUpload.parseRequest(req);
            for (FileItem item : list) {
                String name = item.getName();
                String fieldName = item.getFieldName();
                boolean formField = item.isFormField();
                if (!formField) {
                    String uuid = UUID.randomUUID().toString();
                    String sName = name.substring(name.indexOf("."));
                    if (fieldName!=null&&!"".equals(fieldName)) {
                        String path="D:\\personal-project\\IDEA_project\\filehandle\\web\\upload";
                        File file = new File(path,uuid+sName);
                        item.write(file);
                    }
                }
            }
            resp.getWriter().write("文件上传成功");
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
