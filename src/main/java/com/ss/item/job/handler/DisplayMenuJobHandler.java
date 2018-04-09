/**
 * 
 */
package com.ss.item.job.handler;

import com.ss.item.constants.ItemInfo;
import com.ss.item.job.JobHandler;
import com.ss.item.response.OrderResponse;

/**
 * @author Saurav Singh
 *
 */
public class DisplayMenuJobHandler implements JobHandler {

    private static final String DISPLAY_FORMAT = "| %-15s | %-20s | %-15s |%n";

    private JobHandler          handler;

    @Override
    public void setNext(JobHandler nextJob) {
        this.handler = nextJob;
    }

    @Override
    public OrderResponse process(Object input) {
        System.out.format("|-----------------|----------------------|-----------------|%n");
        System.out.format(DISPLAY_FORMAT, "Item Code", "Item Name", "Price (INR)");
        System.out.format("|-----------------|----------------------|-----------------|%n");
        for (ItemInfo info : ItemInfo.values()) {
            System.out.format(DISPLAY_FORMAT, info.name(), info.item(), info.price());
        }
        System.out.format("|-----------------|----------------------|-----------------|%n");
        System.out.println(" ");
        if (null != this.handler) {
            return this.handler.process(input);
        }
        return null;
    }

}
