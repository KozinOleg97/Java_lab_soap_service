package ru.rsatu;

import ru.rsatu.pojo.University;
import ru.rsatu.ws.XMLServiceImpl;

public class Main {
    public static void main (String[] args){
        XMLServiceImpl xmlService = new XMLServiceImpl();
        University university = xmlService.getUniversity();
        System.out.println();
    }
}
