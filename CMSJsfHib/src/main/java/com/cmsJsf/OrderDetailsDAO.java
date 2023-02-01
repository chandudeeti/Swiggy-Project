package com.cmsJsf;

import java.util.Date;

public interface OrderDetailsDAO {

	String placeOrder(int custId, int venId, int menuId, String walSource,int qty, String ordComments);
}
