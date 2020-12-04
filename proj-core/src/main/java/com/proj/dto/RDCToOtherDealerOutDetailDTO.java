package com.proj.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ehsure on 2018/6/26.
 * 其他出库单明细 rdrecords09
 */
public class RDCToOtherDealerOutDetailDTO implements Serializable {
    private String id;//id
    private String autoId;//autoId
    private String cInvCode;//存货编码(产品编码)
    private BigDecimal iQuantity;//数量
    private String cPosition;//货位

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
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

    public String getcPosition() {
        return cPosition;
    }

    public void setcPosition(String cPosition) {
        this.cPosition = cPosition;
    }
}
