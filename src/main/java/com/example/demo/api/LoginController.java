package com.example.demo.api;

import com.example.demo.model.Employee;
import com.example.demo.model.LoginInfo;
import com.example.demo.repository.LoginRepository;
import com.example.demo.service.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Log4j2
@RestController
public class LoginController {
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    private LoginService loginService;
    /**
     * login
     */

    @PostMapping("/api/login")
    public ResponseEntity<String> Login(@RequestBody LoginInfo user) {
        try {
            LoginInfo e = loginService.checkLogin(user);
            loginRepository.insert(e);
            e.setMessage("OK");
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            Employee em = new Employee();
            em.setMessage("EXIST");
            return ResponseEntity.ok("Error");
        }
    }
}
