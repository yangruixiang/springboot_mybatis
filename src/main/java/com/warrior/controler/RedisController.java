package com.warrior.controler;

import com.warrior.entity.Student;
import com.warrior.result.ResultModel;
import com.warrior.result.ResultModelTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version v1.0
 * @ProjectName: ETH
 * @ClassName: RedisController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: Yanghaha
 * @Date: 2019/12/9 14:19
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @Param
     * @Author Yanghaha
     * @Date 2019/12/9 14:37
     * @return 
     */
    @RequestMapping("/testRedis")
    @ResponseBody
    public ResultModel testRedis(){
        redisTemplate.opsForValue().set("cx","hello");
        Map<String, String> UserMap = new HashMap<>();
        UserMap.put("cx",redisTemplate.opsForValue().get("cx"));
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(0);
        resultModel.setMsg("成功");
        resultModel.setData(UserMap);
        return ResultModelTool.handleResultModel(resultModel);
    }
}
