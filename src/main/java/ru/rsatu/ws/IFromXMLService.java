package ru.rsatu.ws;

import ru.rsatu.exeptions.EditError;
import ru.rsatu.pojo.Student;
import ru.rsatu.pojo.University;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface IFromXMLService {


    University getUniversity() throws EditError;

    Student getStudent() throws EditError;

    University getUniversityWithErr() throws EditError;

}
