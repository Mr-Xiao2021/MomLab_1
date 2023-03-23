package com.xxr.momlab_1.controller;

import com.xxr.momlab_1.listener.MsgConsumer;
import com.xxr.momlab_1.listener.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName ChatController
 * Description  TODO
 *
 * @author Mr_X
 * @version 1.0
 * @date 2023/3/23 15:19
 */
@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private MsgConsumer receiver;

    @Autowired
    private MsgProducer sender;

    @GetMapping("/sender/{message}")
    public String send(@PathVariable("message") String msg) throws IOException {

        sender.testProduce(msg);
        return msg+"( Sending completed! )";
    }


    @GetMapping("/receive")
    public String receive() throws IOException {
        return receiver.getRes();
    }

}
