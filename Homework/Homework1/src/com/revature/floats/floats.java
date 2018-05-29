package com.revature.floats;

public class floats {
	private float length;
	private float width;
	public floats(int length) {
		super();
		this.length = length;
	}
	
	public floats(float length, float width) {
		super();
		this.length = length;
		this.width = width;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

}
