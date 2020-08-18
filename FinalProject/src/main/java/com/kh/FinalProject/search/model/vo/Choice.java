package com.kh.FinalProject.search.model.vo;

import java.util.ArrayList;

public class Choice {
		private String city;
		private String month;
		private String theNumber;
		
		public Choice() {
		}

		public Choice(String city, String month, String theNumber, ArrayList<Choice> choice) {
			super();
			this.city = city;
			this.month = month;
			this.theNumber = theNumber;

		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getMonth() {
			return month;
		}

		public void setMonth(String month) {
			this.month = month;
		}

		public String getTheNumber() {
			return theNumber;
		}

		public void setTheNumber(String theNumber) {
			this.theNumber = theNumber;
		}

		@Override
		public String toString() {
			return "Choice [city=" + city + ", month=" + month + ", theNumber=" + theNumber + "]";
		}


		

		
		
		
		
		
}
