package com.proj.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ehsure on 2018/6/25.
 * TransVouch 调拨单单头
 */
public class RDCToRDCOutHeaderDTO implements Serializable {
    private String id;//id
    private String cTVCode;//单据号
    private Date dTVDate;//单据日期
    private String cOWhCode;//转出仓库
    private String cIWhCode;//转入仓库
    private String cORdCode;//出库类别
    private String cIRdCode;//入库类别

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getcTVCode() {
        return cTVCode;
    }

    public void setcTVCode(String cTVCode) {
        this.cTVCode = cTVCode;
    }

    public Date getdTVDate() {
        return dTVDate;
    }

    public void setdTVDate(Date dTVDate) {
        this.dTVDate = dTVDate;
    }

    public String getcOWhCode() {
        return cOWhCode;
    }

    public void setcOWhCode(String cOWhCode) {
        this.cOWhCode = cOWhCode;
    }

    public String getcIWhCode() {
        return cIWhCode;
    }

    public void setcIWhCode(String cIWhCode) {
        this.cIWhCode = cIWhCode;
    }

    public String getcORdCode() {
        return cORdCode;
    }

    public void setcORdCode(String cORdCode) {
        this.cORdCode = cORdCode;
    }

    public String getcIRdCode() {
        return cIRdCode;
    }

    public void setcIRdCode(String cIRdCode) {
        this.cIRdCode = cIRdCode;
    }
}
