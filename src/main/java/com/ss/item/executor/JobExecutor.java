package com.ss.item.executor;

import java.util.Scanner;

import com.ss.item.job.JobHandler;
import com.ss.item.job.handler.DisplayMenuJobHandler;
import com.ss.item.job.handler.FirstDiscountCalculator;
import com.ss.item.job.handler.InputJobHandler;
import com.ss.item.job.handler.ProceesOrderHandler;
import com.ss.item.job.handler.SecondDiscountCalculator;
import com.ss.item.response.OrderResponse;

public class JobExecutor {
    
    public static void main(String[] args) {
        final OrderResponse orderResponse = setupJob();
        orderResponse.display();
        // If someone wants to enable Html output
        // System.out.println(orderResponse.toHtml());
    }

    /**
     * Setup job handlers and start job execution
     * 
     * @return {@link OrderResponse}
     */
    private static OrderResponse setupJob() {
        JobHandler dispJobHandler = new DisplayMenuJobHandler();
        JobHandler inpHandler = new InputJobHandler();
        dispJobHandler.setNext(inpHandler);
        JobHandler procInpHandler = new ProceesOrderHandler();
        inpHandler.setNext(procInpHandler);
        JobHandler firstDisHandler = new FirstDiscountCalculator();
        procInpHandler.setNext(firstDisHandler);
        JobHandler secDisHandler = new SecondDiscountCalculator();
        firstDisHandler.setNext(secDisHandler);
        Scanner scanner = new Scanner(System.in);
        final OrderResponse orderResponse = dispJobHandler.process(scanner);
        return orderResponse;
    }
}
