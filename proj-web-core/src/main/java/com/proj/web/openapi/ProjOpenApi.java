package com.proj.web.openapi;

import com.proj.appservice.SyncCodeDataAppService;
import com.ehsure.proj.dto.*;
import com.proj.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author arlenChen
 */
@Controller
@RequestMapping(value = "/openapi/proj/sync")
public class ProjOpenApi {
    private static Logger logger = LoggerFactory.getLogger(ProjOpenApi.class);
    @Resource
    private SyncCodeDataAppService appService;

    @RequestMapping(value = "getList")
    @ResponseBody
    public List<SyncCodeDataDTO> getList(String beginTime, String endTime) {
        List<SyncCodeDataDTO> list = appService.getList(beginTime, endTime);
        return list;
    }

    @RequestMapping(value = "getParentCodeList")
    @ResponseBody
    public List<SyncCartonDTO> getParentCodeList(String beginTime, String endTime) {
        List<SyncCartonDTO> list = appService.getParentCodeList(beginTime, endTime);
        return list;
    }

    /**
     * 根据类型和时间获取单据
     *
     * @param cvouchtype 类型
     * @param beginTime  单据开始时间
     * @param endTime    单据结束时间
     * @return re
     */
    @RequestMapping(value = "getHeaderList")
    @ResponseBody
    public List<OldErpHeaderDTO> getHeaderList(String cvouchtype, String beginTime, String endTime) {
        List<OldErpHeaderDTO> list = new ArrayList<>();
        try {
            list = appService.getHeaderList(cvouchtype, beginTime, endTime);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    @RequestMapping(value = "getDetailList")
    @ResponseBody
    public List<OldErpDetailDTO> getDetailList(String[] id) {
        List<OldErpDetailDTO> list = new ArrayList<>();
        try {
            list = appService.getDetailList(id);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
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
    @RequestMapping(value = "getRDCToRDCOutHeaderList")
    @ResponseBody
    public List<RDCToRDCOutHeaderDTO> getRDCToRDCOutHeaderList(String[] cOWhCode, String[] cIWhCode, String beginTime, String endTime, String[] cInvCode) {
        List<RDCToRDCOutHeaderDTO> list = new ArrayList<>();
        try {
            list = appService.getRDCToRDCOutHeaderList(cOWhCode, cIWhCode, beginTime, endTime, cInvCode);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    /**
     * 根据调拨单单据ID获取单据明细
     *
     * @param id       单据ID
     * @param cInvCode 存库编码
     * @return re
     */
    @RequestMapping(value = "getRDCToRDCOutDetailList")
    @ResponseBody
    public List<RDCToRDCOutDetailDTO> getRDCToRDCOutDetailList(String[] id, String[] cInvCode) {
        List<RDCToRDCOutDetailDTO> list = new ArrayList<>();
        try {
            list = appService.getRDCToRDCOutDetailList(id, cInvCode);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
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
    @RequestMapping(value = "getRDCToOtherDealerOutHeaderList")
    @ResponseBody
    public List<RDCToOtherDealerOutHeaderDTO> getRDCToOtherDealerOutHeaderList(String[] cOWhCode, String[] cRdCode, String beginTime, String endTime, String[] cInvCode) {
        List<RDCToOtherDealerOutHeaderDTO> list = new ArrayList<>();
        try {
            list = appService.getRDCToOtherDealerOutHeaderList(cOWhCode, cRdCode, beginTime, endTime, cInvCode);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    /**
     * 根据其他出库单单据ID获取单据明细
     *
     * @param id       单据ID
     * @param cInvCode 存库编码
     * @return re
     */
    @RequestMapping(value = "getRDCToOtherDealerOutDetailList")
    @ResponseBody
    public List<RDCToOtherDealerOutDetailDTO> getRDCToOtherDealerOutDetailList(String[] id, String[] cInvCode) {
        List<RDCToOtherDealerOutDetailDTO> list = new ArrayList<>();
        try {
            list = appService.getRDCToOtherDealerOutDetailList(id, cInvCode);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    /**
     * 根据仓库编码和时间获取移库单单据
     *
     * @param cOWhCode  仓库编码
     * @param beginTime 单据开始时间
     * @param endTime   单据结束时间
     * @return re
     */
    @RequestMapping(value = "getLocationAdjustHeaderList")
    @ResponseBody
    public List<LocationAdjustHeaderDTO> getLocationAdjustHeaderList(String[] cOWhCode, String beginTime, String endTime, String[] cInvCode) {
        List<LocationAdjustHeaderDTO> list = new ArrayList<>();
        try {
            list = appService.getLocationAdjustHeaderList(cOWhCode, beginTime, endTime, cInvCode);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    /**
     * 根据移库单单据ID获取单据明细
     *
     * @param id 单据ID
     * @return re
     */
    @RequestMapping(value = "getLocationAdjustDetailList")
    @ResponseBody
    public List<LocationAdjustDetailDTO> getLocationAdjustDetailList(String[] id, String[] cInvCode) {
        List<LocationAdjustDetailDTO> list = new ArrayList<>();
        try {
            list = appService.getLocationAdjustDetailList(id, cInvCode);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    /**
     * 根据添加时间获取任务单
     *
     * @param beginTime 单据开始时间
     * @param endTime   单据结束时间
     * @return re
     */
    @RequestMapping(value = "getPackPlanList")
    @ResponseBody
    public List<PackPlanHeaderDTO> getPackPlanList(String beginTime, String endTime) {
        List<PackPlanHeaderDTO> list = new ArrayList<>();
        try {
            list = appService.getPackPlanList(beginTime, endTime);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    /**
     * 根据添加时间获取任务单
     *
     * @param beginTime 单据开始时间
     * @param endTime   单据结束时间
     * @return re
     */
    @RequestMapping(value = "getProductPlanList")
    @ResponseBody
    public List<ProductPlanHeaderDTO> getProductPlanList(String beginTime, String endTime) {
        List<ProductPlanHeaderDTO> list = new ArrayList<>();
        try {
            list = appService.getProductPlanList(beginTime, endTime);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    /**
     * 同步发货扫码信息
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return re
     */
    @RequestMapping(value = "syncBillData")
    @ResponseBody
    public List<SSODataDTO> syncBillData(String beginTime, String endTime) {
        List<SSODataDTO> list = new ArrayList<>();
        try {
            list = appService.syncBillData(beginTime, endTime);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    /**
     * 同步入库登记记录
     *
     * @param syncRegisterStr 同步数据
     * @return re
     */
    @RequestMapping(value = "syncRegister")
    @ResponseBody
    public String syncRegister(String syncRegisterStr) {
        logger.info("同步入库登记记录:" + syncRegisterStr);
        System.out.println(syncRegisterStr);
        String result = "";
        try {
            result = appService.syncRegister(syncRegisterStr);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return result;
    }

    /**
     * 根据销售类型和时间获取商业库单据数据
     *
     * @param beginTime 单据开始时间
     * @param endTime   单据结束时间
     * @return re
     */
    @RequestMapping(value = "getSaleOrderHeaderList")
    @ResponseBody
    public List<SaleHeaderDTO> getSaleOrderHeaderList(String beginTime, String endTime) {
        List<SaleHeaderDTO> list = new ArrayList<>();
        try {
            list = appService.getSaleOrderHeaderList(beginTime, endTime);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    /**
     * 根据商业库单据数据ID获取单据明细
     * SaleOrder
     *
     * @param id 单据ID
     * @return re
     */
    @RequestMapping(value = "getSaleOrderDetailList")
    @ResponseBody
    public List<SaleDetailDTO> getSaleOrderDetailList(String[] id) {
        List<SaleDetailDTO> list = new ArrayList<>();
        try {
            list = appService.getSaleOrderDetailList(id);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    /**
     * 获取所有的物料信息
     *
     * @return re
     */
    @RequestMapping(value = "getMaterialList")
    @ResponseBody
    public List<SyncMaterialDTO> getMaterialList() {
        List<SyncMaterialDTO> list = new ArrayList<>();
        try {
            list = appService.getMaterialList();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

}
