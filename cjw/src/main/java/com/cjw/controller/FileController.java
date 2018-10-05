package com.cjw.controller;

import com.cjw.auth.AuthUser;
import com.cjw.auth.CurrentUser;
import com.cjw.pojo.FilePojo;
import com.cjw.pojo.ResultPojo;
import com.cjw.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/File")
public class FileController {

    @Autowired
    private FileService fileService;
    /**
     * 文件上传的绝对路径
     */
    @Value("${file.uploadPath}")
    private String uploadPath;

    /**
     * 文件上传
     *
     * @param file
     * @param user
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResultPojo upload(@RequestParam("file") MultipartFile file, @CurrentUser AuthUser user) throws IOException {
        ResultPojo resultPojo = new ResultPojo();

        if (file.isEmpty()) {
            resultPojo.setMessage("文件为空");
            return resultPojo;
        }

        Path path = Paths.get(uploadPath + user.getUserId() + "/" + file.getOriginalFilename());
        fileService.uploadFile(file.getBytes(), path);

        FilePojo filePojo = new FilePojo();
        filePojo.setFileName(path.getFileName().toString());
        filePojo.setPath(path.toString());
        filePojo.setUserId(user.getUserId());
        fileService.add(filePojo);

        resultPojo.setSuccess(true);
        resultPojo.setMessage("上传成功");
        return resultPojo;
    }
}
