/**
 * 
 */
package com.atroshonok.command.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.atroshonok.command.ActionCommand;
import com.atroshonok.entities.Product;
import com.atroshonok.services.ProductService;
import com.atroshonok.utilits.ConfigurationManager;

/**
 * @author Atroshonok Ivan
 *
 */
public class ShowAllProductsCommand implements ActionCommand {

	private static final String SESSION_ATTR_NAME_PRODUCTSLIST = "productsList";

	/* (non-Javadoc)
	 * @see atroshonok.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request) {
		
		ProductService productService = new ProductService();
		List<Product> products = productService.getAllProducts();
		
		request.setAttribute("fragmentPath", ConfigurationManager.getProperty("path.fragment.allproducts"));
		request.getSession().setAttribute(SESSION_ATTR_NAME_PRODUCTSLIST, products);
		String page = ConfigurationManager.getProperty("path.page.admin"); 
		
		return page;
	}

}
