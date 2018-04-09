/**
 * 
 */
package com.ss.item.job;

import com.ss.item.response.OrderResponse;

/**
 * @author Saurav
 *
 */
public interface JobHandler {

    public void setNext(JobHandler nextJob);

    public OrderResponse process(Object input);
}
