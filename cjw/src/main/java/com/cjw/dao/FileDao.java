package com.cjw.dao;

import com.cjw.common.Constant;
import com.cjw.dao.entity.File;
import com.cjw.dao.entity.FileExample;
import com.cjw.dao.mapper.FileMapper;
import com.cjw.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FileDao {
    @Autowired
    private FileMapper fileMapper;

    public File add(File file) {
        fileMapper.insert(file);
        return file;
    }

    public File findById(Integer id) {
        FileExample example = new FileExample();
        example.createCriteria()
                .andFileIdEqualTo(id)
                .andStateEqualTo(Constant.State.VALUE);
        List<File> files = fileMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(files)) {
            return files.get(0);
        }
        return null;
    }

    public List<File> findByUserId(Integer userId) {
        FileExample example = new FileExample();
        example.createCriteria()
                .andUserIdEqualTo(userId)
                .andStateEqualTo(Constant.State.VALUE);
        List<File> files = fileMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(files)) {
            return files;
        }
        return null;
    }
}
