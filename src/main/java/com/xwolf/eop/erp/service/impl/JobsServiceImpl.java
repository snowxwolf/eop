package com.xwolf.eop.erp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.common.pojo.PageHelper;
import com.xwolf.eop.common.pojo.easyui.PageResult;
import com.xwolf.eop.common.util.UUIDUtil;
import com.xwolf.eop.erp.dao.JobsMapper;
import com.xwolf.eop.erp.entity.Jobs;
import com.xwolf.eop.erp.service.IJobsService;
import com.xwolf.eop.system.service.impl.BaseServiceImpl;
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
 * </p>
 *
 * @author xwolf
 * @date 2017-01-20 17:09
 * @since V1.0.0
 */
@Service
@Slf4j
public class JobsServiceImpl extends BaseServiceImpl<Jobs> implements IJobsService {
    @Autowired
    private JobsMapper jobsMapper;

    @Override
    public PageResult getJobsList(HttpServletRequest request) {
        PageHelper.getPage(request);
        Map<String,Object> map= HttpUtil.getRequestMap(request);
        List<Jobs> userList=jobsMapper.selectJobList(map);
        return  PageHelper.getListResult(userList);
    }

    @Override
    public JSONObject insert(Jobs job) {
        try {
            job.setJcode(UUIDUtil.getUUID());
            int re= jobsMapper.insert(job);
            if(re>0){
                return success();
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return systemError();
        }
        return unkownError();
    }

    @Override
    public JSONObject update(Jobs job) {
        try {
            int re= jobsMapper.updateByPrimaryKeySelective(job);
            if(re>0){
                return success();
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return systemError();
        }
        return unkownError();
    }

    @Override
    public JSONObject deleteBatch(HttpServletRequest request) {
        try {
            String[] idAry=HttpUtil.getRequestIds(request);
            jobsMapper.deleteBatch(idAry);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return systemError();
        }
    }
}
