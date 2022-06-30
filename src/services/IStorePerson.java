package services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService // expose all public methods on bean as a web service
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, // content of body is valid xml file
        use = SOAPBinding.Use.LITERAL, // how data of soap message is streamed
        parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)    //all input/output parameters wrapped into single element on request/response message
public interface IStorePerson {
    @WebMethod
    List<Person> filter(List<Person> list);

    @WebMethod
    List<Person> filter1(FilterRequest request);
}
