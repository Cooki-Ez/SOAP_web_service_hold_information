package services;

import java.util.Date;

    public  class FilterRequest {

    public String surname;
    public Date birthDate;

    public FilterRequest() {
    }

    public FilterRequest(String surname, Date birthDate) {
        this.surname = surname;
        this.birthDate = birthDate;
    }
}
