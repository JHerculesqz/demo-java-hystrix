package com.huawei.server.wow.provider;

import com.huawei._1_fw.component.http.HttpUtilsEx;
import com.huawei.server.trandition.vo.SimpleDemoResVo;
import com.huawei.server.trandition.vo.SimpleDemoVo;

public class MainProvider {
	// #region Const

	public static final String URL_CLIENT_DOSTHFINISH = "http://localhost:7000/hystrix/client/wow/doSthFinish";
	public static final String URL_CLIENT_DOSTHFAIL = "http://localhost:7000/hystrix/client/wow/doSthFail";

	// #endregion

	// #region Fields

	private static int crazyMode;

	// #endregion

	// #region doSth

	public static SimpleDemoResVo doSth(SimpleDemoVo oSimpleDemoVo) {
		crazyMode = oSimpleDemoVo.getCrazyMode();

		if (1 == crazyMode) {
			try {
				Thread.sleep(30 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (3 == crazyMode) {
			System.out.println(3 / 0);// ÅªËÀ×Ô¼º
		} else {
			while (true) {
				System.out.println("I am crazy robot...");
				if (2 == crazyMode) {
					System.out.println("I am ok now...");
					break;
				}
			}
		}
		SimpleDemoResVo oSimpleDemoResVo = HttpUtilsEx.postByTemplate(URL_CLIENT_DOSTHFINISH, oSimpleDemoVo,
				SimpleDemoResVo.class);
		oSimpleDemoResVo.setMsg(oSimpleDemoVo.getMsg());
		return oSimpleDemoResVo;
	}

	public static SimpleDemoResVo doSthFallback(SimpleDemoVo oSimpleDemoVo) {
		String msg = "doSthFallback:" + oSimpleDemoVo.getMsg();
		System.out.println(msg);
		oSimpleDemoVo.setMsg(msg);
		SimpleDemoResVo oSimpleDemoResVo = HttpUtilsEx.postByTemplate(URL_CLIENT_DOSTHFAIL, oSimpleDemoVo,
				SimpleDemoResVo.class);
		return oSimpleDemoResVo;
	}

	// #endregion
}
