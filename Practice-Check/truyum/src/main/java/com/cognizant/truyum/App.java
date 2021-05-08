package com.cognizant.truyum;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;
import com.cognizant.truyum.util.DateUtil;

@SpringBootApplication
@ComponentScan("com.cognizant.truyum")
public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	// static reference
	private static MenuItemService menuItemService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class, args);

		// assigning from context
		menuItemService = context.getBean(MenuItemService.class);
		
		testSaveMenuItems();
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testGetMenuItem();
		testEditMenuItem();
		LOGGER.info("main end");
	}

	private static void testSaveMenuItems() {
		MenuItemDaoCollectionImpl menuItemDaoCollectionImpl =new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItems = menuItemDaoCollectionImpl.getMenuItemList();
		menuItemService.saveMenuItems(menuItems);
	}
	
	private static void testGetMenuItemListAdmin() {
		LOGGER.info("admin start");
		List<MenuItem> menuItems = menuItemService.getMenuItemListAdmin();
		LOGGER.debug("Menu Item List Admin: {}", menuItems);
		LOGGER.info("admin end");
	}

	private static void testGetMenuItemListCustomer() {
		LOGGER.info("customer start");

		List<MenuItem> menuItems = menuItemService.getMenuItemListCustomer();
		LOGGER.debug("Menu Item List Customer: {}", menuItems);
		LOGGER.info("customer end");
	}

	private static void testGetMenuItem() {
		LOGGER.info("get 1");
		MenuItem menuItem = menuItemService.getMenuItem(1);
		LOGGER.debug("Menu Item: {}", menuItem);
		LOGGER.info("get 1 end");
	}
	
	private static void testEditMenuItem() {
		MenuItem menuItem = new MenuItem(3, "Chocolate Brownie", 32f, "Yes", DateUtil.convertToDate("02/11/2020"), "Dessert",
				"Yes");
		menuItemService.editMenuItem(menuItem);
	}

}
