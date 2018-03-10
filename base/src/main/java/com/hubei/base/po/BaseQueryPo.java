package com.hubei.base.po;

import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;

@Data
public class BaseQueryPo  {

    private transient Integer offset = 0 ;

    private transient Integer limit = 50;
}
