package com.bob.dcits.domain.vo;

import lombok.Data;
import java.sql.Timestamp;
import java.util.List;

/**
* @author admin
* @date 2019-09-05
*/
@Data
public class LocalStorageQueryCriteria{

    private String blurry;

    private List<Timestamp> createTime;
}