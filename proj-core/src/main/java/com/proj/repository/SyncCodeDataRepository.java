package com.proj.repository;


import com.ehsure.proj.dto.*;
import com.proj.dto.*;

import java.sql.SQLException;
import java.util.List;

/**
 * @author arlenChen
 */
public interface SyncCodeDataRepository {
    /**
     * 同步 老系统生产数据
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return re
     */
    List<SyncCodeDataDTO> getList(String beginTime, String endTime);

    /**
     * 同步 老系统生产数据
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return re
     */
    List<SyncCartonDTO> getParentCodeList(String beginTime, String endTime);

    /**
     * 根据类型和时间获取单据
     *
     * @param cvouchtype 类型
     * @param beginTime  单据开始时间
     * @param endTime    单据结束时间
     * @return re
     * @throws SQLException SQLException
     */
    List<OldErpHeaderDTO> getHeaderList(String cvouchtype, String beginTime, String endTime) throws SQLException;

    /**
     * 根据id集合获取对应的明显
     *
     * @param id id集合
     * @return return
     * @throws SQLException SQLException
     */
    List<OldErpDetailDTO> getDetailList(String[] id) throws SQLException;

    /**
     * 根据仓库编码和时间获取调拨单单据
     *
     * @param cOWhCode  调出仓库编码
     * @param cIWhCode  调入仓库编码
     * @param beginTime 单据开始时间
     * @param endTime   单据结束时间
     * @param cInvCode  存库编码
     * @return re
     */
    List<RDCToRDCOutHeaderDTO> getRDCToRDCOutHeaderList(String[] cOWhCode, String[] cIWhCode, String beginTime, String endTime, String[] cInvCode) throws SQLException;

    /**
     * 根据调拨单单据ID获取单据明细
     *
     * @param id       单据ID
     * @param cInvCode 存库编码
     * @return re
     */
    List<RDCToRDCOutDetailDTO> getRDCToRDCOutDetailList(String[] id, String[] cInvCode) throws SQLException;


    /**
     * 根据仓库编码和时间获取其他出库单单据
     *
     * @param cOWhCode  仓库编码
     * @param beginTime 单据开始时间
     * @param endTime   单据结束时间
     * @param cRdCode   出库类别
     * @param cInvCode  货位编码
     * @return re
     */
    List<RDCToOtherDealerOutHeaderDTO> getRDCToOtherDealerOutHeaderList(String[] cOWhCode, String[] cRdCode, String beginTime, String endTime, String[] cInvCode) throws SQLException;


    /**
     * 根据其他出库单单据ID获取单据明细
     *
     * @param id       单据ID
     * @param cInvCode 存库编码
     * @return re
     */
    List<RDCToOtherDealerOutDetailDTO> getRDCToOtherDealerOutDetailList(String[] id, String[] cInvCode) throws SQLException;


    /**
     * 根据仓库编码和时间获取移库单单据
     *
     * @param cOWhCode  仓库编码
     * @param beginTime 单据开始时间
     * @param endTime   单据结束时间
     * @return re
     */
    List<LocationAdjustHeaderDTO> getLocationAdjustHeaderList(String[] cOWhCode, String beginTime, String endTime, String[] cInvCode) throws SQLException;

    /**
     * 根据移库单单据ID获取单据明细
     *
     * @param id 单据ID
     * @return re
     */
    List<LocationAdjustDetailDTO> getLocationAdjustDetailList(String[] id, String[] cInvCode) throws SQLException;

    /**
     * 获取任务单单头
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return return
     */
    List<PackPlanHeaderDTO> getPackPlanHeaderList(String beginTime, String endTime);

    /**
     * 获取任务单单头
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return return
     */
    List<ProductPlanHeaderDTO> getProductPlanList(String beginTime, String endTime);

    /**
     * 同步发货扫码信息
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return re
     */
    List<SSODataDTO> syncBillData(String beginTime, String endTime);

    /**
     * 获取任务单明细
     *
     * @param ordCode 任务单号
     * @return return
     */
    List<PackPlanDetailDTO> getPackPlanDetailDTOList(String ordCode) throws SQLException;

    /**
     * 同步入库登记记录
     *
     * @param syncRegisterStr 同步数据
     * @return re
     */
    String syncRegister(String syncRegisterStr) throws SQLException;

    /**
     * 根据仓库编码和时间获取移库单单据
     *
     * @param beginTime 单据开始时间
     * @param endTime   单据结束时间
     * @return re
     */
    List<SaleHeaderDTO> getSaleOrderHeaderList(String beginTime, String endTime) throws SQLException;

    /**
     * 根据移库单单据ID获取单据明细
     *
     * @param id 单据ID
     * @return re
     */
    List<SaleDetailDTO> getSaleOrderDetailList(String[] id) throws SQLException;
    /**
     * 获取所有的物料信息
     *
     * @return re
     */
    List<SyncMaterialDTO> getMaterialList() throws SQLException;
}