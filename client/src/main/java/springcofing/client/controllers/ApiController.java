package springcofing.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/api/read")
    public Subscription read(@RequestParam("id") Long id ) {
//        subService.save(subscription);

        Subscription subscription =  subService.get(id);

        return subscription;
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
