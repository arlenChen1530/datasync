package com.proj.dto;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 中啊ERP表头
 */
public class SaleDetailDTO implements Serializable {
    private int id;//ERP的ID
    private int autoid;//autoid
    private String cendstationname;//到站名称
    private String cinvcode;//存货编码
    private String cinvname;//存货名称
    private String consigneename;//收货人
    private BigDecimal iquantity;//拟发数量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public String getCendstationname() {
        return cendstationname;
    }

    public void setCendstationname(String cendstationname) {
        this.cendstationname = cendstationname;
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

    public String getConsigneename() {
        return consigneename;
    }

    public void setConsigneename(String consigneename) {
        this.consigneename = consigneename;
    }

    public BigDecimal getIquantity() {
        return iquantity;
    }

    public void setIquantity(BigDecimal iquantity) {
        this.iquantity = iquantity;
    }
}
