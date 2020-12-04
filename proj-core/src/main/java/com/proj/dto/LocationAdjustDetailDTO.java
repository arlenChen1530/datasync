package com.proj.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ehsure on 2018/6/26.
 * 移库明细 AdjustPVouchs
 */
public class LocationAdjustDetailDTO implements Serializable {
    private String id;//id
    private int autoId;//autoid
    private String cInvCode;//存货编码(产品编码)
    private BigDecimal iQuantity;//数量
    private String cBPosCode;//调整前货位
    private String cAPosCode;//调整后货位

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public String getcInvCode() {
        return cInvCode;
    }

    public void setcInvCode(String cInvCode) {
        this.cInvCode = cInvCode;
    }

    public BigDecimal getiQuantity() {
        return iQuantity;
    }

    public void setiQuantity(BigDecimal iQuantity) {
        this.iQuantity = iQuantity;
    }

    public String getcBPosCode() {
        return cBPosCode;
    }

    public void setcBPosCode(String cBPosCode) {
        this.cBPosCode = cBPosCode;
    }

    public String getcAPosCode() {
        return cAPosCode;
    }

    public void setcAPosCode(String cAPosCode) {
        this.cAPosCode = cAPosCode;
    }
}
