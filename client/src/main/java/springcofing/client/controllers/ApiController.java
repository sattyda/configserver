package springcofing.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springcofing.client.entities.Subscription;
import springcofing.client.services.SubService;
import springcofing.client.utilities.Response;

@RestController
public class ApiController {

    @Autowired
    SubService subService;

    @ResponseBody
    @PostMapping("/api/add")
    public Response add(@RequestBody Subscription subscription) {
        subService.save(subscription);

        return new Response("success" , "thank you");
    }
}
