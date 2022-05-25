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

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/api/read")
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

    @GetMapping(value = { "/api/read/json" , "/api/read/josn/{id}" })
    public List<Subscription> myread(@PathVariable("id") Optional<Long> id ) {
        if(id.isPresent()) {
            Subscription subscription =  subService.get(id.get());
            List<Subscription> list = new ArrayList<>();
            if(subscription != null) {
                list.add(subscription);
            }
            return list;
        } else {
            return subService.getall();
        }
    }

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
