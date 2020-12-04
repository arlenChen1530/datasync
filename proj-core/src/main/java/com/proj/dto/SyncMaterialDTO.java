package com.proj.dto;


import java.io.Serializable;
import java.util.Date;

/**
 * 物料数据
 */

public class SyncMaterialDTO implements Serializable {
    private String cInvCode;    //存货编码（05开头的为袋装产品）
    private String cInvName;    //存货名称
    private String cInvDefine6;    //总养分含量（存货自定义项6）
    private String cInvStd;    //规格型号
    private String cInvDefine7;    //品牌（存货自定义项7）
    private String cInvDefine8;    //钾元素类型（存货自定义项8）
    private String cInvDefine1;    //氮元素类型（存货自定义项1）
    private String cInvDefine2;    //产品功能类别（存货自定义项2）
    private Date dEDate; //停用日期
    private Date dSDate; //启用日期

    public String getcInvCode() {
        return cInvCode;
    }

    public void setcInvCode(String cInvCode) {
        this.cInvCode = cInvCode;
    }

    public String getcInvName() {
        return cInvName;
    }

    public void setcInvName(String cInvName) {
        this.cInvName = cInvName;
    }

    public String getcInvDefine6() {
        return cInvDefine6;
    }

    public void setcInvDefine6(String cInvDefine6) {
        this.cInvDefine6 = cInvDefine6;
    }

    public String getcInvStd() {
        return cInvStd;
    }

    public void setcInvStd(String cInvStd) {
        this.cInvStd = cInvStd;
    }

    public String getcInvDefine7() {
        return cInvDefine7;
    }

    public void setcInvDefine7(String cInvDefine7) {
        this.cInvDefine7 = cInvDefine7;
    }

    public String getcInvDefine8() {
        return cInvDefine8;
    }

    public void setcInvDefine8(String cInvDefine8) {
        this.cInvDefine8 = cInvDefine8;
    }

    public String getcInvDefine1() {
        return cInvDefine1;
    }

    public void setcInvDefine1(String cInvDefine1) {
        this.cInvDefine1 = cInvDefine1;
    }

    public String getcInvDefine2() {
        return cInvDefine2;
    }

    public void setcInvDefine2(String cInvDefine2) {
        this.cInvDefine2 = cInvDefine2;
    }

    public Date getdEDate() {
        return dEDate;
    }

    public void setdEDate(Date dEDate) {
        this.dEDate = dEDate;
    }

    public Date getdSDate() {
        return dSDate;
    }

    public void setdSDate(Date dSDate) {
        this.dSDate = dSDate;
    }
}
