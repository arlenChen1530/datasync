package com.proj.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ehsure on 2018/6/25.
 * TransVouchs 调拨单明细
 */
public class RDCToRDCOutDetailDTO implements Serializable {
    private String id;//id
    private String autoId;//autoid
    private String cInvCode;//存货编码(产品编码)
    private BigDecimal  iTVQuantity;//数量
    private String coutposcode;//调出货位
    private String cinposcode;//调入货位
    private String cbMemo;//备注
    private String cdefine22;//汽车号

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

    public BigDecimal getiTVQuantity() {
        return iTVQuantity;
    }

    public void setiTVQuantity(BigDecimal iTVQuantity) {
        this.iTVQuantity = iTVQuantity;
    }

    public String getCoutposcode() {
        return coutposcode;
    }

    public void setCoutposcode(String coutposcode) {
        this.coutposcode = coutposcode;
    }

    public String getCinposcode() {
        return cinposcode;
    }

    public void setCinposcode(String cinposcode) {
        this.cinposcode = cinposcode;
    }

    public String getCbMemo() {
        return cbMemo;
    }

    public void setCbMemo(String cbMemo) {
        this.cbMemo = cbMemo;
    }

    public String getCdefine22() {
        return cdefine22;
    }

    public void setCdefine22(String cdefine22) {
        this.cdefine22 = cdefine22;
    }
}
