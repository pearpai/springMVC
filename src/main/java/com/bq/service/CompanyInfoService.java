package com.bq.service;

import com.bq.dao.CompanyInfoMapper;
import com.bq.entity.CompanyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wuyunfeng on 2016/10/18.
 */
@Service
public class CompanyInfoService {
    @Autowired
    CompanyInfoMapper companyInfoMapper;

    public int insert(CompanyInfo companyInfo){
       return companyInfoMapper.insert(companyInfo);
    }

    public List<CompanyInfo> getList(Map<String, Object> map){
        return companyInfoMapper.getList(map);
    }
}
