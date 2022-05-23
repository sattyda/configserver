package springcofing.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springcofing.client.entities.Subscription;
import springcofing.client.repos.SubRepo;
import springcofing.client.utilities.Response;

@Service
public class SubService {

    @Autowired
    SubRepo subRepo;

    public void save(Subscription subscription) {
        subRepo.save(subscription);
    }
}
