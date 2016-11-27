package com.huawei.client.cmd._2_simple_demo;

import com.huawei.client.vo.SimpleDemoResVo;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class SimpleDemoCmd extends HystrixCommand<SimpleDemoResVo> {
	// #region Construction

	public SimpleDemoCmd(String strGroupKey) {
		super(HystrixCommandGroupKey.Factory.asKey(strGroupKey));
	}

	// #endregion

	// #region run

	@Override
	protected SimpleDemoResVo run() throws Exception {
		SimpleDemoResVo oSimpleDemoResVo = new SimpleDemoResVo();
		oSimpleDemoResVo.setName("Test");
		return oSimpleDemoResVo;
	}

	// #endregion
}
