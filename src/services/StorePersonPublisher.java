package services;

import javax.xml.ws.Endpoint;
import java.util.List;

public class StorePersonPublisher {
    public void run(List<Person> persons){
        Endpoint.publish("http://localhost:8080/person", //address where webservice deployed
                new StorePersonImpl(persons));
    }
}