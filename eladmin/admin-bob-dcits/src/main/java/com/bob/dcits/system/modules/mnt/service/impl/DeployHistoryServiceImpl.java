package com.bob.dcits.system.modules.mnt.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import com.bob.dcits.system.modules.mnt.domain.DeployHistory;
import com.bob.dcits.system.modules.mnt.mapper.DeployHistoryMapper;
import com.bob.dcits.system.modules.mnt.service.DeployHistoryService;
import com.bob.dcits.system.modules.mnt.domain.vo.DeployHistoryQueryCriteria;
import com.bob.dcits.utils.DateUtil;
import com.bob.dcits.utils.FileUtil;
import com.bob.dcits.utils.PageResult;
import com.bob.dcits.utils.PageUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
* @author admin
* @date 2019-08-24
*/
@Service
@RequiredArgsConstructor
public class DeployHistoryServiceImpl extends ServiceImpl<DeployHistoryMapper, DeployHistory> implements DeployHistoryService {

    private final DeployHistoryMapper deployhistoryMapper;

    @Override
    public PageResult<DeployHistory> queryAll(DeployHistoryQueryCriteria criteria, Page<Object> page){
        return PageUtil.toPage(deployhistoryMapper.findAll(criteria, page));
    }

    @Override
    public List<DeployHistory> queryAll(DeployHistoryQueryCriteria criteria){
        return deployhistoryMapper.findAll(criteria);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(DeployHistory resources) {
        resources.setId(IdUtil.simpleUUID());
        resources.setDeployDate(DateUtil.getTimeStamp());
        save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<String> ids) {
        removeBatchByIds(ids);
    }

    @Override
    public void download(List<DeployHistory> deployHistories, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (DeployHistory deployHistory : deployHistories) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("部署编号", deployHistory.getDeployId());
            map.put("应用名称", deployHistory.getAppName());
            map.put("部署IP", deployHistory.getIp());
            map.put("部署时间", deployHistory.getDeployDate());
            map.put("部署人员", deployHistory.getDeployUser());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}
