package com.cmsJsf;

import java.util.concurrent.TimeUnit;

import org.primefaces.component.schedule.Schedule;

public class OrderMain {
	
	public static void main(String[] args) {
		
		OrdersDAOImpl impl = new OrdersDAOImpl();
		
		String order = impl.placeOrder(4, 7, 75, "PAYTM", 3, "NIL");
		System.out.println(order);
		System.out.println(TimeUnit.MINUTES);
		impl.getService().schedule(new Runnable() {
			
			@Override
			public void run() {
				impl.autoCancelOrder(75);
				
				
			}
		}, 1, TimeUnit.MINUTES);
		impl.getService().shutdown();
		impl.autoCancelOrder(75);
	}
	

}
