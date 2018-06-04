package app;

import java.util.Scanner;

public class Menu {
	//title is how the menu will be found
	private String title;
	
	//text is the user instructions
	private String text;
	
	//options are the numbered choices
	private Option[] options;
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Option[] getOptions() {
		return options;
	}
	
	public void setOptions(Option[] options) {
		this.options = options;
	}

	public Menu(String title, String text, Option[] options) {
		this.title = title;
		this.text = text;
		this.options = options;
	}
	
	public static String Display(String text, Option[] options, Scanner scanner, Account user) {
		while (true) {
			System.out.println(text);
			System.out.println("");
			for (int i = 0; i < options.length; i++) {
				if (user.getAccessLevel().ordinal() >= options[i].getLevel().ordinal())
				System.out.println(options[i].getNumber() + " - " + options[i].getText());
			}
			System.out.println("");
			
			//need to add input validation
			int input = Integer.parseInt(scanner.nextLine());
			return options[input - 1].getLeadsTo();
		}
	}
	
	public String Display(Scanner scanner, Account user) {
		return Display(this.text, this.options, scanner, user);
	}
	
}
