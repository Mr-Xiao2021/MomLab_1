package com.xxr.momlab_1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;

@SpringBootTest
class MomLab1ApplicationTests {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Test
    public void testProduce(){
        jmsMessagingTemplate.convertAndSend("lab1_queue","a message from sender XXR");
    }

}
