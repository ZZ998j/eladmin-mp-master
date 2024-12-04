package com.bob.dcits.system.modules.system.domain.vo;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

/**
 * 构建前端路由时用到
 * @author guoq
 * @date 2024-12-20
 */
@Data
public class MenuVo implements Serializable {

    private String name;

    private String path;

    private Boolean hidden;

    private String redirect;

    private String component;

    private Boolean alwaysShow;

    private MenuMetaVo meta;

    private List<MenuVo> children;
}
