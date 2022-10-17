package com.crm.Generic_utilities;

import java.util.Random;

public class Java_Utiltity {

	public int getRanDomNum()
	{
		Random ran = new Random();
		int RanNum = ran.nextInt(1000);
		return RanNum;
		}

}
