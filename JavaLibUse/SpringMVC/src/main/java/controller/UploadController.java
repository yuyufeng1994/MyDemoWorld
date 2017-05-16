package controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by yuyufeng on 2017/5/16.
 */
@Controller
public class UploadController {

    @RequestMapping("/upload-ui")
    public String  uploadUI(){
        return "test/upload";
    }


    @RequestMapping(value = "/upload-files", method = RequestMethod.POST)
    @ResponseBody
    public void uploadFilies(@RequestParam("file") CommonsMultipartFile[] files) {

    }

    @RequestMapping(value = "/upload-file", method = RequestMethod.POST)
    @ResponseBody
    public void uploadFilie(@RequestParam(value = "file") MultipartFile file) throws IOException {
        String uuid = UUID.randomUUID().toString();
        String fileName = file.getOriginalFilename();
        String ext= StringUtils.getFilenameExtension(fileName);
        File getFile = new File("d://"+uuid+"."+ext);
        file.transferTo(getFile);
    }

    public static void main(String[] args) {
        String fileName = "aa.txt";
        System.out.println(StringUtils.getFilenameExtension(fileName));
    }
}
