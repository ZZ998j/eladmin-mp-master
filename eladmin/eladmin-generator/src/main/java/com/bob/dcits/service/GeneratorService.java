package com.bob.dcits.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bob.dcits.domain.GenConfig;
import com.bob.dcits.domain.ColumnInfo;
import com.bob.dcits.domain.vo.TableInfo;
import com.bob.dcits.utils.PageResult;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author guoq
 * @date 2024-01-02
 */
public interface GeneratorService extends IService<ColumnInfo> {

    /**
     * 查询数据库元数据
     *
     * @param name 表名
     * @param page 分页参数
     * @return /
     */
    PageResult<TableInfo> getTables(String name, Page<Object> page);

    /**
     * 得到数据表的元数据
     * @param name 表名
     * @return /
     */
    List<ColumnInfo> getColumns(String name);

    /**
     * 同步表数据
     * @param columnInfos /
     * @param columnInfoList /
     */
    void sync(List<ColumnInfo> columnInfos, List<ColumnInfo> columnInfoList);

    /**
     * 保持数据
     * @param columnInfos /
     */
    void save(List<ColumnInfo> columnInfos);

    /**
     * 代码生成
     * @param genConfig 配置信息
     * @param columns 字段信息
     */
    void generator(GenConfig genConfig, List<ColumnInfo> columns);

    /**
     * 预览
     * @param genConfig 配置信息
     * @param columns 字段信息
     * @return /
     */
    ResponseEntity<Object> preview(GenConfig genConfig, List<ColumnInfo> columns);

    /**
     * 打包下载
     * @param genConfig 配置信息
     * @param columns 字段信息
     * @param request /
     * @param response /
     */
    void download(GenConfig genConfig, List<ColumnInfo> columns, HttpServletRequest request, HttpServletResponse response);

    /**
     * 查询数据库的表字段数据数据
     * @param table /
     * @return /
     */
    List<ColumnInfo> query(String table);
}
