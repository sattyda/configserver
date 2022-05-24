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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WebService {

    @Autowired
    RestTemplate restTemplate;

    public List<Subscription> getall() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity entity = new HttpEntity<Subscription>( new Subscription( 50L , "hisadasdasdsai"), httpHeaders  );

        return restTemplate.exchange( "http://localhost:8080/read" , HttpMethod.POST , entity, ArrayList.class ).getBody();
    }
}
