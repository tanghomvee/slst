package com.slst.user.service;

import com.slst.common.service.BaseService;
import com.slst.user.dao.model.Role;

/**
 * @Author <a href="mailto:npleung@163.com">NPLeung</a>
 * @Description TODO(用一句话描述该文件做什么)
 * @Date Created in 2018/7/2 9:25
 */
public interface RoleService extends BaseService<Role,Long> {

    Long findRoleIdByUserId(Long userId);

    Integer saveUserRole(Long userId,Long roleId);
}
