package com.proj.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ehsure on 2018/6/26.
 * 其他出库单单头 RdRecord09
 */
public class RDCToOtherDealerOutHeaderDTO implements Serializable {
    private String id;//id
    private String cCode;//出库单号
    private Date dDate;//出库日期
    private String cWhCode;//仓库
    private String cRdCode;//出库类别
    private String cDepCode;//部门

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
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

    public String getcRdCode() {
        return cRdCode;
    }

    public void setcRdCode(String cRdCode) {
        this.cRdCode = cRdCode;
    }

    public String getcDepCode() {
        return cDepCode;
    }

    public void setcDepCode(String cDepCode) {
        this.cDepCode = cDepCode;
    }
}
