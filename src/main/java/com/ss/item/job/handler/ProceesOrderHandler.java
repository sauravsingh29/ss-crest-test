/**
 * 
 */
package com.ss.item.job.handler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ss.item.ItemInfo;
import com.ss.item.job.JobHandler;
import com.ss.item.request.Order;
import com.ss.item.response.OrderResponse;

/**
 * @author Saurav
 *
 */
public class ProceesOrderHandler implements JobHandler {

	private JobHandler handler;

	@Override
	public void setNext(JobHandler nextJob) {
		this.handler = nextJob;
	}

	@Override
	public OrderResponse process(Object input) {
		@SuppressWarnings("unchecked")
		final Map<String, Integer> request = (Map<String, Integer>) input;
		final List<Order> orderRequests = request.entrySet().stream()
				.map(r -> new Order(ItemInfo.valueOf(r.getKey()).item(), r.getValue(),
						ItemInfo.valueOf(r.getKey()).price() * r.getValue()))
				.collect(Collectors.toList());
		if (null != this.handler) {
			return this.handler.process(orderRequests);
		}
		return null;
	}

}
