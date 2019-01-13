package com.linxiaomi.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

// 将服务发布出去(注意service的包名)
@Service
@Component
public class TicketServiceImpl implements TicketService {

    @Override
    public String getTicket() {
        return "<指环王>";
    }
}
