package com.proj.dto;

import com.ehsure.eaf.core.dto.BaseDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ehsure on 2018/7/23.
 * 包装入库登记明细
 */
public class PackInRegisterDetailDTO extends BaseDTO {
    private String id;
    private String headerId;//单据头id
    private Date operateTime;//单据日期
    private String crdtype;//类型
    private String cwhcode;//仓库编码
    private String teamCode;//班组号
    private String materialId;//产品ID
    private String materialSku;//产品sku
    private String materialShortName;//产品简称
    private String materialFullName;//产品全称
    private String locationId;//货位ID
    private String locationCode;//货位好号
    private String locationName;//货位名称
    private BigDecimal qty;//入库数量

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaterialSku() {
        return materialSku;
    }

    public void setMaterialSku(String materialSku) {
        this.materialSku = materialSku;
    }

    public String getMaterialShortName() {
        return materialShortName;
    }

    public void setMaterialShortName(String materialShortName) {
        this.materialShortName = materialShortName;
    }

    public String getMaterialFullName() {
        return materialFullName;
    }

    public void setMaterialFullName(String materialFullName) {
        this.materialFullName = materialFullName;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getHeaderId() {
        return headerId;
    }

    public void setHeaderId(String headerId) {
        this.headerId = headerId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getCrdtype() {
        return crdtype;
    }

    public void setCrdtype(String crdtype) {
        this.crdtype = crdtype;
    }

    public String getCwhcode() {
        return cwhcode;
    }

    public void setCwhcode(String cwhcode) {
        this.cwhcode = cwhcode;
    }
}
