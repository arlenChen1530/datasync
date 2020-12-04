package com.proj.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ehsure on 2018/6/26.
 * 移库单头 AdjustPVouch
 */
public class LocationAdjustHeaderDTO implements Serializable {
    private String id;//id
    private String cVouchCode;//调整单号
    private Date dDate;//出库日期
    private String cWhCode;//仓库
    private String cDepCode;//部门

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getcVouchCode() {
        return cVouchCode;
    }

    public void setcVouchCode(String cVouchCode) {
        this.cVouchCode = cVouchCode;
    }

    public Date getdDate() {
        return dDate;
    }

    public void setdDate(Date dDate) {
        this.dDate = dDate;
    }

    public String getcWhCode() {
        return cWhCode;
    }

    public void setcWhCode(String cWhCode) {
        this.cWhCode = cWhCode;
    }

    public String getcDepCode() {
        return cDepCode;
    }

    public void setcDepCode(String cDepCode) {
        this.cDepCode = cDepCode;
    }
}
