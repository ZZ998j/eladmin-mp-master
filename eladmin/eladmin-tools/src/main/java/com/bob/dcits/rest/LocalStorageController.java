package com.bob.dcits.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import com.bob.dcits.annotation.Log;
import com.bob.dcits.domain.LocalStorage;
import com.bob.dcits.exception.BadRequestException;
import com.bob.dcits.service.LocalStorageService;
import com.bob.dcits.domain.vo.LocalStorageQueryCriteria;
import com.bob.dcits.utils.FileUtil;
import com.bob.dcits.utils.PageResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @author bbb
* @date 2020-09-05
*/
@RestController
@RequiredArgsConstructor
@Api(tags = "工具：本地存储管理")
@RequestMapping("/api/localStorage")
public class LocalStorageController {

    private final LocalStorageService localStorageService;

    @GetMapping
    @ApiOperation("查询文件")
    @PreAuthorize("@el.check('storage:list')")
    public ResponseEntity<PageResult<LocalStorage>> queryFile(LocalStorageQueryCriteria criteria, Page<Object> page){
        return new ResponseEntity<>(localStorageService.queryAll(criteria,page),HttpStatus.OK);
    }

    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('storage:list')")
    public void exportFile(HttpServletResponse response, LocalStorageQueryCriteria criteria) throws IOException {
        localStorageService.download(localStorageService.queryAll(criteria), response);
    }

    @PostMapping
    @ApiOperation("上传文件")
    @PreAuthorize("@el.check('storage:add')")
    public ResponseEntity<Object> createFile(@RequestParam String name, @RequestParam("file") MultipartFile file){
        localStorageService.create(name, file);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation("上传图片")
    @PostMapping("/pictures")
    public ResponseEntity<LocalStorage> uploadPicture(@RequestParam MultipartFile file){
        // 判断文件是否为图片
        String suffix = FileUtil.getExtensionName(file.getOriginalFilename());
        if(!FileUtil.IMAGE.equals(FileUtil.getFileType(suffix))){
            throw new BadRequestException("只能上传图片");
        }
        LocalStorage localStorage = localStorageService.create(null, file);
        return new ResponseEntity<>(localStorage, HttpStatus.OK);
    }

    @PutMapping
    @Log("修改文件")
    @ApiOperation("修改文件")
    @PreAuthorize("@el.check('storage:edit')")
    public ResponseEntity<Object> updateFile(@Validated @RequestBody LocalStorage resources){
        localStorageService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除文件")
    @DeleteMapping
    @ApiOperation("多选删除")
    public ResponseEntity<Object> deleteFile(@RequestBody Long[] ids) {
        localStorageService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}