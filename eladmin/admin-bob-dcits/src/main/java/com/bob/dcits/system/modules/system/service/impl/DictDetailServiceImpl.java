package com.bob.dcits.system.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import com.bob.dcits.system.modules.system.domain.Dict;
import com.bob.dcits.system.modules.system.domain.DictDetail;
import com.bob.dcits.system.modules.system.mapper.DictMapper;
import com.bob.dcits.system.modules.system.domain.vo.DictDetailQueryCriteria;
import com.bob.dcits.utils.*;
import com.bob.dcits.system.modules.system.mapper.DictDetailMapper;
import com.bob.dcits.system.modules.system.service.DictDetailService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* @author admin
* @date 2019-04-10
*/
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "dict")
public class DictDetailServiceImpl extends ServiceImpl<DictDetailMapper, DictDetail> implements DictDetailService {

    private final DictMapper dictMapper;
    private final DictDetailMapper dictDetailMapper;
    private final RedisUtils redisUtils;

    @Override
    public PageResult<DictDetail> queryAll(DictDetailQueryCriteria criteria, Page<Object> page) {
        return PageUtil.toPage(dictDetailMapper.findAll(criteria, page));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(DictDetail resources) {
        resources.setDictId(resources.getDict().getId());
        save(resources);
        // 清理缓存
        delCaches(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(DictDetail resources) {
        DictDetail dictDetail = getById(resources.getId());
        resources.setId(dictDetail.getId());
        // 更新数据
        saveOrUpdate(resources);
        // 清理缓存
        delCaches(dictDetail);
    }

    @Override
    @Cacheable(key = "'name:' + #p0")
    public List<DictDetail> getDictByName(String name) {
        return dictDetailMapper.findByDictName(name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        DictDetail dictDetail = getById(id);
        removeById(id);
        // 清理缓存
        delCaches(dictDetail);
    }

    public void delCaches(DictDetail dictDetail){
        Dict dict = dictMapper.selectById(dictDetail.getDictId());
        redisUtils.del(CacheKey.DICT_NAME + dict.getName());
    }
}