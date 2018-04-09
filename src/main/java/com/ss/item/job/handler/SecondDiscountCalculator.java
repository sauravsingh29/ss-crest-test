/**
 * 
 */
package com.ss.item.job.handler;

import static com.ss.item.constants.DiscountConstants.MAX_DISCOUNT_LIMIT;
import static com.ss.item.constants.DiscountConstants.TWENTY_DISCOUNT_BUCKET;

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
public class SecondDiscountCalculator implements JobHandler {

    @Override
    public void setNext(JobHandler nextJob) {
        // TODO: Setup next job if needed.
    }

    @Override
    public OrderResponse process(Object input) {
        @SuppressWarnings("unchecked")
        final List<Order> orders = (List<Order>) input;
        double sum = orders.stream().collect(Collectors.summingDouble(or -> or.getPrice()));
        float total = (float) sum;
        if (total > MAX_DISCOUNT_LIMIT) {
            float amountOverDiscount = ((total - 200) * 20) / 100;
            float discount = 20 + amountOverDiscount;
            float finalAmount = total - discount;
            return new OrderResponse(orders, total, discount, finalAmount, TWENTY_DISCOUNT_BUCKET);
        }
        return null;
    }

}
