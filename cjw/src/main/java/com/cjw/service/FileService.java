package com.cjw.service;

import com.cjw.common.Constant;
import com.cjw.dao.FileDao;
import com.cjw.pojo.FilePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileService {
    @Autowired
    private FileDao fileDao;

    /**
     * 文件上传
     *
     * @param bytes
     * @param path
     * @throws IOException
     */
    public void uploadFile(byte[] bytes, Path path) throws IOException {
        mkdir(path.getParent().toString());
        Files.write(path, bytes);
    }

    /**
     * 创建文件夹
     *
     * @param path
     * @return
     */
    private boolean mkdir(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            return dir.mkdirs();
        }
        return false;
    }

    public FilePojo add(FilePojo filePojo) {
        com.cjw.dao.entity.File file = new com.cjw.dao.entity.File();
        file.setFileName(filePojo.getFileName());
        file.setPath(filePojo.getPath());
        file.setUserId(filePojo.getUserId());
        file.setState(Constant.STATE.VALUE);
        fileDao.add(file);

        filePojo.setFileId(file.getFileId());
        return filePojo;
    }

}
