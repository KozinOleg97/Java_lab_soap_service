package ru.rsatu.ws;

import org.apache.log4j.Logger;
import ru.rsatu.exeptions.EditError;
import ru.rsatu.pojo.Faculty;
import ru.rsatu.pojo.Group;
import ru.rsatu.pojo.Student;
import ru.rsatu.pojo.University;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

@WebService(serviceName = "Test", portName = "Test")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class XMLServiceImpl  {

    private static final Logger log = Logger.getLogger(XMLServiceImpl.class);

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


    public University getUniversity() throws EditError {
        log.info("getUniversity call");
        University res = null;
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(University.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            res = (University) un.unmarshal(new File(getResPath("FinalEditedXML4.xml")));
        } catch (JAXBException e) {

            log.error("getUniversity err ", e);
            throw new EditError();
        }

        log.info("getUniversity return " + res.toString());
        return res;


    }


    public Student getStudent() throws EditError {
        log.info("getStudent call");

        University university = getUniversity();

        List<Faculty> facultyList = university.getAdministration().getDepartmentOfScientific().getFaculty();
        Faculty faculty = facultyList.get(0);
        List<Group> groupList = faculty.getKafedra().getGroup();
        Student student = groupList.get(0).getStudents().get(0);
        return student;


    }


    public University getUniversityWithErr() throws EditError {
        log.error("myErr");
        throw new EditError();

        //return null;
    }


}
