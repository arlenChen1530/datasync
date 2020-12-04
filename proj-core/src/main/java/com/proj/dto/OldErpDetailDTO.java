package com.proj.dto;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 中啊ERP明细
 */
public class OldErpDetailDTO implements Serializable {
    //单据ID

    private String id;
    //明细ID

    private String autoid;

    private String cplancode;

    private String autoidplan;

    private String cvouchtype;

    private String csotype;

    private String csoid;
    //订单号

    private String csocode;
    //装载车号
    
    private String wagoncode;
    
    private String billcode;
    
    private String cdepcode;
    
    private String cdepname;
    
    private String cpersoncode;
    
    private String cpersonname;
    //客户代码
    
    private String ccuscode;
    //客户名称
    
    private String ccusname;
    
    private String ccusabbname;
    
    private String ccusdefine1;
    
    private String csoautoid;
    //产品编码
    
    private String cinvcode;
    //产品名称
    
    private String cinvname;
    
    private String cinvstd;
    
    private String cinvdefine1;
    
    private String cinvdefine2;
    
    private String cinvdefine3;
    
    private String cinvdefine4;
    
    private String cinvdefine6;
    
    private String cinvdefine7;
    
    private String cinvdefine8;
    
    private String cinvdefine9;
    
    private String cinvdefine11;
    
    private BigDecimal iquantity;
    
    private BigDecimal inum;
    
    private String ccomunitcode;
    
    private String cinvm_unit;
    
    private String cinva_unitcode;
    
    private String cinva_unit;
    //换算比例
    
    private BigDecimal iinvexchrate;
    
    private BigDecimal idiffquan;
    
    private BigDecimal idiffnum;
    
    private BigDecimal itotalweight;
    
    private BigDecimal ipricequantity;
    
    private String cpricem_unitcode;
    
    private String cpricem_unit;
    
    private BigDecimal ipriceexchrate;
    
    private BigDecimal cdefine26;
    
    private BigDecimal cdefine27;
    
    private String cdefine28;
    
    private String cdefine29;
    
    private String cdefine35;
    //车号排序
    
    private String cbmemo;
    
    private String bufts;
    
    private String ctlcode;
    
    private String ctlname;
    
    private String ownline;
    
    private String cendstationcode;
    //到站名称
    
    private String cendstationname;
    
    private String cendstationaddcode;
    
    private String cdccode;
    
    private String cdcname;
    
    private String consigneecode;
    //收货人
    private String consigneename;
    
    private String consigneeabbname;
    
    private String pbtype;
    
    private String pbcode;
    
    private String containercode;
    
    private String posstate;
    //预装数量（吨）
    
    private BigDecimal iplanpostquantity;
    
    private BigDecimal iposquantity;
    
    private BigDecimal yfitotal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAutoid() {
        return autoid;
    }

    public void setAutoid(String autoid) {
        this.autoid = autoid;
    }

    public String getCplancode() {
        return cplancode;
    }

    public void setCplancode(String cplancode) {
        this.cplancode = cplancode;
    }

    public String getAutoidplan() {
        return autoidplan;
    }

    public void setAutoidplan(String autoidplan) {
        this.autoidplan = autoidplan;
    }

    public String getCvouchtype() {
        return cvouchtype;
    }

    public void setCvouchtype(String cvouchtype) {
        this.cvouchtype = cvouchtype;
    }

    public String getCsotype() {
        return csotype;
    }

    public void setCsotype(String csotype) {
        this.csotype = csotype;
    }

    public String getCsoid() {
        return csoid;
    }

    public void setCsoid(String csoid) {
        this.csoid = csoid;
    }

    public String getCsocode() {
        return csocode;
    }

    public void setCsocode(String csocode) {
        this.csocode = csocode;
    }

    public String getWagoncode() {
        return wagoncode;
    }

    public void setWagoncode(String wagoncode) {
        this.wagoncode = wagoncode;
    }

    public String getBillcode() {
        return billcode;
    }

    public void setBillcode(String billcode) {
        this.billcode = billcode;
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

    public String getCpersoncode() {
        return cpersoncode;
    }

    public void setCpersoncode(String cpersoncode) {
        this.cpersoncode = cpersoncode;
    }

    public String getCpersonname() {
        return cpersonname;
    }

    public void setCpersonname(String cpersonname) {
        this.cpersonname = cpersonname;
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

    public String getCcusdefine1() {
        return ccusdefine1;
    }

    public void setCcusdefine1(String ccusdefine1) {
        this.ccusdefine1 = ccusdefine1;
    }

    public String getCsoautoid() {
        return csoautoid;
    }

    public void setCsoautoid(String csoautoid) {
        this.csoautoid = csoautoid;
    }

    public String getCinvcode() {
        return cinvcode;
    }

    public void setCinvcode(String cinvcode) {
        this.cinvcode = cinvcode;
    }

    public String getCinvname() {
        return cinvname;
    }

    public void setCinvname(String cinvname) {
        this.cinvname = cinvname;
    }

    public String getCinvstd() {
        return cinvstd;
    }

    public void setCinvstd(String cinvstd) {
        this.cinvstd = cinvstd;
    }

    public String getCinvdefine1() {
        return cinvdefine1;
    }

    public void setCinvdefine1(String cinvdefine1) {
        this.cinvdefine1 = cinvdefine1;
    }

    public String getCinvdefine2() {
        return cinvdefine2;
    }

    public void setCinvdefine2(String cinvdefine2) {
        this.cinvdefine2 = cinvdefine2;
    }

    public String getCinvdefine3() {
        return cinvdefine3;
    }

    public void setCinvdefine3(String cinvdefine3) {
        this.cinvdefine3 = cinvdefine3;
    }

    public String getCinvdefine4() {
        return cinvdefine4;
    }

    public void setCinvdefine4(String cinvdefine4) {
        this.cinvdefine4 = cinvdefine4;
    }

    public String getCinvdefine6() {
        return cinvdefine6;
    }

    public void setCinvdefine6(String cinvdefine6) {
        this.cinvdefine6 = cinvdefine6;
    }

    public String getCinvdefine7() {
        return cinvdefine7;
    }

    public void setCinvdefine7(String cinvdefine7) {
        this.cinvdefine7 = cinvdefine7;
    }

    public String getCinvdefine8() {
        return cinvdefine8;
    }

    public void setCinvdefine8(String cinvdefine8) {
        this.cinvdefine8 = cinvdefine8;
    }

    public String getCinvdefine9() {
        return cinvdefine9;
    }

    public void setCinvdefine9(String cinvdefine9) {
        this.cinvdefine9 = cinvdefine9;
    }

    public String getCinvdefine11() {
        return cinvdefine11;
    }

    public void setCinvdefine11(String cinvdefine11) {
        this.cinvdefine11 = cinvdefine11;
    }

    public BigDecimal getIquantity() {
        return iquantity;
    }

    public void setIquantity(BigDecimal iquantity) {
        this.iquantity = iquantity;
    }

    public BigDecimal getInum() {
        return inum;
    }

    public void setInum(BigDecimal inum) {
        this.inum = inum;
    }

    public String getCcomunitcode() {
        return ccomunitcode;
    }

    public void setCcomunitcode(String ccomunitcode) {
        this.ccomunitcode = ccomunitcode;
    }

    public String getCinvm_unit() {
        return cinvm_unit;
    }

    public void setCinvm_unit(String cinvm_unit) {
        this.cinvm_unit = cinvm_unit;
    }

    public String getCinva_unitcode() {
        return cinva_unitcode;
    }

    public void setCinva_unitcode(String cinva_unitcode) {
        this.cinva_unitcode = cinva_unitcode;
    }

    public String getCinva_unit() {
        return cinva_unit;
    }

    public void setCinva_unit(String cinva_unit) {
        this.cinva_unit = cinva_unit;
    }

    public BigDecimal getIinvexchrate() {
        return iinvexchrate;
    }

    public void setIinvexchrate(BigDecimal iinvexchrate) {
        this.iinvexchrate = iinvexchrate;
    }

    public BigDecimal getIdiffquan() {
        return idiffquan;
    }

    public void setIdiffquan(BigDecimal idiffquan) {
        this.idiffquan = idiffquan;
    }

    public BigDecimal getIdiffnum() {
        return idiffnum;
    }

    public void setIdiffnum(BigDecimal idiffnum) {
        this.idiffnum = idiffnum;
    }

    public BigDecimal getItotalweight() {
        return itotalweight;
    }

    public void setItotalweight(BigDecimal itotalweight) {
        this.itotalweight = itotalweight;
    }

    public BigDecimal getIpricequantity() {
        return ipricequantity;
    }

    public void setIpricequantity(BigDecimal ipricequantity) {
        this.ipricequantity = ipricequantity;
    }

    public String getCpricem_unitcode() {
        return cpricem_unitcode;
    }

    public void setCpricem_unitcode(String cpricem_unitcode) {
        this.cpricem_unitcode = cpricem_unitcode;
    }

    public String getCpricem_unit() {
        return cpricem_unit;
    }

    public void setCpricem_unit(String cpricem_unit) {
        this.cpricem_unit = cpricem_unit;
    }

    public BigDecimal getIpriceexchrate() {
        return ipriceexchrate;
    }

    public void setIpriceexchrate(BigDecimal ipriceexchrate) {
        this.ipriceexchrate = ipriceexchrate;
    }

    public BigDecimal getCdefine26() {
        return cdefine26;
    }

    public void setCdefine26(BigDecimal cdefine26) {
        this.cdefine26 = cdefine26;
    }

    public BigDecimal getCdefine27() {
        return cdefine27;
    }

    public void setCdefine27(BigDecimal cdefine27) {
        this.cdefine27 = cdefine27;
    }

    public String getCdefine28() {
        return cdefine28;
    }

    public void setCdefine28(String cdefine28) {
        this.cdefine28 = cdefine28;
    }

    public String getCdefine29() {
        return cdefine29;
    }

    public void setCdefine29(String cdefine29) {
        this.cdefine29 = cdefine29;
    }

    public String getCdefine35() {
        return cdefine35;
    }

    public void setCdefine35(String cdefine35) {
        this.cdefine35 = cdefine35;
    }

    public String getCbmemo() {
        return cbmemo;
    }

    public void setCbmemo(String cbmemo) {
        this.cbmemo = cbmemo;
    }

    public String getBufts() {
        return bufts;
    }

    public void setBufts(String bufts) {
        this.bufts = bufts;
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

    public String getOwnline() {
        return ownline;
    }

    public void setOwnline(String ownline) {
        this.ownline = ownline;
    }

    public String getCendstationcode() {
        return cendstationcode;
    }

    public void setCendstationcode(String cendstationcode) {
        this.cendstationcode = cendstationcode;
    }

    public String getCendstationname() {
        return cendstationname;
    }

    public void setCendstationname(String cendstationname) {
        this.cendstationname = cendstationname;
    }

    public String getCendstationaddcode() {
        return cendstationaddcode;
    }

    public void setCendstationaddcode(String cendstationaddcode) {
        this.cendstationaddcode = cendstationaddcode;
    }

    public String getCdccode() {
        return cdccode;
    }

    public void setCdccode(String cdccode) {
        this.cdccode = cdccode;
    }

    public String getCdcname() {
        return cdcname;
    }

    public void setCdcname(String cdcname) {
        this.cdcname = cdcname;
    }

    public String getConsigneecode() {
        return consigneecode;
    }

    public void setConsigneecode(String consigneecode) {
        this.consigneecode = consigneecode;
    }

    public String getConsigneename() {
        return consigneename;
    }

    public void setConsigneename(String consigneename) {
        this.consigneename = consigneename;
    }

    public String getConsigneeabbname() {
        return consigneeabbname;
    }

    public void setConsigneeabbname(String consigneeabbname) {
        this.consigneeabbname = consigneeabbname;
    }

    public String getPbtype() {
        return pbtype;
    }

    public void setPbtype(String pbtype) {
        this.pbtype = pbtype;
    }

    public String getPbcode() {
        return pbcode;
    }

    public void setPbcode(String pbcode) {
        this.pbcode = pbcode;
    }

    public String getContainercode() {
        return containercode;
    }

    public void setContainercode(String containercode) {
        this.containercode = containercode;
    }

    public String getPosstate() {
        return posstate;
    }

    public void setPosstate(String posstate) {
        this.posstate = posstate;
    }

    public BigDecimal getIplanpostquantity() {
        return iplanpostquantity;
    }

    public void setIplanpostquantity(BigDecimal iplanpostquantity) {
        this.iplanpostquantity = iplanpostquantity;
    }

    public BigDecimal getIposquantity() {
        return iposquantity;
    }

    public void setIposquantity(BigDecimal iposquantity) {
        this.iposquantity = iposquantity;
    }

    public BigDecimal getYfitotal() {
        return yfitotal;
    }

    public void setYfitotal(BigDecimal yfitotal) {
        this.yfitotal = yfitotal;
    }
}
