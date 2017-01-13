package com.xwolf.eop.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.system.dao.BlackListMapper;
import com.xwolf.eop.system.entity.BlackList;
import com.xwolf.eop.system.service.IBlackListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * </p>
 *
 * @author xwolf
 * @date 2017-01-13 19:31
 * @since V1.0.0
 */
@Slf4j
@Service
public class BlackListServiceImpl extends BaseServiceImpl<BlackList> implements IBlackListService {
    @Autowired
    private BlackListMapper blackListMapper;

    @Override
    public JSONObject insert(BlackList blackList) {
        try {
            blackList.setCreateTime(new Date());
            int re= blackListMapper.insert(blackList);
            if(re>0){
                return success();
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return systemError();
        }
        return unkownError();
    }
}
