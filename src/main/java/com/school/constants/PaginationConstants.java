package com.school.constants;

public class PaginationConstants {
	 private static final int BUTTONS_TO_SHOW = 3;
	    private static final int INITIAL_PAGE = 0;
	    private static final int INITIAL_PAGE_SIZE = 5;
	    private static final int[] PAGE_SIZES = { 5, 10};
		public int getBUTTONS_TO_SHOW() {
			return BUTTONS_TO_SHOW;
		}
		public int getINITIAL_PAGE() {
			return INITIAL_PAGE;
		}
		public int getINITIAL_PAGE_SIZE() {
			return INITIAL_PAGE_SIZE;
		}
		public int[] getPAGE_SIZES() {
			return PAGE_SIZES;
		}
}
