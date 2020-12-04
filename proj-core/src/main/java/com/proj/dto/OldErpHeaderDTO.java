package com.proj.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 中啊ERP表头
 */
public class OldErpHeaderDTO implements Serializable {
    //ERP的ID

    private String id;
    //单据号

    private String ccode;

    private String cvouchtype;

    private String cplanvouchtype;

    private String csotype;

    private String ctransvencode;

    private String ctransvenanme;

    private String vensettletype;
    //单据日期

    private Date billdate;
    //部门代码

    private String cdepcode;
    //部门名称

    private String cdepname;

    private String ccuscode;

    private String ccusname;

    private String ccusabbname;

    private String csccode;
    //发运方式

    private String cscname;

    private String ctfcode;

    private String ctfname;

    private String cttcode;

    private String cttname;

    private String ctlcode;

    private String ctlname;

    private String btotalwei;

    private String ipricequan;

    private String cstate;
    //创建人

    private String cmaker;
    //审核人

    private String verify;
    //审核时间

    private Date verifydate;

    private String csend;

    private String ivtid;

    private BigDecimal  ufts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getCvouchtype() {
        return cvouchtype;
    }

    public void setCvouchtype(String cvouchtype) {
        this.cvouchtype = cvouchtype;
    }

    public String getCplanvouchtype() {
        return cplanvouchtype;
    }

    public void setCplanvouchtype(String cplanvouchtype) {
        this.cplanvouchtype = cplanvouchtype;
    }

    public String getCsotype() {
        return csotype;
    }

    public void setCsotype(String csotype) {
        this.csotype = csotype;
    }

    public String getCtransvencode() {
        return ctransvencode;
    }

    public void setCtransvencode(String ctransvencode) {
        this.ctransvencode = ctransvencode;
    }

    public String getCtransvenanme() {
        return ctransvenanme;
    }

    public void setCtransvenanme(String ctransvenanme) {
        this.ctransvenanme = ctransvenanme;
    }

    public String getVensettletype() {
        return vensettletype;
    }

    public void setVensettletype(String vensettletype) {
        this.vensettletype = vensettletype;
    }

    public Date getBilldate() {
        return billdate;
    }

    public void setBilldate(Date billdate) {
        this.billdate = billdate;
    }

    public String getCdepcode() {
        return cdepcode;
    }

    public void setCdepcode(String cdepcode) {
        this.cdepcode = cdepcode;
    }

    public String getCdepname() {
        return cdepname;
    }

    public void setCdepname(String cdepname) {
        this.cdepname = cdepname;
    }

    public String getCcuscode() {
        return ccuscode;
    }

    public void setCcuscode(String ccuscode) {
        this.ccuscode = ccuscode;
    }

    public String getCcusname() {
        return ccusname;
    }

    public void setCcusname(String ccusname) {
        this.ccusname = ccusname;
    }

    public String getCcusabbname() {
        return ccusabbname;
    }

    public void setCcusabbname(String ccusabbname) {
        this.ccusabbname = ccusabbname;
    }

    public String getCsccode() {
        return csccode;
    }

    public void setCsccode(String csccode) {
        this.csccode = csccode;
    }

    public String getCscname() {
        return cscname;
    }

    public void setCscname(String cscname) {
        this.cscname = cscname;
    }

    public String getCtfcode() {
        return ctfcode;
    }

    public void setCtfcode(String ctfcode) {
        this.ctfcode = ctfcode;
    }

    public String getCtfname() {
        return ctfname;
    }

    public void setCtfname(String ctfname) {
        this.ctfname = ctfname;
    }

    public String getCttcode() {
        return cttcode;
    }

    public void setCttcode(String cttcode) {
        this.cttcode = cttcode;
    }

    public String getCttname() {
        return cttname;
    }

    public void setCttname(String cttname) {
        this.cttname = cttname;
    }

    public String getCtlcode() {
        return ctlcode;
    }

    public void setCtlcode(String ctlcode) {
        this.ctlcode = ctlcode;
    }

    public String getCtlname() {
        return ctlname;
    }

    public void setCtlname(String ctlname) {
        this.ctlname = ctlname;
    }

    public String getBtotalwei() {
        return btotalwei;
    }

    public void setBtotalwei(String btotalwei) {
        this.btotalwei = btotalwei;
    }

    public String getIpricequan() {
        return ipricequan;
    }

    public void setIpricequan(String ipricequan) {
        this.ipricequan = ipricequan;
    }

    public String getCstate() {
        return cstate;
    }

    public void setCstate(String cstate) {
        this.cstate = cstate;
    }

    public String getCmaker() {
        return cmaker;
    }

    public void setCmaker(String cmaker) {
        this.cmaker = cmaker;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public Date getVerifydate() {
        return verifydate;
    }

    public void setVerifydate(Date verifydate) {
        this.verifydate = verifydate;
    }

    public String getCsend() {
        return csend;
    }

    public void setCsend(String csend) {
        this.csend = csend;
    }

    public String getIvtid() {
        return ivtid;
    }

    public void setIvtid(String ivtid) {
        this.ivtid = ivtid;
    }

    public BigDecimal getUfts() {
        return ufts;
    }

    public void setUfts(BigDecimal ufts) {
        this.ufts = ufts;
    }
}
