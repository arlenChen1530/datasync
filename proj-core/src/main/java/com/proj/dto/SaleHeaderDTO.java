package com.proj.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 中啊ERP表头
 */
public class SaleHeaderDTO implements Serializable {
    private String id;  //ERP的ID
    private String csocode;  //ERP单号
    private Date ddate;  //ERP单据日期
    private String cstname;  //销售类型
    private String cscname;  //发运方式
    private String ccusabbname;  //客户简称
    private String ccuscode;  //客户编码
    private String cdefine13;  //商业库
    private Date cwverifydate;  //财务审核日期

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCsocode() {
        return csocode;
    }

    public void setCsocode(String csocode) {
        this.csocode = csocode;
    }

    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }

    public String getCstname() {
        return cstname;
    }

    public void setCstname(String cstname) {
        this.cstname = cstname;
    }

    public String getCscname() {
        return cscname;
    }

    public void setCscname(String cscname) {
        this.cscname = cscname;
    }

    public String getCcusabbname() {
        return ccusabbname;
    }

    public void setCcusabbname(String ccusabbname) {
        this.ccusabbname = ccusabbname;
    }

    public String getCcuscode() {
        return ccuscode;
    }

    public void setCcuscode(String ccuscode) {
        this.ccuscode = ccuscode;
    }

    public String getCdefine13() {
        return cdefine13;
    }

    public void setCdefine13(String cdefine13) {
        this.cdefine13 = cdefine13;
    }

    public Date getCwverifydate() {
        return cwverifydate;
    }

    public void setCwverifydate(Date cwverifydate) {
        this.cwverifydate = cwverifydate;
    }
}
