package ru.rsatu.ws;

import ru.rsatu.pojo.Student;
import ru.rsatu.pojo.University;

import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;


@WebService(endpointInterface = "ru.rsatu.ws.IFromXMLService")
public class XMLServiceImpl implements IFromXMLService {

    private String getResPath(String filename) {
        URL resource = this.getClass().getClassLoader().getResource(filename);
        File file = null;
        try {
            file = Paths.get(resource.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        String absolutePath = file.getAbsolutePath();
        return absolutePath;
    }

    @Override
    public University getUniversity() {
        University res = null;
        try {
            // создаем объект JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(University.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            res = (University) un.unmarshal(new File(getResPath("FinalEditedXML4.xml")));
        } catch (JAXBException e) {
            //throw new EditErr("XML Unmarshaller Error");
        }
        return res;


    }

    @Override
    public Student getStudent() {
        Student res = null;
        try {
            // создаем объект JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            res = (Student) un.unmarshal(new File(getResPath("FinalEditedXML4.xml")));
        } catch (JAXBException e) {
            //throw new EditErr("XML Unmarshaller Error");
        }
        return res;
    }


}
