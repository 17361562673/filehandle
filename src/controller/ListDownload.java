/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:ListDownload
 * Time:2019/10/2515:09
 * Description:
 */
package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListDownload extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path="D:\\personal-project\\IDEA_project\\filehandle\\web\\upload";
        File file = new File(path);
        List<File> fileList=new ArrayList<>();
        if (!file.isDirectory()) {
            resp.getWriter().write("文件不存在无法下载");
            return;
        } else {
            File[] files = file.listFiles();
            for (File file1 : files) {
                fileList.add(file1);
            }
        }
        req.setAttribute("fileList",fileList);
        req.getRequestDispatcher("/download.jsp").forward(req,resp);
    }
}
