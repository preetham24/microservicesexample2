package com.pbuserservice.user.service;

import com.pbuserservice.user.VO.Department;
import com.pbuserservice.user.VO.ResponseTemplateVO;
import com.pbuserservice.user.entity.User;
import com.pbuserservice.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department department =  restTemplate.getForObject("http://localhost:9001/departments/"+userId,Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return  vo;
    }
}
