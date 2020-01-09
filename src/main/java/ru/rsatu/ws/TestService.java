package ru.rsatu.ws;

import ru.rsatu.pojo.SomeData;

import javax.jws.WebService;

@WebService(endpointInterface = "ru.rsatu.ws.IServiceTest")
public class TestService implements IServiceTest {

    public SomeData testMethod(SomeData data) {
        System.out.println("processOrder called for customer"
                + data.getStr());


        data.setNuber(228);

        return data;
    }
}
