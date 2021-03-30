package com.zone.process.domain.repository;

import com.zone.process.domain.agg.ProcessInstAgg;

/**
 * @Author: jianyong.zhu
 * @Date: 2021/3/29 3:05 下午
 * @Description:
 */
public interface ProcessInstAggRepository {

    void save(ProcessInstAgg instAgg);

    ProcessInstAgg queryById(Long id);

    Boolean update(ProcessInstAgg instAgg);

    ProcessInstAgg queryByInstId(String procInstId);
}
