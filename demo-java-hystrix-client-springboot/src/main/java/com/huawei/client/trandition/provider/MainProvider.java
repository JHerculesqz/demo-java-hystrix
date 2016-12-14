package com.huawei.client.trandition.provider;

import com.huawei._1_fw.component.http.HttpUtilsEx;
import com.huawei.client.trandition.vo.SimpleDemoResVo;
import com.huawei.client.trandition.vo.SimpleDemoVo;

public class MainProvider {
	// #region Const

	public static final String URL_SERVER_DOSTH = "http://localhost:8000/hystrix/server/trandition/doSth";

	// #endregion

	// #region doSth

	public static SimpleDemoResVo doSth(SimpleDemoVo oSimpleDemoVo) {
		System.out.println("buData:" + oSimpleDemoVo.getMsg());
		SimpleDemoResVo oSimpleDemoResVo = HttpUtilsEx.postByTemplate(URL_SERVER_DOSTH, oSimpleDemoVo,
				SimpleDemoResVo.class);
		return oSimpleDemoResVo;
	}

	public static SimpleDemoResVo doSthFallback(SimpleDemoVo oSimpleDemoVo) {
		System.out.println("fallBack:" + oSimpleDemoVo.getMsg());

		// 继续做异常处理或向前推送消息
		SimpleDemoResVo oSimpleDemoResVo = new SimpleDemoResVo();
		oSimpleDemoResVo.setMsg("doSthFallback");
		return oSimpleDemoResVo;
	}

	// #endregion
}
