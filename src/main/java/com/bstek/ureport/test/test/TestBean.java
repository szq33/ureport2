package com.bstek.ureport.test.test;

import com.bstek.ureport.test.test.bean.UserMan;
import com.bstek.ureport.test.test.mapper.TestMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * springBean数据源
 * parameters 存储的为UReport表单数据
 */
@AllArgsConstructor
public class TestBean {

    private final TestMapper testMapper;

    public List<Map<String, Object>> loadReportData(String dsName,
                                                    String datasetName,
                                                    Map<String, Object> parameters) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 1000; i++) {
            Map<String, Object> m = new HashMap<String, Object>();
            m.put("id", i);
            m.put("name", RandomStringUtils.random(10, true, false));
            m.put("salary", RandomUtils.nextInt(10000) + i);
            list.add(m);
        }
        return list;
    }

    /**
     * 查找blade_user表中数据测试
     * @param dsName 数据源名称
     * @param datasetName 数据集名称
     * @param parameters 后端查找需要的参数
     * @return result
     */
    public List<UserMan> buildReport(String dsName, String datasetName, Map<String, Object> parameters) {
        List<UserMan> list = new ArrayList<>();
        System.out.println("参数："+parameters);
        for (String key : parameters.keySet()) {
            Object val = parameters.get(key);//根据需要获取key，val
            if ("isDeleted".equals(key)) {
                Integer isDeleted = Integer.valueOf(val.toString());//获取到参数值,val转String转int
                list = testMapper.findName(isDeleted);
            }
        }
       /* Integer isDeleted=0;
        list = testMapper.findName(isDeleted);*/
        return list;
    }

}
