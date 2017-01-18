package com.xwolf.eop.test.core;

import com.xwolf.eop.system.entity.User;
import org.junit.Test;

import java.util.Objects;

/**
 * <p>
 * </p>
 *
 * @author xwolf
 * @date 2017-01-18 09:32
 * @since V1.0.0
 */
public class TestEq {

    @Test
    public void te(){
        User user =new User();
        user.setUid(1);

        User user2=new User();
        user2.setUid(1);

        System.out.println(Objects.equals(null,null));
    }
}
