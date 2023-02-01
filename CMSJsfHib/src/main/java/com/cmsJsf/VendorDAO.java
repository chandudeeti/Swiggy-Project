package com.cmsJsf;

import java.util.List;

public interface VendorDAO {
	
	String addVendorDao(Vendor vendor);
	String validateMe(Vendor vendor);
	Vendor searchByVendorUser(String userName);
	List<String> showVendorNamesDao();
	Vendor searchByVendorNameDao(String name);

}
