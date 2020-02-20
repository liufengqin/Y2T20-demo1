package com.bdqn.sys.controller;


import com.bdqn.sys.entity.Log;
import com.bdqn.sys.service.LogService;
import com.bdqn.sys.utils.JSONResult;
import com.bdqn.sys.utils.SystemConstant;
import com.bdqn.sys.vo.LoginUserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author KazuGin
 * @since 2019-12-23
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Resource
    private LogService logService;

    /**
     * 登录请求
     *
     * @param loginname
     * @param pwd
     * @param request
     * @return
     */
    @PostMapping("/login")
    public JSONResult login(String loginname, String pwd, HttpServletRequest request) {
        //获取当前主体对象
        Subject subject = SecurityUtils.getSubject();
        //创建令牌对象
        UsernamePasswordToken token = new UsernamePasswordToken(loginname, pwd);
        try {
            //执行登录
            subject.login(token);
            //获取当前登录用户
            LoginUserVo loginUserVo = (LoginUserVo) subject.getPrincipal();
            //保存当前登录用户
            request.getSession().setAttribute(SystemConstant.LOGINUSER, loginUserVo.getUser());

            //记录日志
            //内容，操作类型，登录人，登录人id，登录人ip地址，操作时间
            Log log = new Log("用户登录", SystemConstant.LOGIN_ACTION,
                    loginname + "-" + loginUserVo.getUser().getName(),
                    loginUserVo.getUser().getId(), request.getRemoteAddr(), new Date());
            logService.save(log);

            //返回结果
            //登录成功
            return SystemConstant.LOGIN_SUCCESS;
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        //登录失败
        return SystemConstant.LOGIN_ERROR_PASS;
    }

}

