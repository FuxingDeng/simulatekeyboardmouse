package com.liyuncong.learn.simulatekeyboardmouse;

import java.io.IOException;

public class Kill {
	public static void main(String[] args) throws IOException {
	    Runtime runTime = Runtime.getRuntime();

	    //如果使用了ie浏览器和driver     
	    runTime.exec("tskill iexplore");
	    runTime.exec("tskill IEDriverServer");
	}
}
