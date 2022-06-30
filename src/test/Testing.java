package test;

import clients.StorePersonClient;
import org.junit.Assert;
import org.junit.Test;
import services.FilterRequest;
import services.Person;
import services.StorePersonPublisher;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Testing {
    public List<Person> list;
    public StorePersonPublisher publisher;

    public Testing() {
        this.list = new ArrayList<>();
        list.add(new Person("Ron", "Wilson", new GregorianCalendar(2016, Calendar.JANUARY, 25).getTime()));
        list.add(new Person("Anna", "Wilson", new GregorianCalendar(2016, Calendar.JANUARY, 25).getTime()));
        list.add(new Person("Ron", "Wilson", new GregorianCalendar(2017, Calendar.JANUARY, 27).getTime()));
        list.add(new Person("Ron", "Potter", new GregorianCalendar(2017, Calendar.JANUARY, 25).getTime()));
        list.add(new Person("Anna", "Potter", new GregorianCalendar(2017, Calendar.JANUARY, 25).getTime()));
        publisher = new StorePersonPublisher();
        publisher.run(list);    //publish created above list to web service
    }

    @Test
    public void filter() throws MalformedURLException {
        FilterRequest request = new FilterRequest("Wilson", null); //request for finding person from list with surname wilson
        StorePersonClient client = new StorePersonClient(request);
        List<Person> myList = client.new_list;
        Assert.assertNotNull(myList);
        Assert.assertEquals(myList.size(), 2);
    }
}
