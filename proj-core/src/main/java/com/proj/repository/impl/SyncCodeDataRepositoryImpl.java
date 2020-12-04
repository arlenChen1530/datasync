package com.proj.repository.impl;

import com.alibaba.fastjson.JSONArray;
import com.ehsure.eaf.core.repository.jpa.BaseHibernateRepository;
import com.ehsure.eaf.core.utils.StringUtil;
import com.ehsure.proj.dto.*;
import com.proj.repository.SyncCodeDataRepository;
import com.proj.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author arlenChen
 */
@Repository
public class SyncCodeDataRepositoryImpl extends BaseHibernateRepository implements SyncCodeDataRepository {
    private static Logger logger = LoggerFactory.getLogger(SyncCodeDataRepositoryImpl.class);

    @Resource(name = "sysProperties")
    private Properties sysProperties;

    /**
     * 同步 老系统生产数据
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return re
     */
    @Override
    public List<SyncCodeDataDTO> getList(String beginTime, String endTime) {
        String hql = "select  top 20000 * from SyncCodeData  with(noLock) where   addTime >:beginTime and addTime <=:endTime order by addTime asc ";
        Map<String, Object> map = new HashMap<>();
        map.put("beginTime", beginTime);
        map.put("endTime", endTime);
        return findAllResutlBeansBySql(hql, map, SyncCodeDataDTO.class);
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
        String hql = "select  top 20000  * from SyncCarton with(noLock)  where   addTime >:beginTime and addTime <=:endTime order by addTime  asc  ";
        Map<String, Object> map = new HashMap<>();
        map.put("beginTime", beginTime);
        map.put("endTime", endTime);
        return findAllResutlBeansBySql(hql, map, SyncCartonDTO.class);
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
        Connection conn = getConnection();
        if (conn == null) {
            throw new RuntimeException("与数据库连接失败！");
        } else {
            String sql = " select  id, ccode  ,cvouchtype,cplanvouchtype,csotype,ctransvencode,ctransvenanme,vensettletype,billdate,cdepcode,cdepname, " +
                    " ccuscode,ccusname,ccusabbname,csccode,cscname,ctfcode,ctfname,cttcode,cttname,ctlcode,ctlname,btotalwei, " +
                    " ipricequan,cstate,cmaker,verify,verifydate,csend,ivtid,ufts " +
                    " from V_hy_eo_transporth  where cvouchtype = ? and billdate > = ?  and billdate <?  ";
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, cvouchtype);
                ps.setString(2, beginTime);
                ps.setString(3, endTime);
                rs = ps.executeQuery();
                List<OldErpHeaderDTO> dtoList = new ArrayList<>();
                while (rs.next()) {
                    OldErpHeaderDTO dto = new OldErpHeaderDTO();
                    //ERP的ID
                    dto.setId(rs.getString("id"));
                    String ccode = rs.getString("ccode");
                    //单据号
                    dto.setCcode(ccode);
                    dto.setCvouchtype(rs.getString("cvouchtype"));
                    dto.setCplanvouchtype(rs.getString("cplanvouchtype"));
                    dto.setCsotype(rs.getString("csotype"));
                    dto.setCtransvencode(rs.getString("ctransvencode"));
                    dto.setCtransvenanme(rs.getString("ctransvenanme"));
                    dto.setVensettletype(rs.getString("vensettletype"));
                    //单据日期
                    dto.setBilldate(rs.getDate("billdate"));
                    //部门代码
                    dto.setCdepcode(rs.getString("cdepcode"));
                    //部门名称
                    dto.setCdepname(rs.getString("cdepname"));
                    dto.setCcuscode(rs.getString("ccuscode"));
                    dto.setCcusname(rs.getString("ccusname"));
                    dto.setCcusabbname(rs.getString("ccusabbname"));
                    dto.setCsccode(rs.getString("csccode"));
                    //发运方式
                    dto.setCscname(rs.getString("cscname"));
                    dto.setCtfcode(rs.getString("ctfcode"));
                    dto.setCtfname(rs.getString("ctfname"));
                    dto.setCttcode(rs.getString("cttcode"));
                    dto.setCttname(rs.getString("cttname"));
                    dto.setCtlcode(rs.getString("ctlcode"));
                    dto.setCtlname(rs.getString("ctlname"));
                    dto.setBtotalwei(rs.getString("btotalwei"));
                    dto.setIpricequan(rs.getString("ipricequan"));
                    dto.setCstate(rs.getString("cstate"));
                    //创建人
                    dto.setCmaker(rs.getString("cmaker"));
                    //审核人
                    dto.setVerify(rs.getString("verify"));
                    //审核时间
                    dto.setVerifydate(rs.getDate("verifydate"));
                    dto.setCsend(rs.getString("csend"));
                    dto.setIvtid(rs.getString("ivtid"));
                    dto.setUfts(rs.getBigDecimal("ufts"));
                    dtoList.add(dto);
                }
                if (dtoList.isEmpty()) {
                    logger.info("没有查询到数据");
                }
                return dtoList;
            } finally {
                conn.close();
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }
        }
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
        Connection conn = getConnection();
        if (conn == null) {
            throw new RuntimeException("与数据库连接失败！");
        } else {
            StringBuilder ids = new StringBuilder("");
            for (String s : id) {
                if (StringUtil.isEmpty(ids.toString())) {
                    ids.append("'").append(s).append("'");
                } else {
                    ids.append(",'").append(s).append("'");
                }
            }
            String sql = " select  id,autoid,cplancode,autoidplan,cvouchtype,csotype,csoid,csocode,wagoncode, " +
                    " billcode,cdepcode,cdepname,cpersoncode,cpersonname,ccuscode,ccusname,ccusabbname,ccusdefine1,csoautoid, " +
                    " cinvcode,cinvname,cinvstd,cinvdefine1,cinvdefine2,cinvdefine3,cinvdefine4,cinvdefine6, " +
                    " cinvdefine7,cinvdefine8,cinvdefine9,cinvdefine11,iquantity,inum,ccomunitcode,cinvm_unit,cinva_unitcode,cinva_unit,iinvexchrate,idiffquan, " +
                    " idiffnum,itotalweight,ipricequantity,cpricem_unitcode,cpricem_unit,ipriceexchrate,cdefine26,cdefine27,cdefine28,cdefine29, " +
                    " cdefine35,cbmemo,bufts,ctlcode,ctlname,ownline,cendstationcode,cendstationname,cendstationaddcode,cdccode,cdcname,consigneecode,consigneename,consigneeabbname, " +
                    " pbtype,pbcode,containercode,posstate,iplanpostquantity,iposquantity,yfitotal   " +
                    " from V_hy_eo_transportb     where id IN  ( " + ids.toString() + ") ";
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                List<OldErpDetailDTO> dtoList = new ArrayList<>();
                while (rs.next()) {
                    OldErpDetailDTO dto = new OldErpDetailDTO();
                    dto.setId(rs.getString("id"));
                    dto.setAutoid(rs.getString("autoid"));
                    dto.setCplancode(rs.getString("cplancode"));
                    dto.setAutoidplan(rs.getString("autoidplan"));
                    dto.setCvouchtype(rs.getString("cvouchtype"));
                    dto.setCsotype(rs.getString("csotype"));
                    dto.setCsoid(rs.getString("csoid"));
                    dto.setCsocode(rs.getString("csocode"));
                    dto.setWagoncode(rs.getString("wagoncode"));
                    dto.setBillcode(rs.getString("billcode"));
                    dto.setCdepcode(rs.getString("cdepcode"));
                    dto.setCdepname(rs.getString("cdepname"));
                    dto.setCpersoncode(rs.getString("cpersoncode"));
                    dto.setCpersonname(rs.getString("cpersonname"));
                    dto.setCcuscode(rs.getString("ccuscode"));
                    dto.setCcusname(rs.getString("ccusname"));
                    dto.setCcusabbname(rs.getString("ccusabbname"));
                    dto.setCcusdefine1(rs.getString("ccusdefine1"));
                    dto.setCsoautoid(rs.getString("csoautoid"));
                    dto.setCinvcode(rs.getString("cinvcode"));
                    dto.setCinvname(rs.getString("cinvname"));
                    dto.setCinvstd(rs.getString("cinvstd"));
                    dto.setCinvdefine1(rs.getString("cinvdefine1"));
                    dto.setCinvdefine2(rs.getString("cinvdefine2"));
                    dto.setCinvdefine3(rs.getString("cinvdefine3"));
                    dto.setCinvdefine4(rs.getString("cinvdefine4"));
                    dto.setCinvdefine6(rs.getString("cinvdefine6"));
                    dto.setCinvdefine7(rs.getString("cinvdefine7"));
                    dto.setCinvdefine8(rs.getString("cinvdefine8"));
                    dto.setCinvdefine9(rs.getString("cinvdefine9"));
                    dto.setCinvdefine11(rs.getString("cinvdefine11"));
                    dto.setIquantity(rs.getBigDecimal("iquantity"));
                    dto.setInum(rs.getBigDecimal("inum"));
                    dto.setCcomunitcode(rs.getString("ccomunitcode"));
                    dto.setCinvm_unit(rs.getString("cinvm_unit"));
                    dto.setCinva_unitcode(rs.getString("cinva_unitcode"));
                    dto.setCinva_unit(rs.getString("cinva_unit"));
                    dto.setIinvexchrate(rs.getBigDecimal("iinvexchrate"));
                    dto.setIdiffquan(rs.getBigDecimal("idiffquan"));
                    dto.setIdiffnum(rs.getBigDecimal("idiffnum"));
                    dto.setItotalweight(rs.getBigDecimal("itotalweight"));
                    dto.setIpricequantity(rs.getBigDecimal("ipricequantity"));
                    dto.setCpricem_unitcode(rs.getString("cpricem_unitcode"));
                    dto.setCpricem_unit(rs.getString("cpricem_unit"));
                    dto.setIpriceexchrate(rs.getBigDecimal("ipriceexchrate"));
                    dto.setCdefine26(rs.getBigDecimal("cdefine26"));
                    dto.setCdefine27(rs.getBigDecimal("cdefine27"));
                    dto.setCdefine28(rs.getString("cdefine28"));
                    dto.setCdefine29(rs.getString("cdefine29"));
                    dto.setCdefine35(rs.getString("cdefine35"));
                    dto.setCbmemo(rs.getString("cbmemo"));
                    dto.setBufts(rs.getString("bufts"));
                    dto.setCtlcode(rs.getString("ctlcode"));
                    dto.setCtlname(rs.getString("ctlname"));
                    dto.setOwnline(rs.getString("ownline"));
                    dto.setCendstationcode(rs.getString("cendstationcode"));
                    dto.setCendstationname(rs.getString("cendstationname"));
                    dto.setCendstationaddcode(rs.getString("cendstationaddcode"));
                    dto.setCdccode(rs.getString("cdccode"));
                    dto.setCdcname(rs.getString("cdcname"));
                    dto.setConsigneecode(rs.getString("consigneecode"));
                    dto.setConsigneename(rs.getString("consigneename"));
                    dto.setConsigneeabbname(rs.getString("consigneeabbname"));
                    dto.setPbtype(rs.getString("pbtype"));
                    dto.setPbcode(rs.getString("pbcode"));
                    dto.setContainercode(rs.getString("containercode"));
                    dto.setPosstate(rs.getString("posstate"));
                    dto.setIplanpostquantity(rs.getBigDecimal("iplanpostquantity"));
                    dto.setIposquantity(rs.getBigDecimal("iposquantity"));
                    dto.setYfitotal(rs.getBigDecimal("yfitotal"));
                    dtoList.add(dto);
                }
                if (dtoList.size() == 0) {
                    logger.info("没有查询到数据");
                }
                return dtoList;
            } finally {
                conn.close();
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }
        }
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
        Connection conn = getConnection();
        if (conn == null) {
            throw new RuntimeException("与数据库连接失败！");
        } else {
            StringBuilder srcIds = new StringBuilder("");
            //发货方
            for (String s : cOWhCode) {
                if (StringUtil.isEmpty(srcIds.toString())) {
                    srcIds.append("'").append(s).append("'");
                } else {
                    srcIds.append(",'").append(s).append("'");
                }
            }
            StringBuilder destIds = new StringBuilder("");
            //收货方
            for (String s : cIWhCode) {
                if (StringUtil.isEmpty(destIds.toString())) {
                    destIds.append("'").append(s).append("'");
                } else {
                    destIds.append(",'").append(s).append("'");
                }
            }
            StringBuilder materialIds = new StringBuilder("");
            //产品
            for (String s : cInvCode) {
                if (StringUtil.isEmpty(materialIds.toString())) {
                    materialIds.append("detail.cInvCode like '").append(s).append("%' ");
                } else {
                    materialIds.append("or detail.cInvCode like '").append(s).append("%' ");
                }
            }
            String sql =
                    " select  header.id AS  id,header.cTVCode AS cTVCode,header.dTVDate AS dTVDate,header.cOWhCode AS cOWhCode, " +
                            " header.cIWhCode AS cIWhCode ,header.cORdCode AS cORdCode ,header.cIRdCode AS cIRdCode " +
                            " from TransVouch   header " +
                            " INNER JOIN TransVouchs  detail ON detail.id=header.id " +
                            " where cOWhCode IN  ( " + srcIds.toString() + ")  and cIWhCode IN (" + destIds.toString() + ") AND cOWhCode!=cIWhCode " +
                            " and dTVDate > = ?  and dTVDate <?   AND cORdCode='204'  AND (" + materialIds.toString() + ")  AND detail.coutposcode is not null " +
                            " group by header.id,header.cTVCode,header.dTVDate,header.cOWhCode,header.cIWhCode,header.cORdCode,header.cIRdCode ";
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, beginTime);
                ps.setString(2, endTime);
                rs = ps.executeQuery();
                List<RDCToRDCOutHeaderDTO> dtoList = new ArrayList<>();
                while (rs.next()) {
                    RDCToRDCOutHeaderDTO dto = new RDCToRDCOutHeaderDTO();
                    dto.setId(rs.getString("id"));
                    dto.setcTVCode(rs.getString("cTVCode"));
                    dto.setdTVDate(rs.getDate("dTVDate"));
                    dto.setcOWhCode(rs.getString("cOWhCode"));
                    dto.setcIWhCode(rs.getString("cIWhCode"));
                    dto.setcORdCode(rs.getString("cORdCode"));
                    dto.setcIRdCode(rs.getString("cIRdCode"));
                    dtoList.add(dto);
                }
                if (dtoList.size() == 0) {
                    logger.info("没有查询到数据");
                }
                return dtoList;
            } finally {
                conn.close();
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }
        }
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
        Connection conn = getConnection();
        if (conn == null) {
            throw new RuntimeException("与数据库连接失败！");
        } else {
            StringBuilder ids = new StringBuilder("");
            for (String s : id) {
                if (StringUtil.isEmpty(ids.toString())) {
                    ids.append("'").append(s).append("'");
                } else {
                    ids.append(",'").append(s).append("'");
                }
            }
            StringBuilder materialIds = new StringBuilder("");
            //产品
            for (String s : cInvCode) {
                if (StringUtil.isEmpty(materialIds.toString())) {
                    materialIds.append("cInvCode like '").append(s).append("%' ");
                } else {
                    materialIds.append("or cInvCode like '").append(s).append("%' ");
                }
            }
            String sql = " select  id,autoid,cTVCode,cInvCode,iTVQuantity,coutposcode,cinposcode,cbMemo,cdefine22   " +
                    "  from TransVouchs  where id IN ( " + ids.toString() + ") AND (" + materialIds.toString() + ")";
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                List<RDCToRDCOutDetailDTO> dtoList = new ArrayList<>();
                while (rs.next()) {
                    RDCToRDCOutDetailDTO dto = new RDCToRDCOutDetailDTO();
                    dto.setId(rs.getString("id"));
                    dto.setAutoId(rs.getString("autoId"));
                    dto.setcInvCode(rs.getString("cInvCode"));
                    dto.setiTVQuantity(rs.getBigDecimal("iTVQuantity"));
                    dto.setCoutposcode(rs.getString("coutposcode"));
                    dto.setCinposcode(rs.getString("cinposcode"));
                    dto.setCbMemo(rs.getString("cbMemo"));
                    dto.setCdefine22(rs.getString("cdefine22"));
                    dtoList.add(dto);
                }
                if (dtoList.size() == 0) {
                    logger.info("没有查询到数据");
                }
                return dtoList;
            } finally {
                conn.close();
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }
        }
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
        Connection conn = getConnection();
        if (conn == null) {
            throw new RuntimeException("与数据库连接失败！");
        } else {
            StringBuilder ids = new StringBuilder("");
            //仓库
            for (String s : cOWhCode) {
                if (StringUtil.isEmpty(ids.toString())) {
                    ids.append("'").append(s).append("'");
                } else {
                    ids.append(",'").append(s).append("'");
                }
            }
            StringBuilder typeIds = new StringBuilder("");
            //出库类别
            for (String s : cRdCode) {
                if (StringUtil.isEmpty(typeIds.toString())) {
                    typeIds.append("'").append(s).append("'");
                } else {
                    typeIds.append(",'").append(s).append("'");
                }
            }
            StringBuilder materialIds = new StringBuilder("");
            //产品
            for (String s : cInvCode) {
                if (StringUtil.isEmpty(materialIds.toString())) {
                    materialIds.append("detail.cInvCode like '").append(s).append("%' ");
                } else {
                    materialIds.append("or detail.cInvCode like '").append(s).append("%' ");
                }
            }
            String sql =
                    " select  header.id AS id ,header.dDate AS  dDate,header.cCode AS cCode,header.cWhCode AS cWhCode,header.cRdCode AS cRdCode,header.cDepCode AS cDepCode " +
                            " from RdRecord09    header " +
                            " INNER JOIN rdrecords09 detail on header.id=detail.id " +
                            " where header.cWhCode IN ( " + ids.toString() + ") and header.cRdCode IN (" + typeIds.toString() + ") " +
                            " and header.dDate > = ?  and header.dDate <? AND (" + materialIds.toString() + ") " +
                            " group by header.id,header.cCode,header.dDate,header.cWhCode,header.cRdCode,header.cDepCode ";
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, beginTime);
                ps.setString(2, endTime);
                rs = ps.executeQuery();
                List<RDCToOtherDealerOutHeaderDTO> dtoList = new ArrayList<>();
                while (rs.next()) {
                    RDCToOtherDealerOutHeaderDTO dto = new RDCToOtherDealerOutHeaderDTO();
                    dto.setId(rs.getString("id"));
                    dto.setdDate(rs.getDate("dDate"));
                    dto.setcCode(rs.getString("cCode"));
                    dto.setcWhCode(rs.getString("cWhCode"));
                    dto.setcRdCode(rs.getString("cRdCode"));
                    dto.setcDepCode(rs.getString("cDepCode"));
                    dtoList.add(dto);
                }
                if (dtoList.size() == 0) {
                    logger.info("没有查询到数据");
                }
                return dtoList;
            } finally {
                conn.close();
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }
        }
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
        Connection conn = getConnection();
        if (conn == null) {
            throw new RuntimeException("与数据库连接失败！");
        } else {
            StringBuilder ids = new StringBuilder("");
            for (String s : id) {
                if (StringUtil.isEmpty(ids.toString())) {
                    ids.append("'").append(s).append("'");
                } else {
                    ids.append(",'").append(s).append("'");
                }
            }
            StringBuilder materialIds = new StringBuilder("");
            //产品
            for (String s : cInvCode) {
                if (StringUtil.isEmpty(materialIds.toString())) {
                    materialIds.append(" cInvCode like '").append(s).append("%' ");
                } else {
                    materialIds.append("or cInvCode like '").append(s).append("%' ");
                }
            }
            String sql = " select  id,cInvCode,iQuantity,cPosition   " +
                    "  from rdrecords09  where id IN ( " + ids.toString() + ") AND (" + materialIds.toString() + ") ";
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                List<RDCToOtherDealerOutDetailDTO> dtoList = new ArrayList<>();
                while (rs.next()) {
                    RDCToOtherDealerOutDetailDTO dto = new RDCToOtherDealerOutDetailDTO();
                    dto.setId(rs.getString("id"));
                    dto.setcInvCode(rs.getString("cInvCode"));
                    dto.setiQuantity(rs.getBigDecimal("iQuantity"));
                    dto.setcPosition(rs.getString("cPosition"));
                    dtoList.add(dto);
                }
                if (dtoList.size() == 0) {
                    logger.info("没有查询到数据");
                }
                return dtoList;
            } finally {
                conn.close();
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }
        }
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
        Connection conn = getConnection();
        if (conn == null) {
            throw new RuntimeException("与数据库连接失败！");
        } else {
            StringBuilder ids = new StringBuilder("");
            //仓库编码
            for (String s : cOWhCode) {
                if (StringUtil.isEmpty(ids.toString())) {
                    ids.append("'").append(s).append("'");
                } else {
                    ids.append(",'").append(s).append("'");
                }
            }
            StringBuilder materialIds = new StringBuilder("");
            //产品
            for (String s : cInvCode) {
                if (StringUtil.isEmpty(materialIds.toString())) {
                    materialIds.append("detail.cInvCode like '").append(s).append("%' ");
                } else {
                    materialIds.append("or detail.cInvCode like '").append(s).append("%' ");
                }
            }
            String sql =
                    " select  header.id AS id,header.cVouchCode AS cVouchCode,header.dDate AS dDate,header.cWhCode AS cWhCode,header.cDepCode AS cDepCode " +
                            " from AdjustPVouch  header " +
                            " INNER JOIN AdjustPVouchs detail ON detail.id=header.id " +
                            " where header.cWhCode IN  ( " + ids.toString() + ") " +
                            " and header.dDate > = ?  and header.dDate <?  AND (" + materialIds.toString() + ") " +
                            " group by header.id,header.cVouchCode,header.dDate,header.cWhCode,header.cDepCode ";
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, beginTime);
                ps.setString(2, endTime);
                rs = ps.executeQuery();
                List<LocationAdjustHeaderDTO> dtoList = new ArrayList<>();
                while (rs.next()) {
                    LocationAdjustHeaderDTO dto = new LocationAdjustHeaderDTO();
                    dto.setId(rs.getString("id"));
                    dto.setdDate(rs.getDate("dDate"));
                    dto.setcVouchCode(rs.getString("cVouchCode"));
                    dto.setcWhCode(rs.getString("cWhCode"));
                    dto.setcDepCode(rs.getString("cDepCode"));
                    dtoList.add(dto);
                }
                if (dtoList.size() == 0) {
                    logger.info("没有查询到数据");
                }
                return dtoList;
            } finally {
                conn.close();
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }
        }
    }

    /**
     * 根据移库单单据ID获取单据明细
     *
     * @param id 单据ID
     * @return re
     */
    @Override
    public List<LocationAdjustDetailDTO> getLocationAdjustDetailList(String[] id, String[] cInvCode) throws SQLException {
        Connection conn = getConnection();
        if (conn == null) {
            throw new RuntimeException("与数据库连接失败！");
        } else {
            StringBuilder ids = new StringBuilder("");
            for (String s : id) {
                if (StringUtil.isEmpty(ids.toString())) {
                    ids.append("'").append(s).append("'");
                } else {
                    ids.append(",'").append(s).append("'");
                }
            }
            StringBuilder materialIds = new StringBuilder("");
            //产品
            for (String s : cInvCode) {
                if (StringUtil.isEmpty(materialIds.toString())) {
                    materialIds.append(" cInvCode like '").append(s).append("%' ");
                } else {
                    materialIds.append(" or cInvCode like '").append(s).append("%' ");
                }
            }
            String sql = " select  id,autoId,cInvCode,iQuantity,cBPosCode,cAPosCode " +
                    "  from AdjustPVouchs  where id IN ( " + ids.toString() + ") AND (" + materialIds.toString() + ")";
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                List<LocationAdjustDetailDTO> dtoList = new ArrayList<>();
                while (rs.next()) {
                    LocationAdjustDetailDTO dto = new LocationAdjustDetailDTO();
                    dto.setId(rs.getString("id"));
                    dto.setAutoId(rs.getInt("autoId"));
                    dto.setcInvCode(rs.getString("cInvCode"));
                    dto.setiQuantity(rs.getBigDecimal("iQuantity"));
                    dto.setcBPosCode(rs.getString("cBPosCode"));
                    dto.setcAPosCode(rs.getString("cAPosCode"));
                    dtoList.add(dto);
                }
                if (dtoList.size() == 0) {
                    logger.info("没有查询到数据");
                }
                return dtoList;
            } finally {
                conn.close();
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }
        }
    }

    @Override
    public List<PackPlanHeaderDTO> getPackPlanHeaderList(String beginTime, String endTime) {
        String hql = "select * from packPlanHeader  with(noLock) where  addTime >:beginTime and addTime <=:endTime order by addTime asc ";
        Map<String, Object> map = new HashMap<>();
        map.put("beginTime", beginTime);
        map.put("endTime", endTime);
        return findAllResutlBeansBySql(hql, map, PackPlanHeaderDTO.class);
    }

    @Override
    public List<ProductPlanHeaderDTO> getProductPlanList(String beginTime, String endTime) {
        String hql = "select * from ProductPlanHeader  with(noLock) where   addTime >:beginTime and addTime <=:endTime order by addTime asc ";
        Map<String, Object> map = new HashMap<>();
        map.put("beginTime", beginTime);
        map.put("endTime", endTime);
        return findAllResutlBeansBySql(hql, map, ProductPlanHeaderDTO.class);
    }

    @Override
    public List<SSODataDTO> syncBillData(String beginTime, String endTime) {
        String hql = " select  " +
                " detail.CustStoreName as CustStoreName, " +
                " detail.CustName as CustName, " +
                " SSOHeader.OpDate as OpDate, " +
                " data.Id as Id, " +
                " data.DetailId as DetailId, " +
                " data.Qty as Qty, " +
                " data.AddTime as AddTime, " +
                " data.AddBy as AddBy, " +
                " data.PackCode as PackCode, " +
                " data.Code as Code, " +
                " data.ProductSKU as ProductSKU, " +
                " data.BatchCode as BatchCode " +
                " from SSOData data " +
                " left join SSODetail detail on detail.Id=data.DetailId  " +
                " left join SSOHeader  on SSOHeader.Code=detail.OrdCode " +
                " where  data.addTime >:beginTime and data.addTime <=:endTime order by data.addTime asc  ";
        Map<String, Object> map = new HashMap<>();
        map.put("beginTime", beginTime);
        map.put("endTime", endTime);
        return findAllResutlBeansBySql(hql, map, SSODataDTO.class);
    }

    @Override
    public List<PackPlanDetailDTO> getPackPlanDetailDTOList(String ordCode) throws SQLException {
        String hql = "select * from PackPlanDetail  with(noLock) where   ordCode =:ordCode ";
        Map<String, Object> map = new HashMap<>();
        map.put("ordCode", ordCode);
        return findAllResutlBeansBySql(hql, map, PackPlanDetailDTO.class);
    }


    /**
     * 同步入库登记记录
     *
     * @param syncRegisterStr 同步数据
     * @return re
     */
    @Override
    public String syncRegister(String syncRegisterStr) throws SQLException {
        List<PackInRegisterDetailDTO> customerList = JSONArray.parseArray(syncRegisterStr, PackInRegisterDetailDTO.class);
        Connection conn = getConnection2();
        if (conn == null) {
            throw new RuntimeException("与数据库连接失败！");
        } else {
            String sql = "INSERT INTO HY_EO_PInsert ( ddate , crdtype , cinvclassname , cwhcode , cdepcode , cinvcode , iquantity , cposcode , iuse )VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = null;
            try {
                ps = conn.prepareStatement(sql);
                for (int i = 0; i < customerList.size(); i++) {
                    PackInRegisterDetailDTO dto = customerList.get(i);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    ps.setString(1, sdf.format(dto.getOperateTime()));
                    ps.setString(2, dto.getCrdtype());
                    ps.setString(3, dto.getMaterialShortName());
                    ps.setString(4, dto.getCwhcode());
                    ps.setString(5, dto.getTeamCode());
                    ps.setString(6, dto.getMaterialSku());
                    ps.setBigDecimal(7, dto.getQty());
                    ps.setString(8, dto.getLocationId());
                    ps.setBoolean(9, true);
                    ps.addBatch();
                    if (i > 0 && i % 1000 == 0) {
                        ps.executeBatch();
                    }
                }
                ps.executeBatch();
                return "OK";
            } finally {
                if (ps != null) {
                    ps.close();
                }
            }
        }
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
        Connection conn = getConnection();
        if (conn == null) {
            throw new RuntimeException("与数据库连接失败！");
        } else {
            String sql = " select  id,csocode,ddate,cstname,cscname,ccusabbname,ccuscode,cdefine13,cwverifydate" +
                    " from SaleOrderQ  where  ddate > = ?  and ddate <?  and cwverifydate is not null ";
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, beginTime);
                ps.setString(2, endTime);
                rs = ps.executeQuery();
                List<SaleHeaderDTO> dtoList = new ArrayList<>();
                while (rs.next()) {
                    SaleHeaderDTO dto = new SaleHeaderDTO();
                    //ERP的ID
                    dto.setId(rs.getString("id"));
                    String csocode = rs.getString("csocode");
                    //ERP单号csocode
                    dto.setCsocode(csocode);
                    //ERP单据日期ddate
                    dto.setDdate(rs.getDate("ddate"));
                    //销售类型cstname
                    dto.setCstname(rs.getString("cstname"));
                    //发运方式cscname
                    dto.setCscname(rs.getString("cscname"));
                    //客户简称ccusabbname
                    dto.setCcusabbname(rs.getString("ccusabbname"));
                    //客户编码ccuscode
                    dto.setCcuscode(rs.getString("ccuscode"));
                    //商业库cdefine13
                    dto.setCdefine13(rs.getString("cdefine13"));
                    //财务审核日期cwverifydate
                    dto.setCwverifydate(rs.getDate("cwverifydate"));
                    dtoList.add(dto);
                }
                if (dtoList.size() == 0) {
                    logger.info("没有查询到数据");
                }
                return dtoList;
            } finally {
                conn.close();
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }
        }
    }

    /**
     * 根据移库单单据ID获取单据明细
     *
     * @param id 单据ID
     * @return re
     */
    @Override
    public List<SaleDetailDTO> getSaleOrderDetailList(String[] id) throws SQLException {
        Connection conn = getConnection();
        if (conn == null) {
            throw new RuntimeException("与数据库连接失败！");
        } else {
            StringBuilder ids = new StringBuilder("");
            for (String s : id) {
                if (StringUtil.isEmpty(ids.toString())) {
                    ids.append("'").append(s).append("'");
                } else {
                    ids.append(",'").append(s).append("'");
                }
            }
            String sql = " select  id,autoid,cendstationname,cinvcode,cinvname,consigneename,iquantity " +
                    "  from SaleOrderSQ  where id IN ( " + ids.toString() + ")";
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                List<SaleDetailDTO> dtoList = new ArrayList<>();
                while (rs.next()) {
                    SaleDetailDTO dto = new SaleDetailDTO();
                    dto.setId(rs.getInt("id"));
                    dto.setAutoid(rs.getInt("autoId"));
                    dto.setCendstationname(rs.getString("cendstationname"));
                    dto.setCinvcode(rs.getString("cinvcode"));
                    dto.setCinvname(rs.getString("cinvname"));
                    dto.setConsigneename(rs.getString("consigneename"));
                    dto.setIquantity(rs.getBigDecimal("iquantity"));
                    dtoList.add(dto);
                }
                if (dtoList.size() == 0) {
                    logger.info("没有查询到数据");
                }
                return dtoList;
            } finally {
                conn.close();
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }
        }
    }

    @Override
    public List<SyncMaterialDTO> getMaterialList() throws SQLException {
        Connection conn = getConnection();
        if (conn == null) {
            throw new RuntimeException("与数据库连接失败！");
        } else {
            String sql = " SELECT cInvCode,cInvName,cInvDefine6,cInvStd,cInvDefine7,cInvDefine8,cInvDefine1,cInvDefine2,dEDate,dSDate " +
                    "  FROM Inventory where cInvCode like '05%' and dEDate is null ";
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                List<SyncMaterialDTO> dtoList = new ArrayList<>();
                while (rs.next()) {
                    SyncMaterialDTO dto = new SyncMaterialDTO();
                    dto.setcInvCode(rs.getString("cInvCode"));
                    dto.setcInvName(rs.getString("cInvName"));
                    dto.setcInvDefine6(rs.getString("cInvDefine6"));
                    dto.setcInvStd(rs.getString("cInvStd"));
                    dto.setcInvDefine7(rs.getString("cInvDefine7"));
                    dto.setcInvDefine8(rs.getString("cInvDefine8"));
                    dto.setcInvDefine1(rs.getString("cInvDefine1"));
                    dto.setcInvDefine2(rs.getString("cInvDefine2"));
                    dto.setdEDate(rs.getDate("dEDate"));
                    dto.setdSDate(rs.getDate("dSDate"));
                    dtoList.add(dto);
                }
                if (dtoList.size() == 0) {
                    logger.info("没有查询到数据");
                }
                return dtoList;
            } finally {
                conn.close();
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }
        }
    }

    private Connection getConnection() {
        String url = sysProperties.getProperty("proj.erp.url");
        String user = sysProperties.getProperty("proj.erp.user");
        String password = sysProperties.getProperty("proj.erp.password");
        String driverName = sysProperties.getProperty("proj.erp.driverClass");
        Connection conn;
        try {
            //初始化驱动包
            Class.forName(driverName);
            //根据数据库连接字符，名称，密码给conn赋值
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private Connection getConnection2() {
        String url = sysProperties.getProperty("proj.erp.url2");
        String user = sysProperties.getProperty("proj.erp.user");
        String password = sysProperties.getProperty("proj.erp.password");
        String driverName = sysProperties.getProperty("proj.erp.driverClass");
        Connection conn = null;
        try {
            //初始化驱动包
            Class.forName(driverName);
            //根据数据库连接字符，名称，密码给conn赋值
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
