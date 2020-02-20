package com.bdqn.sys.service;

import com.bdqn.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author KazuGin
 * @since 2019-12-23
 */
public interface UserService extends IService<User> {


    /**
     * 根据用户名查询用户信息的方法
     * @param userName
     * @return
     * @throws Exception
     */
    User findUserByName(String userName) throws Exception;

}
