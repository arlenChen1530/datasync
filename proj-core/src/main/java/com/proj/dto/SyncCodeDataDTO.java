package com.proj.dto;


import java.io.Serializable;
import java.util.Date;

/**
 * 生产数据
 */

public class SyncCodeDataDTO implements Serializable {

    private String guid;    //id
    private String Code;    //编码
    private String EptCode;    //积分码
    private String ParentCode;    //上级码
    private String RootCode;    //跟编码
    private String ProductCode;    //产品代码
    private String ProductSKU;    //产品sku
    private String TaskId;    //生产任务单号
    private String CorpCode;    //工厂代码
    private String LineCode;//生产线代码
    private String UniqueBatchCode;
    private String BatchCode; //批号
    private Date PackDate; //生产日期
    private Date ValidDate; //有效期
    private Date PrintDate; //打印日期
    private String DepartCode; //部门代码
    private String TeamCode;//班组代码
    private String WorkerCode; //操作工代码
    private String LineManager;
    private int Level; //级别
    private String VersionCode; //代码规则
    private int Sequence; //
    private int Count; //数量
    private boolean Active; //活动状态
    private String CustomerCode; //客户编码
    private String OrderCode; //订单号码
    private String MaskCode;
    private int DataStatus;
    private String DataMessage;
    private Date ImportDate;
    private String ImportMessage;
    private String ImportStatus;
    private String ExportOrderCode;
    private String ExportLineId;
    private String ExportLineStatus;
    private String ExportStatus; //导入状态
    private Date ExportDate; //导入时间
    private String Memo;
    private boolean IsFormal;
    private boolean IsTrack;
    //添加时间
    private Date AddTime;
    //添加人
    private String AddBy;
    //备用字段
    private String Attrib0;
    //备用字段
    private String Attrib1;
    //备用字段
    private String Attrib2;
    //备用字段
    private String Attrib3;
    //备用字段
    private String Attrib4;
    //备用字段
    private String Attrib5;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getEptCode() {
        return EptCode;
    }

    public void setEptCode(String eptCode) {
        EptCode = eptCode;
    }

    public String getParentCode() {
        return ParentCode;
    }

    public void setParentCode(String parentCode) {
        ParentCode = parentCode;
    }

    public String getRootCode() {
        return RootCode;
    }

    public void setRootCode(String rootCode) {
        RootCode = rootCode;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String productCode) {
        ProductCode = productCode;
    }

    public String getProductSKU() {
        return ProductSKU;
    }

    public void setProductSKU(String productSKU) {
        ProductSKU = productSKU;
    }

    public String getTaskId() {
        return TaskId;
    }

    public void setTaskId(String taskId) {
        TaskId = taskId;
    }

    public String getCorpCode() {
        return CorpCode;
    }

    public void setCorpCode(String corpCode) {
        CorpCode = corpCode;
    }

    public String getLineCode() {
        return LineCode;
    }

    public void setLineCode(String lineCode) {
        LineCode = lineCode;
    }

    public String getUniqueBatchCode() {
        return UniqueBatchCode;
    }

    public void setUniqueBatchCode(String uniqueBatchCode) {
        UniqueBatchCode = uniqueBatchCode;
    }

    public String getBatchCode() {
        return BatchCode;
    }

    public void setBatchCode(String batchCode) {
        BatchCode = batchCode;
    }

    public Date getPackDate() {
        return PackDate;
    }

    public void setPackDate(Date packDate) {
        PackDate = packDate;
    }

    public Date getValidDate() {
        return ValidDate;
    }

    public void setValidDate(Date validDate) {
        ValidDate = validDate;
    }

    public Date getPrintDate() {
        return PrintDate;
    }

    public void setPrintDate(Date printDate) {
        PrintDate = printDate;
    }

    public String getDepartCode() {
        return DepartCode;
    }

    public void setDepartCode(String departCode) {
        DepartCode = departCode;
    }

    public String getTeamCode() {
        return TeamCode;
    }

    public void setTeamCode(String teamCode) {
        TeamCode = teamCode;
    }

    public String getWorkerCode() {
        return WorkerCode;
    }

    public void setWorkerCode(String workerCode) {
        WorkerCode = workerCode;
    }

    public String getLineManager() {
        return LineManager;
    }

    public void setLineManager(String lineManager) {
        LineManager = lineManager;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public String getVersionCode() {
        return VersionCode;
    }

    public void setVersionCode(String versionCode) {
        VersionCode = versionCode;
    }

    public int getSequence() {
        return Sequence;
    }

    public void setSequence(int sequence) {
        Sequence = sequence;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public String getCustomerCode() {
        return CustomerCode;
    }

    public void setCustomerCode(String customerCode) {
        CustomerCode = customerCode;
    }

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
    }

    public String getMaskCode() {
        return MaskCode;
    }

    public void setMaskCode(String maskCode) {
        MaskCode = maskCode;
    }

    public int getDataStatus() {
        return DataStatus;
    }

    public void setDataStatus(int dataStatus) {
        DataStatus = dataStatus;
    }

    public String getDataMessage() {
        return DataMessage;
    }

    public void setDataMessage(String dataMessage) {
        DataMessage = dataMessage;
    }

    public Date getImportDate() {
        return ImportDate;
    }

    public void setImportDate(Date importDate) {
        ImportDate = importDate;
    }

    public String getImportMessage() {
        return ImportMessage;
    }

    public void setImportMessage(String importMessage) {
        ImportMessage = importMessage;
    }

    public String getImportStatus() {
        return ImportStatus;
    }

    public void setImportStatus(String importStatus) {
        ImportStatus = importStatus;
    }

    public String getExportOrderCode() {
        return ExportOrderCode;
    }

    public void setExportOrderCode(String exportOrderCode) {
        ExportOrderCode = exportOrderCode;
    }

    public String getExportLineId() {
        return ExportLineId;
    }

    public void setExportLineId(String exportLineId) {
        ExportLineId = exportLineId;
    }

    public String getExportLineStatus() {
        return ExportLineStatus;
    }

    public void setExportLineStatus(String exportLineStatus) {
        ExportLineStatus = exportLineStatus;
    }

    public String getExportStatus() {
        return ExportStatus;
    }

    public void setExportStatus(String exportStatus) {
        ExportStatus = exportStatus;
    }

    public Date getExportDate() {
        return ExportDate;
    }

    public void setExportDate(Date exportDate) {
        ExportDate = exportDate;
    }

    public String getMemo() {
        return Memo;
    }

    public void setMemo(String memo) {
        Memo = memo;
    }

    public boolean isFormal() {
        return IsFormal;
    }

    public void setFormal(boolean formal) {
        IsFormal = formal;
    }

    public boolean isTrack() {
        return IsTrack;
    }

    public void setTrack(boolean track) {
        IsTrack = track;
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

    public String getAttrib0() {
        return Attrib0;
    }

    public void setAttrib0(String attrib0) {
        Attrib0 = attrib0;
    }

    public String getAttrib1() {
        return Attrib1;
    }

    public void setAttrib1(String attrib1) {
        Attrib1 = attrib1;
    }

    public String getAttrib2() {
        return Attrib2;
    }

    public void setAttrib2(String attrib2) {
        Attrib2 = attrib2;
    }

    public String getAttrib3() {
        return Attrib3;
    }

    public void setAttrib3(String attrib3) {
        Attrib3 = attrib3;
    }

    public String getAttrib4() {
        return Attrib4;
    }

    public void setAttrib4(String attrib4) {
        Attrib4 = attrib4;
    }

    public String getAttrib5() {
        return Attrib5;
    }

    public void setAttrib5(String attrib5) {
        Attrib5 = attrib5;
    }
}
