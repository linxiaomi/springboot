package com.linxiaomi.amqp;

import com.linxiaomi.amqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAmqpApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;

	/**
	 * 1、单播(点对点)
	 */
	@Test
	public void contextLoads() {
		// Message需要自己构造一个；定义消息体内容和消息头
//		rabbitTemplate.send(exchange, routeKey, message);

		// object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq
//		rabbitTemplate.convertAndSend(exchange, routeKey, object);

//		Map<String, Object> map = new HashMap<>();
//		map.put("msg", "这是第一个消息");
//		map.put("data", Arrays.asList("hell", "world", true));
//		// 对象被默认序列化以后发送出去
//		rabbitTemplate.convertAndSend("exchange.direct", "linxiaomi.news", map);

		rabbitTemplate.convertAndSend("exchange.direct", "linxiaomi.news", new Book("红楼梦", "曹雪芹"));
	}

	// 接收数据，如何将数据自动的转为json发送出去
	@Test
	public void receive() {
		Object o = rabbitTemplate.receiveAndConvert("linxiaomi.news");
		System.out.println(o.getClass());
		System.out.println(o);
	}

	/**
	 * 广播
	 */
	@Test
	public void sendMsg() {
		rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("红楼梦", "曹雪芹"));
	}

	@Test
	public void createExchange() {
//		amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
		amqpAdmin.declareQueue(new Queue("amqpadmin.queue", true));
		amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE, "amqpadmin.exchange", "amqp.hah", null));
		System.out.println("create success");
	}

}

