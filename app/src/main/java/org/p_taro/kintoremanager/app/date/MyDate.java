package org.p_taro.kintoremanager.app.date;

import java.util.Calendar;
//
// DispDate.java
//
// 日付を表示するクラス
public class MyDate{

	public MyDate() {
		// TODO 自動生成されたコンストラクター・スタブ
	}



	public String getDateToday(){
		Calendar cal = Calendar.getInstance();
		String date;
		int year = cal.get(Calendar.YEAR);
    	int month = cal.get(Calendar.MONTH) + 1;
    	int day = cal.get(Calendar.DATE);
    	String dow;
    	switch(cal.get(Calendar.DAY_OF_WEEK)){
    	case Calendar.SUNDAY:
    		dow = "日";
    		break;
    	case Calendar.MONDAY:
    		dow = "月";
    		break;
    	case Calendar.TUESDAY:
    		dow = "火";
    		break;
    	case Calendar.WEDNESDAY:
    		dow = "水";
    		break;
    	case Calendar.THURSDAY:
    		dow = "木";
    		break;
    	case Calendar.FRIDAY:
    		dow = "金";
    		break;
    	case Calendar.SATURDAY:
    		dow = "土";
    		break;
    	default:
    		dow = "?";
    		break;
    	}

    	date = year + "/" + month + "/" + day + "(" + dow + ")";

		return date;

	}

}
