package com.hwadee.liferay.electronic.util;

import java.io.Serializable;

public class SealCircle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4273662989585432163L;
	private Integer line;
    private Integer width;
    private Integer height;
    
	public Integer getLine() {
		return line;
	}
	public void setLine(Integer line) {
		this.line = line;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
}
