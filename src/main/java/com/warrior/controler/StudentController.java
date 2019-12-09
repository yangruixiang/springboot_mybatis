package com.warrior.controler;

import com.alibaba.dubbo.common.utils.IOUtils;
import com.github.pagehelper.PageHelper;
import com.warrior.entity.Student;
import com.warrior.result.ResultModel;
import com.warrior.result.ResultModelTool;
import com.warrior.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lqh
 * @since 2018-05-05
 */
@Controller
@RequestMapping("/warrior/student")
public class StudentController {
    @Autowired
    IStudentService iStudentService;

    @RequestMapping("/hello")
    //如果含有@ResponseBody注解讲返回不了html
//    @ResponseBody
    public String hello() {
        //insert
//        Student student = new Student()
//                .setStuName("杨哈")
//                .setStuNumber("123456")
//                .setAge(22);
//        int i = iStudentService.insertUser(student);
//        if(i>0){
//            return "success";
//        }else{
//            return "failure";
//
//        }
        //也可用ModelAndView

        return "error";
//        return i ? "success" : "failure";
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    @ResponseBody
    public ResultModel hello2(@RequestParam String name) {
        return getResultModel(name);

    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResultModel getAll(@RequestParam String name,@RequestParam int pageNum) {
        PageHelper.startPage(pageNum,6);
        return getResultModel(name);

    }

    private ResultModel getResultModel(@RequestParam String name) {
        List<Student> students = iStudentService.selectStudentByStuName(name);
        Map<String, List<Student>> UserMap = new HashMap<>();
        if (students != null) {
            UserMap.put("users", students);
        }
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(0);
        resultModel.setMsg("成功");
        resultModel.setData(UserMap);
        return ResultModelTool.handleResultModel(resultModel);
    }

    /**
     *
     * @param student
     * @return
     */
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    @ResponseBody
    public ResultModel insertUser(Student student) {
//        boolean res = iStudentService.insert(student);
        int i = iStudentService.insertUser(student);
        ResultModel resultModel = new ResultModel();
        if (i > 0) {
            resultModel.setCode(10002);
        } else {
            resultModel.setCode(10006);
        }
        resultModel.setData(null);
        return ResultModelTool.handleResultModel(resultModel);
    }

    @RequestMapping(value = "/json", method = RequestMethod.POST)
    @ResponseBody
    public ResultModel json(HttpServletRequest request) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String body = IOUtils.read(reader);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(10002);
        resultModel.setData(body);
        return ResultModelTool.handleResultModel(resultModel);
    }


}
