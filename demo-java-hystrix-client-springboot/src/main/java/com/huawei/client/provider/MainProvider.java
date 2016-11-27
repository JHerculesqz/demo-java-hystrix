package com.huawei.client.provider;

import com.huawei._1_fw.HttpUtilsEx;
import com.huawei.client.vo.SimpleDemoResVo;
import com.huawei.client.vo.SimpleDemoVo;

public class MainProvider {
	// #region isolate

	// #region threadPoolIsolate

	public static SimpleDemoResVo threadPoolIsolate(SimpleDemoVo oSimpleDemoVo) {
		System.out.println("buData:" + oSimpleDemoVo.getName());
		SimpleDemoResVo oSimpleDemoResVo = HttpUtilsEx.postByTemplate("http://localhost:8000/hystrix/server/crazyfunc",
				oSimpleDemoVo, SimpleDemoResVo.class);
		return oSimpleDemoResVo;
	}

	public static SimpleDemoResVo threadPoolIsolateFallback(SimpleDemoVo oSimpleDemoVo) {
		System.out.println("fallBack:" + oSimpleDemoVo.getName());

		// TODO:replace by websocket
		SimpleDemoResVo oSimpleDemoResVo = new SimpleDemoResVo();
		oSimpleDemoResVo.setName("fallback");
		return oSimpleDemoResVo;
	}

	// #endregion

	// #endregion
}
