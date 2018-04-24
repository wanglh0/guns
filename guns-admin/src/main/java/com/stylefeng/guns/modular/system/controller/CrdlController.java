package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Crdl;
import com.stylefeng.guns.modular.system.service.ICrdlService;

import java.util.Date;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2018-04-24 18:08:31
 */
@Controller
@RequestMapping("/crdl")
public class CrdlController extends BaseController {

    private String PREFIX = "/system/crdl/";

    @Autowired
    private ICrdlService crdlService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "crdl.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/crdl_add")
    public String crdlAdd() {
        return PREFIX + "crdl_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/crdl_update/{crdlId}")
    public String crdlUpdate(@PathVariable Integer crdlId, Model model) {
        Crdl crdl = crdlService.selectById(crdlId);
        model.addAttribute("item",crdl);
        LogObjectHolder.me().set(crdl);
        return PREFIX + "crdl_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return crdlService.selectList(null);
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Crdl crdl) {
        crdl.setNowdate(new Date());
        crdlService.insert(crdl);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer crdlId) {
        crdlService.deleteById(crdlId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Crdl crdl) {
        crdl.setUpdatetime(new Date());
        crdlService.updateById(crdl);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{crdlId}")
    @ResponseBody
    public Object detail(@PathVariable("crdlId") Integer crdlId) {
        return crdlService.selectById(crdlId);
    }
}
