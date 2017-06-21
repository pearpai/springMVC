package com.bq.dao;

import com.bq.entity.CompanyInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by wuyunfeng on 2016/10/18.
 */
public interface CompanyInfoMapper {
    int insert(CompanyInfo companyInfo);

    List<CompanyInfo> getList(Map<String, Object> map);
}
