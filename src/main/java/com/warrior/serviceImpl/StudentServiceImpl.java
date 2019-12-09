package com.warrior.serviceImpl;

import com.warrior.entity.Student;
import com.warrior.mapper.StudentMapper;
import com.warrior.service.IStudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lqh
 * @since 2018-05-05
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Student> selectStudentByStuName(String Student) {
        return this.baseMapper.selectStudentByStuName(Student);
    }

    @Override
    /*事务回滚*/
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertUser(Student student) {
        return this.baseMapper.insertUser(student);
    }
}
