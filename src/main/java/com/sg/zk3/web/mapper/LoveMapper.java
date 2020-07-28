package com.sg.zk3.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author junwei.liang01@ucarinc.com
 * @date 2020/7/28 15:30
 */
@Mapper
@Component
public interface LoveMapper {
    /**
     * love xy
     *
     * @param table
     * @return
     */
    Long selectId(@Param("table") String table);
}
