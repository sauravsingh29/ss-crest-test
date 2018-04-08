package com.ss.item.executor;

import java.util.Scanner;

import com.ss.item.job.JobHandler;
import com.ss.item.job.handler.FirstDiscountCalculator;
import com.ss.item.job.handler.InputJobHandler;
import com.ss.item.job.handler.ProceesOrderHandler;
import com.ss.item.job.handler.SecondDiscountCalculator;
import com.ss.item.response.OrderResponse;

public class JobExecutor {
	public static void main(String[] args) {
		final OrderResponse orderResponse = setupJob();
		orderResponse.display();
		// System.out.println(orderResponse.toHtml());
	}

	/**
	 * Setup job handlers and start job
	 * 
	 * @return {@link OrderResponse}
	 */
	private static OrderResponse setupJob() {
		JobHandler inpHandler = new InputJobHandler();
		JobHandler procInpHandler = new ProceesOrderHandler();
		inpHandler.setNext(procInpHandler);
		JobHandler firstDisHandler = new FirstDiscountCalculator();
		procInpHandler.setNext(firstDisHandler);
		JobHandler secDisHandler = new SecondDiscountCalculator();
		firstDisHandler.setNext(secDisHandler);
		Scanner scanner = new Scanner(System.in);
		final OrderResponse orderResponse = inpHandler.process(scanner);
		return orderResponse;
	}
}
