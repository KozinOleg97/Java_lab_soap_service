package ru.rsatu.ws;

import ru.rsatu.pojo.Student;
import ru.rsatu.pojo.University;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface IFromXMLService {


    University getUniversity();

    Student getStudent();

}
