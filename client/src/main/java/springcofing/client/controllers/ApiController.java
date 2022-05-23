package springcofing.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import springcofing.client.entities.Subscription;
import springcofing.client.services.SubService;
import springcofing.client.utilities.Response;

import java.util.List;

@RestController
@Endpoint(id = "subc")
@Component
public class ApiController {

    @Autowired
    SubService subService;

    @ResponseBody
    @PostMapping("/api/add")
    @WriteOperation
    public Response add(@RequestBody Subscription subscription) {
        subService.save(subscription);
        return new Response("success" , "thank you");
    }

    @GetMapping("/api/read")
    @ReadOperation
    public Subscription read(@RequestParam("id") Long id ) {
//        subService.save(subscription);

        Subscription subscription =  subService.get(id);

        return subscription;
    }

    @GetMapping("/api/readall")
    public List<Subscription> readall() {
//        subService.save(subscription);

          return subService.getall();
    }


    @DeleteOperation
    @ResponseBody
    @DeleteMapping("/api/delete")
    public Response delete(@RequestBody Subscription subscription) {
//        subService.save(subscription);

        subService.delete(subscription);

        return new Response("success" , "DELETED");
    }

    @ResponseBody
    @PutMapping("/api/update")
    public Response update(@RequestBody Subscription subscription) {
//        subService.save(subscription);

        subService.update(subscription);

        return new Response("success" , "Updated");
    }

}
