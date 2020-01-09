package ru.rsatu.client;


import java.net.URL;
import java.net.MalformedURLException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import ru.rsatu.pojo.SomeData;
import ru.rsatu.ws.IServiceTest;

public class TestClient {
    public static void main(String[] args) throws MalformedURLException {
        // WSDL URL
        URL url = new URL("http://localhost:1488/ws/Test?wsdl");

        // Параметры следующего конструктора смотрим в самом первом теге WSDL описания - definitions
        // 1-ый аргумент смотрим в атрибуте targetNamespace
        // 2-ой аргумент смотрим в атрибуте name
        QName qname = new QName("http://ws.rsatu.ru/", "TestServiceService");

        // Теперь мы можем дотянуться до тега service в wsdl описании,
        Service service = Service.create(url, qname);
        // а далее и до вложенного в него тега port, чтобы
        // получить ссылку на удаленный от нас объект веб-сервиса
        IServiceTest testWS = service.getPort(IServiceTest.class);


        SomeData data = new SomeData();
        data.setStr("qweqweqwe!!!");


        data = testWS.testMethod(data);

        System.out.println("String:" + data.getStr() + " , Number: " + data.getNuber());
    }
}