package com.proj.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ehsure on 2018/7/17.
 * 计划单
 */
public class ProductPlanHeaderDTO implements Serializable {
    private String id;
    private String guid;
    private String code;
    private String orderStatus;
    private String productSKU;
    private String productName;
    private String teamCode;
    private BigDecimal expectQty;
    private String comment;
    private String addBy;
    private Date addTime;
    private String editBy;
    private Date editTime;
    private Date auditDate;
    private String auditor;
    private String attrib1;
    private String attrib2;
    private String attrib3;
    private String attrib4;
    private String attrib5;
    private BigDecimal qty1;
    private BigDecimal qty2;
    private BigDecimal qty3;
    private BigDecimal qty4;
    private BigDecimal qty5;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getProductSKU() {
        return productSKU;
    }

    public void setProductSKU(String productSKU) {
        this.productSKU = productSKU;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public BigDecimal getExpectQty() {
        return expectQty;
    }

    public void setExpectQty(BigDecimal expectQty) {
        this.expectQty = expectQty;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAddBy() {
        return addBy;
    }

    public void setAddBy(String addBy) {
        this.addBy = addBy;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getAttrib1() {
        return attrib1;
    }

    public void setAttrib1(String attrib1) {
        this.attrib1 = attrib1;
    }

    public String getAttrib2() {
        return attrib2;
    }

    public void setAttrib2(String attrib2) {
        this.attrib2 = attrib2;
    }

    public String getAttrib3() {
        return attrib3;
    }

    public void setAttrib3(String attrib3) {
        this.attrib3 = attrib3;
    }

    public String getAttrib4() {
        return attrib4;
    }

    public void setAttrib4(String attrib4) {
        this.attrib4 = attrib4;
    }

    public String getAttrib5() {
        return attrib5;
    }

    public void setAttrib5(String attrib5) {
        this.attrib5 = attrib5;
    }

    public BigDecimal getQty1() {
        return qty1;
    }

    public void setQty1(BigDecimal qty1) {
        this.qty1 = qty1;
    }

    public BigDecimal getQty2() {
        return qty2;
    }

    public void setQty2(BigDecimal qty2) {
        this.qty2 = qty2;
    }

    public BigDecimal getQty3() {
        return qty3;
    }

    public void setQty3(BigDecimal qty3) {
        this.qty3 = qty3;
    }

    public BigDecimal getQty4() {
        return qty4;
    }

    public void setQty4(BigDecimal qty4) {
        this.qty4 = qty4;
    }

    public BigDecimal getQty5() {
        return qty5;
    }

    public void setQty5(BigDecimal qty5) {
        this.qty5 = qty5;
    }
}
