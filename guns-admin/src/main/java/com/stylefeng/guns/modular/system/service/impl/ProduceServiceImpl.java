package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.Produce;
import com.stylefeng.guns.modular.system.dao.ProduceMapper;
import com.stylefeng.guns.modular.system.service.IProduceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wlh123
 * @since 2018-04-24
 */
@Service
@Transactional
public class ProduceServiceImpl extends ServiceImpl<ProduceMapper, Produce> implements IProduceService {

    @Resource
    private ProduceMapper produceMapper;
    @Override
    public List<Produce> selectLists(String condition) {
        List<Produce> produceList=produceMapper.selectLists(condition);
        return produceList;
    }
}
