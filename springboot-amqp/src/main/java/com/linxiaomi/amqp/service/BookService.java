package com.linxiaomi.amqp.service;

import com.linxiaomi.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = "linxiaomi.news")
    public void receive(Book book) {
        System.out.println("receive msg " + book);
    }

    @RabbitListener(queues = "linxiaomi")
    public void receive02(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
