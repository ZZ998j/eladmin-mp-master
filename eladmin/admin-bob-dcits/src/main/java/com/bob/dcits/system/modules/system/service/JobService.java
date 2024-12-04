package com.bob.dcits.system.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bob.dcits.system.modules.system.domain.Job;
import com.bob.dcits.system.modules.system.domain.vo.JobQueryCriteria;
import com.bob.dcits.utils.PageResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
* @author admin
* @date 2019-03-29
*/
public interface JobService extends IService<Job> {

    /**
     * 根据ID查询
     * @param id /
     * @return /
     */
    Job findById(Long id);

    /**
     * 创建
     * @param resources /
     */
    void create(Job resources);

    /**
     * 编辑
     * @param resources /
     */
    void update(Job resources);

    /**
     * 删除
     * @param ids /
     */
    void delete(Set<Long> ids);

    /**
     * 分页查询
     *
     * @param criteria 条件
     * @param page     分页参数
     * @return /
     */
    PageResult<Job> queryAll(JobQueryCriteria criteria, Page<Object> page);

    /**
     * 查询全部数据
     * @param criteria /
     * @return /
     */
    List<Job> queryAll(JobQueryCriteria criteria);

    /**
     * 导出数据
     * @param jobs 待导出的数据
     * @param response /
     * @throws IOException /
     */
    void download(List<Job> jobs, HttpServletResponse response) throws IOException;

    /**
     * 验证是否被用户关联
     * @param ids /
     */
    void verification(Set<Long> ids);
}