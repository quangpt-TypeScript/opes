package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.LoginInfo;
import com.example.demo.repository.LoginRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Service
@Log4j2
public class LoginService {
    private final LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public LoginInfo checkLogin(LoginInfo request) throws Exception {
        log.debug(request);
        LoginInfo user = loginRepository.findByEmail(request.getEmail());
        if (user == null) {
            throw new Exception("Email does not exist");
        } else if (!(user.getPassword().equals(request.getPassword()))) {
            throw new Exception("Password not true");
        }
        return user;
    }
}
