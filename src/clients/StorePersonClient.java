package clients;

import services.FilterRequest;
import services.IStorePerson;
import services.Person;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class StorePersonClient {
    public  List<Person> new_list;

    public StorePersonClient(FilterRequest request) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/person?wsdl"); //url of wsdl (language that describes functionality of a SOAP based web service)
        QName qname = new QName("http://services/", "StorePersonImplService");//qualified name for xml application (soap service url, port)
        Service service = Service.create(url, qname);//create service with specified url and qualified name
        IStorePerson person = service.getPort(IStorePerson.class); //take instance of web service from port where it is located
        new_list =  person.filter1(request); //filter list with request
    }
}