package com.xwolf.eop.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.common.pojo.PageHelper;
import com.xwolf.eop.common.pojo.easyui.PageResult;
import com.xwolf.eop.system.dao.CodesMapper;
import com.xwolf.eop.system.entity.Codes;
import com.xwolf.eop.system.service.ICodesService;
import com.xwolf.eop.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
@Slf4j
@Service
public class CodesServiceImpl extends BaseServiceImpl<Codes> implements ICodesService {


    @Autowired
    private CodesMapper codesMapper;

    /**
     *获取 h
     * @param request
     * @return
     */
    @Override
    public PageResult selectCodesList(HttpServletRequest request) {
        PageHelper.getPage(request);
        Map<String,Object> map= HttpUtil.getRequestMap(request);
        log.info("request params:{}", JSON.toJSONString(map));
        List<Codes> codesList=codesMapper.selectCodesList(map);
        return  PageHelper.getListResult(codesList);
    }

    /**
     *  新增
     * @param codes
     * @return
     */
    @Override
    public JSONObject insert(Codes codes) {
        try {
            codes.setCtime(new Date());
            int re= codesMapper.insert(codes);
            if(re>0){
                return success();
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return systemError();
        }
        return unkownError();
    }

    /**
     * 修改
     * @param codes
     * @return
     */
    @Override
    public JSONObject update(Codes codes) {
        try {
            codes.setCtime(new Date());
            int re= codesMapper.updateByPrimaryKeySelective(codes);
            if(re>0){
                return success();
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return systemError();
        }
        return unkownError();
    }

    /**
     * 批量删除
     * @param request
     * @return
     */
    @Override
    public JSONObject deleteBatch(HttpServletRequest request) {
        try {
               String[] idAry=HttpUtil.getRequestIds(request);
               codesMapper.deleteBatch(idAry);
               return success();
        } catch (Exception e) {
           log.error(e.getMessage(),e);
           return systemError();
        }
    }
}
