package ru.rsatu.ws;

import ru.rsatu.pojo.SomeData;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;



@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface IServiceTest {

    // говорим, что этот метод можно вызывать удаленно
    @WebMethod
    public SomeData testMethod(SomeData data);
}