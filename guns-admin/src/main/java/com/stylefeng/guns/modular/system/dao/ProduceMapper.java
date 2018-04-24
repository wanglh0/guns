package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.Produce;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wlh123
 * @since 2018-04-24
 */
public interface ProduceMapper extends BaseMapper<Produce> {

    List<Produce> selectLists(@Param("condition") String condition);
}
