package com.proj.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ehsure on 2018/8/16.
 * 发货扫码信息
 */
public class SSODataDTO implements Serializable {
    private String CustStoreName; //收货人
    private String CustName; //收货仓库
    private Date OpDate; //发货时间
    private String Id;//ID
    private String DetailId; //明细ID
    private BigDecimal Qty;//袋数
    private Date AddTime;//添加时间
    private String AddBy;//添加人
    private String PackCode;//虚拟托盘码
    private String Code; //事物托盘码
    private String ProductSKU;//产品sku
    private String BatchCode;//批次

    public String getCustStoreName() {
        return CustStoreName;
    }

    public void setCustStoreName(String custStoreName) {
        CustStoreName = custStoreName;
    }

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String custName) {
        CustName = custName;
    }

    public Date getOpDate() {
        return OpDate;
    }

    public void setOpDate(Date opDate) {
        OpDate = opDate;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDetailId() {
        return DetailId;
    }

    public void setDetailId(String detailId) {
        DetailId = detailId;
    }

    public BigDecimal getQty() {
        return Qty;
    }

    public void setQty(BigDecimal qty) {
        Qty = qty;
    }

    public Date getAddTime() {
        return AddTime;
    }

    public void setAddTime(Date addTime) {
        AddTime = addTime;
    }

    public String getAddBy() {
        return AddBy;
    }

    public void setAddBy(String addBy) {
        AddBy = addBy;
    }

    public String getPackCode() {
        return PackCode;
    }

    public void setPackCode(String packCode) {
        PackCode = packCode;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getProductSKU() {
        return ProductSKU;
    }

    public void setProductSKU(String productSKU) {
        ProductSKU = productSKU;
    }

    public String getBatchCode() {
        return BatchCode;
    }

    public void setBatchCode(String batchCode) {
        BatchCode = batchCode;
    }
}
