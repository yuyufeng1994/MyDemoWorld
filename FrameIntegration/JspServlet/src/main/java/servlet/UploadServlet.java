package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * Created by yuyufeng on 2017/5/11.
 */
@WebServlet(name = "UploadServlet", urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            String uploadPath = getServletContext().getRealPath("/image");// 上传目录 //放在webinf文件夹下用户无法访问 保证安全
            String uploadPath = "h://test/servlet/upload/";
            // 1、得到DiskFileItemFacotry对象
            DiskFileItemFactory factory = new DiskFileItemFactory();// 10k
            // 建立一个临时文件/temp // java.io.tmpdir(System.getProperty)
//            String tempPath = getServletContext().getRealPath("/temp");
            String tempPath = "h://test/servlet/temp/";
            factory.setRepository(new File(tempPath));// 组件默认不会删除临时文件，

            // 2、得到上传文件的核心类ServletFileUpload
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 实时获取文件上传进度
            upload.setProgressListener(new ProgressListener() {

                @Override
                public void update(long pBytesRead, long PcontentLength, int pItem) {
//                    System.out.println("当前上传了:" + pBytesRead + " 总大小：" + PcontentLength + " pItem: " + pItem);
                    System.out.println("当前上传了:" + (float)pBytesRead / PcontentLength*100 + "%");
                }
            });

            upload.setHeaderEncoding("UTF-8");// 解决中文文件名乱码问题
            // upload.setFileSizeMax(10*1024*1024);//单个文件最大字节
            // upload.setSizeMax(100*1024*1024);//总文件大小
            // 3、判断用户的表单有没有设置为multipart/form-data
            boolean b = upload.isMultipartContent(request);
            if (!b)
                return;

            // 4、如果设置了，解析request中的主体内容，List<FileItem>
            List<FileItem> items = upload.parseRequest(request);
            // 5、遍历List
            for (FileItem item : items) {

                if (item.isFormField()) {
                    // 6、如果是普通字段，打印
                    String fieldName = item.getFieldName();
                    String value = item.getString("UTF-8");// String value = new
                    // String(item.getString().getBytes("ISO-8859-1"),"UTF-8");
                    System.out.println(fieldName + "=" + value);


                } else {
                    // 7、上传：上传到哪个目录
                    String fileName = item.getName();// 获取文件名 C:\Documents and
                    // Settings\wzhting\a.txt
                    // System.out.println(fileName);
                    if (fileName == null || fileName.trim().equals("")) {
                        continue;
                    }
                    fileName = fileName
                            .substring(fileName.lastIndexOf("\\") + 1);// a.txt
                    InputStream in = item.getInputStream();// 获取输入流
                    // 构建输出流
                    fileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
                    String newFilePath = uploadPath + "\\" + fileName;
                    System.out.println(fileName);
                    System.out.println(newFilePath);
                    FileOutputStream out = new FileOutputStream(newFilePath);
                    // System.out.println(newFilePath);
                    byte buf[] = new byte[1024];
                    int len = -1;
                    while ((len = in.read(buf)) != -1) {
                        out.write(buf, 0, len);
                    }
                    in.close();
                    out.close();
                    item.delete();

                }
            }
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            request.setAttribute("message", "对不起，你上传的文件过大");
            request.getRequestDispatcher("/message.jsp").forward(request,
                    response);
        } catch (FileUploadBase.SizeLimitExceededException e) {
            request.setAttribute("message", "对不起，你上传的总文件过大");
            request.getRequestDispatcher("/message.jsp").forward(request,
                    response);

        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("message", "上传成功！");
        response.sendRedirect("/upload");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/test/upload.jsp").forward(request, response);
    }
}
