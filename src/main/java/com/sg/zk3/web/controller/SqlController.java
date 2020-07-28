package com.sg.zk3.web.controller;

import com.sg.zk3.web.mapper.LoveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author junwei.liang01@ucarinc.com
 * @date 2020/7/28 15:28
 */
@Controller
@RequestMapping(value = "sql")
public class SqlController {

    @Autowired
    private LoveMapper mapper;

    @ResponseBody
    @RequestMapping(value = "do")
    public Object health(String table) {
        return mapper.selectId(table);
    }
}
