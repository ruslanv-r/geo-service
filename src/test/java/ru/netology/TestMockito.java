package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import ru.netology.entity.Location;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class TestMockito {

    void testMessageSender(){
        String ip = "172.0.32.11";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");



//        MessageSender messageSender = Mockito.mock(MessageSender.class);
//        Mockito.when(messageSender.send(headers))
//                .thenReturn();


        //Assertions.assertEquals( ,   );


    }


}
