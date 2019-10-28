/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:FileDownLoad
 * Time:2019/10/2515:26
 * Description:
 */
package controller;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileDownLoad extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        String fileName = req.getParameter("fileName");
        fileName=new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
        String path="D:\\personal-project\\IDEA_project\\filehandle\\web\\upload";
        File file = new File(path, fileName);
        if (!file.exists()) {
            resp.getWriter().write("文件不存在无法下载");
            return;
        } else {
            resp.setContentType("image/jpg");
            resp.setHeader("Content-Disposition", "attachment; filename=" +fileName);
            IOUtils.copy(new FileInputStream(file),resp.getOutputStream());
        }
    }
}
