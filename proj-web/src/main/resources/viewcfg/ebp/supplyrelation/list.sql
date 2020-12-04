SELECT
  relation.Id AS ID,
  dealer.Code AS DEALERCODE,
  dealer.ShortName AS DEALERNAME,
  store.Code AS STORECODE,
  store.ShortName AS STORENAME,
  relation.CustomCode AS CUSTOMCODE,
  relation.CustomName AS CUSTOMNAME,
  relation.AddBy AS ADDBY,
  relation.AddTime AS ADDTIME,
  relation.EditBy AS EDITBY,
  relation.EditTime AS EDITTIME,
  relation.Remark AS REMARK,
  relation.IsUse AS INUSE,
  CASE relation.IsUse
  WHEN 0
    THEN '禁用'
  ELSE '启用'
  END  AS INUSENAME,
  case store.OrgType
  WHEN 0 THEN '总部'
  WHEN 1 THEN '供应商'
  WHEN 2 THEN '工厂'
  WHEN 3 THEN '分发中心'
  WHEN 4 THEN '经销商'
  WHEN 5 THEN '分销商'
  WHEN 6 THEN '门店'
  ELSE ''
  END AS ORGTYPENAME
FROM sysSupplyRelation relation  with(noLock) LEFT JOIN sysOrganization dealer with(noLock)
on dealer.Id = relation.ParentId
LEFT JOIN sysOrganization store with(noLock)
on relation.ChildId = store.Id
where dealer.OrgType=4
AND dealer.CheckCityId in
(select SysStructureId from sysUserStructure s  with(noLock) where s.SysUserId = :userId )
ORDER BY relation.AddTime desc,dealer.ShortName