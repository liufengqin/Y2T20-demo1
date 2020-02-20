package com.bdqn.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys")
public class SystemController {

    /**
     * 去到后台首页
     * @return
     */
    @RequestMapping("/index")
    public String toIndex(){
        return "system/home/index";
    }

    /**
     * 去到首页工作台页面
     * @return
     */
    @RequestMapping("/toDesktopManager")
    public String toDesktopManager(){
        return "system/home/desktopManager";
    }
    /**
     * 去到日志管理页面
     * @return
     */
    @RequestMapping("/toLogManager")
    public String toLogManager(){
        return "system/log/logManager";
    }

    /**
     * 去到公告管理页面
     * @return
     */
    @RequestMapping("/toNoticeManager")
    public String toNoticeManager(){
        return "system/notice/noticeManager";
    }


    /**
     * 去到部门管理页面-left左边树节点
     * @return
     */
    @RequestMapping("/toDeptLeft")
    public String toDeptLeft(){
        return "system/dept/left";
    }

    /**
     * 去到部门管理页面-right右边
     * @return
     */
    @RequestMapping("/toDeptRight")
    public String toDeptRight(){
        return "system/dept/right";
    }

    /**
     * 去到部门管理页面
     * @return
     */
    @RequestMapping("/toDeptManager")
    public String toDeptManager(){
        return "system/dept/deptManager";
    }


    /**
     * 去到菜单管理页面-left左边树节点
     * @return
     */
    @RequestMapping("/toMenuLeft")
    public String toMenuLeft(){
        return "system/menu/left";
    }

    /**
     * 去到菜单管理页面-right右边
     * @return
     */
    @RequestMapping("/toMenuRight")
    public String toMenuRight(){
        return "system/menu/right";
    }

    /**
     * 去到菜单管理页面
     * @return
     */
    @RequestMapping("/toMenuManager")
    public String toMenuManager(){
        return "system/menu/menuManager";
    }

}
