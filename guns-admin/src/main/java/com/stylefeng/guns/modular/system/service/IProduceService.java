package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.Produce;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wlh123
 * @since 2018-04-24
 */
public interface IProduceService extends IService<Produce> {

    List<Produce> selectLists(String condition);
}
