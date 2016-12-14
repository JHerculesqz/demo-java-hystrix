package com.huawei.client.wow.provider;

import com.huawei._1_fw.component.http.HttpUtilsEx;
import com.huawei.client.trandition.vo.SimpleDemoResVo;
import com.huawei.client.trandition.vo.SimpleDemoVo;

public class MainProvider {
	// #region Const

	public static final String URL_SERVER_DOSTH = "http://localhost:8000/hystrix/server/wow/doSth";

	// #endregion

	// #region doSth

	public static SimpleDemoResVo doSth(SimpleDemoVo oSimpleDemoVo) {
		System.out.println("doSth:" + oSimpleDemoVo.getMsg());
		SimpleDemoResVo oSimpleDemoResVo = HttpUtilsEx.postByTemplate(URL_SERVER_DOSTH, oSimpleDemoVo,
				SimpleDemoResVo.class);
		return oSimpleDemoResVo;
	}

	public static SimpleDemoResVo doSthFallback(SimpleDemoVo oSimpleDemoVo) {
		System.out.println("doSthFallback:" + oSimpleDemoVo.getMsg());

		// 继续做异常处理或向前推送消息
		SimpleDemoResVo oSimpleDemoResVo = new SimpleDemoResVo();
		oSimpleDemoResVo.setMsg("doSthFallback");
		return oSimpleDemoResVo;
	}

	public static SimpleDemoResVo doSthFinish(SimpleDemoVo oSimpleDemoVo) {
		System.out.println("doSthFinish:" + oSimpleDemoVo.getMsg());
		SimpleDemoResVo oSimpleDemoResVo = new SimpleDemoResVo();
		oSimpleDemoResVo.setMsg("doSthFinish");
		return oSimpleDemoResVo;
	}

	public static SimpleDemoResVo doSthFinishFallback(SimpleDemoVo oSimpleDemoVo) {
		System.out.println("doSthFinishFallback:" + oSimpleDemoVo.getMsg());

		// 继续做异常处理或向前推送消息
		SimpleDemoResVo oSimpleDemoResVo = new SimpleDemoResVo();
		oSimpleDemoResVo.setMsg("doSthFinishFallback");
		return oSimpleDemoResVo;
	}

	public static SimpleDemoResVo doSthFail(SimpleDemoVo oSimpleDemoVo) {
		// 继续做异常处理或向前推送消息
		SimpleDemoResVo oSimpleDemoResVo = new SimpleDemoResVo();
		oSimpleDemoResVo.setMsg("doSthFail");
		return oSimpleDemoResVo;
	}

	public static SimpleDemoResVo doSthFailFallback(SimpleDemoVo oSimpleDemoVo) {
		// 继续做异常处理或向前推送消息
		SimpleDemoResVo oSimpleDemoResVo = new SimpleDemoResVo();
		oSimpleDemoResVo.setMsg("doSthFailFallback");
		return oSimpleDemoResVo;
	}

	// #endregion
}
