package com.bob.dcits.system.modules.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import com.bob.dcits.base.BaseEntity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
* @author admin
* @date 2019-04-10
*/
@Getter
@Setter
@TableName("sys_dict")
public class Dict extends BaseEntity implements Serializable {

    @NotNull(groups = Update.class)
    @ApiModelProperty(value = "ID", hidden = true)
    @TableId(value = "dict_id", type = IdType.AUTO)
    private Long id;

    @TableField(exist = false)
    private List<DictDetail> dictDetails;

    @NotBlank
    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;
}