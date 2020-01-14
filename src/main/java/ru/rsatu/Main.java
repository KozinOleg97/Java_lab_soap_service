package ru.rsatu;

import ru.rsatu.exeptions.EditError;
import ru.rsatu.pojo.University;
import ru.rsatu.ws.XMLServiceImpl;

public class Main {
    public static void main (String[] args){
        XMLServiceImpl xmlService = new XMLServiceImpl();
        try {
            University university = xmlService.getUniversity();
        } catch (EditError editError) {
            editError.printStackTrace();
        }
        System.out.println();
    }
}
