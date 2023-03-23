package com.xxr.momlab_1.listener;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.apache.activemq.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * ClassName MsgConsumer
 * Description  TODO
 *
 * @author Mr_X
 * @version 1.0
 * @date 2023/3/23 15:56
 */
@Component
public class MsgConsumer {
    private String res;
    @JmsListener(destination = "lab1_queue")
    public void receiveMsg(Message message) throws JMSException {
        if(message instanceof TextMessage){
            TextMessage textMessage = (TextMessage) message;
            res = "New Message: " + textMessage.getText();
            System.out.println(res);
        }else{
            res = "";
        }
    }

    public String getRes() {
        return res;
    }
}
