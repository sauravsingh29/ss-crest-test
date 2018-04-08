/**
 * 
 */
package com.ss.item.job.handler;

import static com.ss.item.DiscountConstants.MAX_DISCOUNT_LIMIT;
import static com.ss.item.DiscountConstants.TEN_DISCOUNT_BUCKET;
import static com.ss.item.DiscountConstants.MIN_DISCOUNT_LIMIT;

import java.util.List;
import java.util.stream.Collectors;

import com.ss.item.job.JobHandler;
import com.ss.item.request.Order;
import com.ss.item.response.OrderResponse;

/**
 * <p>
 * This job handler will calculate discount of total is greater than 200.
 * </p>
 * 
 * @author Saurav
 *
 */
public class FirstDiscountCalculator implements JobHandler {

	private JobHandler handler;

	

	@Override
	public void setNext(JobHandler nextJob) {
		this.handler = nextJob;
	}

	@Override
	public OrderResponse process(Object input) {
		@SuppressWarnings("unchecked")
		final List<Order> orderRequests = (List<Order>) input;
		double sum = orderRequests.stream().collect(Collectors.summingDouble(or -> or.getPrice()));
		float total = (float) sum;
		if (total > MIN_DISCOUNT_LIMIT && total < MAX_DISCOUNT_LIMIT) {
			float discount = (total * 10) / 100;
			float finalAmount = total - discount;
			return new OrderResponse(orderRequests, total, discount, finalAmount, TEN_DISCOUNT_BUCKET);
		} else if (total < MIN_DISCOUNT_LIMIT) {
			return new OrderResponse(orderRequests, total, 0, total, TEN_DISCOUNT_BUCKET);
		}

		if (null != this.handler) {
			return this.handler.process(orderRequests);
		}

		return null;
	}

}
