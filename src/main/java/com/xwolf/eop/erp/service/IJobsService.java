package com.xwolf.eop.erp.service;

import com.xwolf.eop.common.pojo.easyui.PageResult;
import com.xwolf.eop.erp.entity.Jobs;
import com.xwolf.eop.system.service.BaseService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * </p>
 *
 * @author xwolf
 * @date 2017-01-20 17:08
 * @since V1.0.0
 */
public interface IJobsService extends BaseService<Jobs> {

    PageResult getJobsList(HttpServletRequest request);
}
