package com.proj.appservice.impl;

import com.ehsure.eaf.core.utils.StringUtil;
import com.proj.appservice.SyncCodeDataAppService;
import com.ehsure.proj.dto.*;
import com.proj.repository.SyncCodeDataRepository;
import com.proj.dto.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author arlenChen
 */
@Service
public class SyncCodeDataAppServiceImpl implements SyncCodeDataAppService {
    @Resource
    private SyncCodeDataRepository repository;

    /**
     * 同步 老系统生产数据
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return re
     */
    @Override
    public List<SyncCodeDataDTO> getList(String beginTime, String endTime) {
        return repository.getList(beginTime, endTime);
    }

    /**
     * 同步 老系统生产数据
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return re
     */
    @Override
    public List<SyncCartonDTO> getParentCodeList(String beginTime, String endTime) {
        return  repository.getParentCodeList(beginTime, endTime);
    }

    /**
     * 根据类型和时间获取单据
     *
     * @param cvouchtype 类型
     * @param beginTime  单据开始时间
     * @param endTime    单据结束时间
     * @return re
     * @throws SQLException SQLException
     */
    @Override
    public List<OldErpHeaderDTO> getHeaderList(String cvouchtype, String beginTime, String endTime) throws SQLException {
        String billType = "";
        switch (cvouchtype) {
            case "RailRDCToDealerOut":
                billType = "铁运发货运输清单";
                break;
            case "CarRDCToDealerOut":
                billType = "发货运输清单";
                break;
            case "ShipRDCToDealerOut":
                billType = "船运发货运输清单";
                break;
                default:
                    break;
        }
        return repository.getHeaderList(billType, beginTime, endTime);
    }

    /**
     * 根据id集合获取对应的明显
     *
     * @param id id集合
     * @return return
     * @throws SQLException SQLException
     */
    @Override
    public List<OldErpDetailDTO> getDetailList(String[] id) throws SQLException {
        return repository.getDetailList(id);
    }

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
    @Override
    public List<RDCToRDCOutHeaderDTO> getRDCToRDCOutHeaderList(String[] cOWhCode, String[] cIWhCode, String beginTime, String endTime, String[] cInvCode) throws SQLException {
        return  repository.getRDCToRDCOutHeaderList(cOWhCode, cIWhCode, beginTime, endTime, cInvCode);
    }

    /**
     * 根据调拨单单据ID获取单据明细
     *
     * @param id       单据ID
     * @param cInvCode 存库编码
     * @return re
     */
    @Override
    public List<RDCToRDCOutDetailDTO> getRDCToRDCOutDetailList(String[] id, String[] cInvCode) throws SQLException {
        return repository.getRDCToRDCOutDetailList(id, cInvCode);
    }

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
    @Override
    public List<RDCToOtherDealerOutHeaderDTO> getRDCToOtherDealerOutHeaderList(String[] cOWhCode, String[] cRdCode, String beginTime, String endTime, String[] cInvCode) throws SQLException {
        return repository.getRDCToOtherDealerOutHeaderList(cOWhCode, cRdCode, beginTime, endTime, cInvCode);
    }

    /**
     * 根据其他出库单单据ID获取单据明细
     *
     * @param id       单据ID
     * @param cInvCode 存库编码
     * @return re
     */
    @Override
    public List<RDCToOtherDealerOutDetailDTO> getRDCToOtherDealerOutDetailList(String[] id, String[] cInvCode) throws SQLException {
        return repository.getRDCToOtherDealerOutDetailList(id, cInvCode);
    }

    /**
     * 根据仓库编码和时间获取移库单单据
     *
     * @param cOWhCode  仓库编码
     * @param beginTime 单据开始时间
     * @param endTime   单据结束时间
     * @return re
     */
    @Override
    public List<LocationAdjustHeaderDTO> getLocationAdjustHeaderList(String[] cOWhCode, String beginTime, String endTime, String[] cInvCode) throws SQLException {
        return repository.getLocationAdjustHeaderList(cOWhCode, beginTime, endTime, cInvCode);
    }

    /**
     * 根据移库单单据ID获取单据明细
     *
     * @param id 单据ID
     * @return re
     */
    @Override
    public List<LocationAdjustDetailDTO> getLocationAdjustDetailList(String[] id, String[] cInvCode) throws SQLException {
        return  repository.getLocationAdjustDetailList(id, cInvCode);
    }

    /**
     * 同步 老系统任务单
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return re
     */
    @Override
    public List<PackPlanHeaderDTO> getPackPlanList(String beginTime, String endTime) throws SQLException {
        List<PackPlanHeaderDTO> headerDTOList = repository.getPackPlanHeaderList(beginTime, endTime);
        for (PackPlanHeaderDTO headerDTO : headerDTOList) {
            if (StringUtil.isNotEmpty(headerDTO.getCode())) {
                List<PackPlanDetailDTO> detailList = repository.getPackPlanDetailDTOList(headerDTO.getCode());
                headerDTO.setDetailList(detailList);
            }
        }
        return headerDTOList;
    }

    /**
     * 同步 老系统任务单
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return re
     */
    @Override
    public List<ProductPlanHeaderDTO> getProductPlanList(String beginTime, String endTime) throws SQLException {
        return  repository.getProductPlanList(beginTime, endTime);
    }

    /**
     * 同步发货扫码信息
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return re
     */
    @Override
    public List<SSODataDTO> syncBillData(String beginTime, String endTime) throws SQLException {
        return repository.syncBillData(beginTime, endTime);
    }

    /**
     * 同步入库登记记录
     *
     * @param syncRegisterStr 同步数据
     * @return re
     */
    @Override
    public String syncRegister(String syncRegisterStr) throws SQLException {
        return repository.syncRegister(syncRegisterStr);
    }

    /**
     * 根据仓库编码和时间获取移库单单据
     *
     * @param beginTime 单据开始时间
     * @param endTime   单据结束时间
     * @return re
     */
    @Override
    public List<SaleHeaderDTO> getSaleOrderHeaderList(String beginTime, String endTime) throws SQLException {
        return  repository.getSaleOrderHeaderList(beginTime, endTime);
    }

    /**
     * 根据移库单单据ID获取单据明细
     *
     * @param id 单据ID
     * @return re
     */
    @Override
    public List<SaleDetailDTO> getSaleOrderDetailList(String[] id) throws SQLException {
        return repository.getSaleOrderDetailList(id);
    }

    /**
     * 获取所有的物料信息
     *
     * @return re
     */
    @Override
    public List<SyncMaterialDTO> getMaterialList() throws SQLException {
        return repository.getMaterialList();
    }
}
