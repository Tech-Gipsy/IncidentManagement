package com.bunroo.incidentmanagement.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BaseController {
    @GetMapping
    public String healthCheck()
    {
        return "Hey,I am up";
    }
}
