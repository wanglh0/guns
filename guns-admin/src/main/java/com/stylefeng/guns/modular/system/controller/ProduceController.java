package com.stylefeng.guns.modular.system.controller;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.modular.flowable.warpper.ExpenseWarpper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Produce;
import com.stylefeng.guns.modular.system.service.IProduceService;

import java.util.List;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2018-04-24 13:47:32
 */
@Controller
@RequestMapping("/produce")
public class ProduceController extends BaseController {

    private String PREFIX = "/system/produce/";

    @Autowired
    private IProduceService produceService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "produce.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/produce_add")
    public String produceAdd() {
        return PREFIX + "produce_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/produce_update/{produceId}")
    public String produceUpdate(@PathVariable Integer produceId, Model model) {
        Produce produce = produceService.selectById(produceId);
        model.addAttribute("item",produce);
        LogObjectHolder.me().set(produce);
        return PREFIX + "produce_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
//        List<Produce> produces = produceService.selectList(null);
        List<Produce> produces=produceService.selectLists(condition);
        return produces;
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Produce produce) {
        produceService.insert(produce);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer produceId) {
        produceService.deleteById(produceId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Produce produce) {
        produceService.updateById(produce);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{produceId}")
    @ResponseBody
    public Object detail(@PathVariable("produceId") Integer produceId) {
        return produceService.selectById(produceId);
    }
}
