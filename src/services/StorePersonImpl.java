package services;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.*;
import java.util.stream.Collectors;

@WebService(name = "IStorePerson")
public class StorePersonImpl implements IStorePerson {


    private final Map<String, List<Person>> _bySurname;
    private final Map<Date, List<Person>> _byBirthDate;

    public StorePersonImpl(List<Person> persons) {
        _bySurname = persons
                .stream()
                .collect(Collectors.groupingBy(person -> person.getSurname()));
        _byBirthDate =  persons.stream()
                .collect(Collectors.groupingBy(person -> person.getBirthDate()));
    }

    @Override
    public List<Person> filter(List<Person> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Person> filter1(FilterRequest request) {
        List<Person> bySurname = request.surname != null
                ? _bySurname.get(request.surname) // if surname in request is not null return persons with this surname
                : _bySurname.values().stream().flatMap(List::stream).collect(Collectors.toList()); //otherwise back to list
        List<Person> byBirthDate = request.birthDate != null
                ? _byBirthDate.get(request.birthDate) // if birthdate in request is not null return persons with this birthdate
                : _byBirthDate.values().stream().flatMap(List::stream).collect(Collectors.toList()); //otherwise back to list

        //List<Person> result =
         return bySurname //
                .stream() //
                .distinct()
                .filter(byBirthDate::contains)
                .collect(Collectors.toList()); //return persons that have surname and birthdate
        //return result;
    }
}