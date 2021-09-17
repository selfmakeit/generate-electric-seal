package com.hwadee.liferay.electronic.util;

import java.io.Serializable;

public class SealFont implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1765934556474750308L;
	private Boolean bold;
    private String family;
	private Integer margin;
	private Integer size;
	private Double space;
	private String text;

	public SealFont append(String text) {
        this.text += text;
        return this;
    }

	public boolean getBold() {
        return bold == null ? true : bold;
    }

	public String getFamily() {
        return family == null ? "宋体" : family;
    }

	public Integer getMargin() {
		return margin;
	}

	public Integer getSize() {
		return size;
	}

	public Double getSpace() {
		return space;
	}
    public String getText() {
		return text;
	}
    public void setBold(Boolean bold) {
		this.bold = bold;
	}
    public void setFamily(String family) {
		this.family = family;
	}
    public void setMargin(Integer margin) {
		this.margin = margin;
	}
    
    public void setSize(Integer size) {
		this.size = size;
	}

    public void setSpace(Double space) {
		this.space = space;
	}

    public void setText(String text) {
		this.text = text;
	}
}
