package springcofing.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springcofing.server.services.WebService;
import springcofing.server.utilities.Response;
import springcofing.server.utilities.Subscription;

import java.util.List;

@RestController
public class WebController {

    @Autowired
    WebService webService;

    public String all(){


        return "all";
    }

    @RequestMapping(value ="/read" , method = RequestMethod.GET)
    public List<Subscription> read(){
        return webService.getall();
    }

}
