package springcofing.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import springcofing.server.utilities.Response;
import springcofing.server.utilities.Subscription;

import java.util.Arrays;
import java.util.List;

@Service
public class WebService {

    @Autowired
    RestTemplate restTemplate;

    public  Subscription[] getall() {

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity entity = new HttpEntity<>( httpHeaders );

        return restTemplate.exchange( "http://CLIENT/read" , HttpMethod.GET , entity, Subscription[].class ).getBody();
    }

    public Response postadd() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity entity = new HttpEntity<Subscription>(  new Subscription(23L , "testing@gmail.com") , httpHeaders  );

        return restTemplate.exchange( "http://CLIENT/api/add" , HttpMethod.POST , entity, Response.class ).getBody();
    }

    public Response delete() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity entity = new HttpEntity<Subscription>(  new Subscription(23L , "testing@gmail.com") , httpHeaders  );

        return restTemplate.exchange( "http://CLIENT/api/delete" , HttpMethod.DELETE , entity, Response.class ).getBody();
    }

    public Response update() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity entity = new HttpEntity<Subscription>(  new Subscription(23L , "testing@gmail.com") , httpHeaders  );

        return restTemplate.exchange( "http://CLIENT/api/update" , HttpMethod.PUT , entity, Response.class ).getBody();
    }
}
