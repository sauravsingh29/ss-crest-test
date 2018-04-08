/**
 * 
 */
package com.ss.item.job.handler;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.ss.item.ItemInfo;
import com.ss.item.job.JobHandler;
import com.ss.item.response.OrderResponse;

/**
 * @author Saurav
 *
 */
public class InputJobHandler implements JobHandler {

	private JobHandler handler;

	@Override
	public void setNext(JobHandler nextJob) {
		this.handler = nextJob;
	}

	@Override
	public OrderResponse process(Object input) {
		final Map<String, Integer> request = new HashMap<String, Integer>();
		int quntity = 0;
		String moreItem = "No";
		Scanner scanner = (Scanner) input;
		try {
			do {
				System.out.println("Enter item");
				String item = scanner.next();
				boolean itemFound = false;
				for (ItemInfo ii : ItemInfo.values()) {
					if (ii.name().equalsIgnoreCase(item)) {
						System.out.println("Enter item quntity");
						quntity = scanner.nextInt();
						if (request.get(item) != null) {
							request.put(item.toUpperCase(), request.get(item) + quntity);
						} else {
							request.put(item.toUpperCase(), quntity);
						}
						itemFound = true;
					}
				}
				if (!itemFound) {
					System.err.println(MessageFormat.format("No Item Found for {0} code!", item));
				}
				System.out.println("Add another items [Yes or No] ?");
				moreItem = scanner.next();
			} while (moreItem.equalsIgnoreCase("yes"));
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

		if (null != this.handler) {
			return this.handler.process(request);
		}
		return null;
	}

}
