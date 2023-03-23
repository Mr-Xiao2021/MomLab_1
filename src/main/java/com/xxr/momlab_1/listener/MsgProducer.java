package com.xxr.momlab_1.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName MsgProducer
 * Description  TODO
 *
 * @author Mr_X
 * @version 1.0
 * @date 2023/3/23 17:30
 */
@Component
public class MsgProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public void testProduce(String message){
        jmsMessagingTemplate.convertAndSend("lab1_queue",message+
                SIMPLE_DATE_FORMAT.format(new Date()));
    }

}
