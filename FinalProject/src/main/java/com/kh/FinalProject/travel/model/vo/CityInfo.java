package com.kh.FinalProject.travel.model.vo;

import java.io.Serializable;

public class CityInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7036165609208744638L;
	private String cityName;	// 지역코드
	private String addr;
	private String cimgSrc;
	private String xpoint;
	private String ypoint;
	private String tcode;
	
	public CityInfo() {}

	public CityInfo(String cityName, String addr, String cimgSrc, String xpoint, String ypoint, String tcode) {
		this.cityName = cityName;
		this.addr = addr;
		this.cimgSrc = cimgSrc;
		this.xpoint = xpoint;
		this.ypoint = ypoint;
		this.tcode = tcode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCimgSrc() {
		return cimgSrc;
	}

	public void setCimgSrc(String cimgSrc) {
		this.cimgSrc = cimgSrc;
	}

	public String getXpoint() {
		return xpoint;
	}

	public void setXpoint(String xpoint) {
		this.xpoint = xpoint;
	}

	public String getYpoint() {
		return ypoint;
	}

	public void setYpoint(String ypoint) {
		this.ypoint = ypoint;
	}

	public String getTcode() {
		return tcode;
	}

	public void setTcode(String tcode) {
		this.tcode = tcode;
	}

	@Override
	public String toString() {
		return "CityInfo [cityName=" + cityName + ", addr=" + addr + ", cimgSrc=" + cimgSrc + ", xpoint=" + xpoint
				+ ", ypoint=" + ypoint + ", tcode=" + tcode + "]";
	}
}
	
	
	