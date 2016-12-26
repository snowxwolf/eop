package com.xwolf.eop.system.service;

import com.xwolf.eop.common.pojo.PageResult;
import com.xwolf.eop.system.entity.Codes;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xwolf
 * @since 2016-12-20
 */
public interface ICodesService extends BaseService<Codes> {

    PageResult selectCodesList(HttpServletRequest request);
}
