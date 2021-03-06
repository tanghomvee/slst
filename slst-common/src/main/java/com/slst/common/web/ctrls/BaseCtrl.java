package com.slst.common.web.ctrls;

import com.alibaba.fastjson.JSON;
import com.slst.common.components.RedisComponent;
import com.slst.common.service.SysCfgService;
import com.slst.common.web.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseCtrl {
    protected Logger LOGGER = null;

    @Resource
    private HttpSession session;

    @Resource
    private HttpServletRequest request;

    @Resource
    protected SysCfgService sysCfgService;

    @Resource
    protected RedisComponent redisComponent;


    public BaseCtrl() {
        LOGGER = LoggerFactory.getLogger(this.getClass());
    }


    protected UserVO getUser() {
        String token = request.getHeader("authorization");
        if (StringUtils.isEmpty(token)) {
            return null;
        }

        String userVOStr = redisComponent.get(token);

        UserVO userVO = JSON.parseObject(userVOStr, UserVO.class);

        return userVO;

    }
}
