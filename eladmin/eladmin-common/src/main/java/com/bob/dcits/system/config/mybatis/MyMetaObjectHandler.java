package com.bob.dcits.system.config.mybatis;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.bob.dcits.utils.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;

/**
 * @author guoq
 * @description
 * @date 2024-06-13
 **/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        /* 创建时间 */
        this.strictInsertFill(metaObject, "createTime", Timestamp.class, DateTime.now().toTimestamp());
        this.strictInsertFill(metaObject, "updateTime", Timestamp.class, DateTime.now().toTimestamp());
        /* 操作人 */
        String username = "System";
        try {username = SecurityUtils.getCurrentUsername();}catch (Exception ignored){}
        this.strictInsertFill(metaObject, "createBy", String.class, username);
        this.strictInsertFill(metaObject, "updateBy", String.class, username);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        /* 更新时间 */
        this.strictUpdateFill(metaObject, "updateTime", Timestamp.class, DateTime.now().toTimestamp());
        /* 操作人 */
        String username = "System";
        try {username = SecurityUtils.getCurrentUsername();}catch (Exception ignored){}
        this.strictUpdateFill(metaObject, "updateBy", String.class, username);
    }
}

