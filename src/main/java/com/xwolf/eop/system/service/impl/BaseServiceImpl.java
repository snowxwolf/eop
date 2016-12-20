package com.xwolf.eop.system.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xwolf.eop.system.service.BaseService;

/**
 * @author xwolf
 * @date 2016-12-20 16:42
 * @since V1.0.0
 */
public class BaseServiceImpl<M extends BaseMapper<T>,T> extends ServiceImpl<M,T> implements BaseService<T>  {



}
