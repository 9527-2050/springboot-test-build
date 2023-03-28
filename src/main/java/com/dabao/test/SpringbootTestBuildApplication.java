package com.dabao.test;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootTestBuildApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTestBuildApplication.class, args);
	}

	
    /**
     * Hello，World
     *
     * @param who 参数，非必须
     * @return Hello, ${who}
     */
    @GetMapping("/hello")
    public String sayHello(@RequestParam(required = false, name = "who") String who,HttpServletResponse response) {
        if (who == null || who.length() == 0) {
            who = "World";
        }
        Cookie cookie = new Cookie("userName", "zhangsan");
        response.addCookie(cookie);
        
        return "Hello, " + who;
    }
}
