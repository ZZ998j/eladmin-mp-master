package com.bob.dcits.system.modules.quartz.config;

import lombok.RequiredArgsConstructor;
import com.bob.dcits.system.modules.quartz.domain.QuartzJob;
import com.bob.dcits.system.modules.quartz.mapper.QuartzJobMapper;
import com.bob.dcits.system.modules.quartz.utils.QuartzManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @author guoq
 * @date 2024-01-07
 */
@Component
@RequiredArgsConstructor
public class JobRunner implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(JobRunner.class);
    private final QuartzJobMapper quartzJobMapper;
    private final QuartzManage quartzManage;

    /**
     * 项目启动时重新激活启用的定时任务
     *
     * @param applicationArguments /
     */
    @Override
    public void run(ApplicationArguments applicationArguments) {
        List<QuartzJob> quartzJobs = quartzJobMapper.findByIsPauseIsFalse();
        quartzJobs.forEach(quartzManage::addJob);
        log.info("Timing task injection complete");
    }
}
