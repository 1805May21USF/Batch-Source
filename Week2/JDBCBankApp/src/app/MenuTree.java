package app;

import java.util.Scanner;

public class MenuTree {
	Menu[] menus;

	public MenuTree(Menu[] menus) {
		this.menus = menus;
	}

	//method should display whichever menu name is input
	public String Navigate(String menuName, Scanner scanner, Account user) {
		String[] title = new String[1];
		title[0] = menuName;
		for (int i = 0; i < menus.length; i++) {
			if (menus[i].getTitle().equals(title[0])) {
				title[0] = menus[i].Display(scanner, user);
				return title[0];
			}
		}
		return "error";
	}
}
