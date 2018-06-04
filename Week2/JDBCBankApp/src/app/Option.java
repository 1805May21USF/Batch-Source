package app;

public class Option {
	private Account.Permission level;
	private int number;
	private String text;
	private String leadsTo;
	
	public Option(Account.Permission level, int number, String text, String leadsTo) {
		this.level = level;
		this.number = number;
		this.text = text;
		this.leadsTo = leadsTo;
	}

	public Account.Permission getLevel() {
		return level;
	}

	public void setLevel(Account.Permission level) {
		this.level = level;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLeadsTo() {
		return leadsTo;
	}

	public void setLeadsTo(String leadsTo) {
		this.leadsTo = leadsTo;
	}
}
