package com.bob.dcits.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import com.bob.dcits.system.config.FileProperties;
import com.bob.dcits.domain.LocalStorage;
import com.bob.dcits.domain.vo.LocalStorageQueryCriteria;
import com.bob.dcits.exception.BadRequestException;
import com.bob.dcits.mapper.LocalStorageMapper;
import com.bob.dcits.utils.*;
import com.bob.dcits.service.LocalStorageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
* @author aa
* @date 2020-09-05
*/
@Service
@RequiredArgsConstructor
public class LocalStorageServiceImpl extends ServiceImpl<LocalStorageMapper, LocalStorage> implements LocalStorageService {

    private final LocalStorageMapper localStorageMapper;
    private final FileProperties properties;

    @Override
    public PageResult<LocalStorage> queryAll(LocalStorageQueryCriteria criteria, Page<Object> page){
        return PageUtil.toPage(localStorageMapper.findAll(criteria, page));
    }

    @Override
    public List<LocalStorage> queryAll(LocalStorageQueryCriteria criteria){
        return localStorageMapper.findAll(criteria);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LocalStorage create(String name, MultipartFile multipartFile) {
        FileUtil.checkSize(properties.getMaxSize(), multipartFile.getSize());
        String suffix = FileUtil.getExtensionName(multipartFile.getOriginalFilename());
        String type = FileUtil.getFileType(suffix);
        File file = FileUtil.upload(multipartFile, properties.getPath().getPath() + type +  File.separator);
        if(ObjectUtil.isNull(file)){
            throw new BadRequestException("上传失败");
        }
        try {
            name = StringUtils.isBlank(name) ? FileUtil.getFileNameNoEx(multipartFile.getOriginalFilename()) : name;
            LocalStorage localStorage = new LocalStorage(
                    file.getName(),
                    name,
                    suffix,
                    file.getPath(),
                    type,
                    FileUtil.getSize(multipartFile.getSize())
            );
            save(localStorage);
            return localStorage;
        }catch (Exception e){
            FileUtil.del(file);
            throw e;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LocalStorage resources) {
        LocalStorage localStorage = getById(resources.getId());
        localStorage.copy(resources);
        saveOrUpdate(localStorage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            LocalStorage storage = getById(id);
            FileUtil.del(storage.getPath());
            removeById(storage);
        }
    }

    @Override
    public void download(List<LocalStorage> queryAll, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (LocalStorage localStorage : queryAll) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("文件名", localStorage.getRealName());
            map.put("备注名", localStorage.getName());
            map.put("文件类型", localStorage.getType());
            map.put("文件大小", localStorage.getSize());
            map.put("创建者", localStorage.getCreateBy());
            map.put("创建日期", localStorage.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}
