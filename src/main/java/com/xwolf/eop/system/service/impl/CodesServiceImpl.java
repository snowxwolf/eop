package com.xwolf.eop.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.xwolf.eop.common.pojo.Page;
import com.xwolf.eop.common.pojo.PageHelper;
import com.xwolf.eop.common.pojo.PageRequest;
import com.xwolf.eop.common.pojo.PageResult;
import com.xwolf.eop.system.dao.CodesMapper;
import com.xwolf.eop.system.entity.Codes;
import com.xwolf.eop.system.service.ICodesService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author xwolf
 * @since 2016-12-20
 */
@Service
public class CodesServiceImpl extends BaseServiceImpl<Codes> implements ICodesService {

    private static Logger LOG= LoggerFactory.getLogger(CodesServiceImpl.class);

    @Autowired
    private CodesMapper codesMapper;

    /**
     *
     * @param request
     * @return
     */
    @Override
    public PageResult selectCodesList(HttpServletRequest request) {
        PageRequest pageRequest=PageHelper.getPage(request);
        Map<String,Object> map= Maps.newHashMap();
        List<Codes> codesList=codesMapper.selectCodesList(map);
        return  PageHelper.getListResult(codesList,pageRequest);
    }
}
