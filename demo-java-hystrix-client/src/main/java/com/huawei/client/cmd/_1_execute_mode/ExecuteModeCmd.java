package com.huawei.client.cmd._1_execute_mode;

import com.huawei.client.vo.SimpleDemoResVo;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class ExecuteModeCmd extends HystrixCommand<SimpleDemoResVo> {
	// #region Construction

	public ExecuteModeCmd(String strGroupKey) {
		super(HystrixCommandGroupKey.Factory.asKey(strGroupKey));
	}

	// #endregion

	// #region run

	@Override
	protected SimpleDemoResVo run() throws Exception {
		SimpleDemoResVo oSimpleDemoResVo = new SimpleDemoResVo();
		oSimpleDemoResVo.setName("ExecuteMode");
		return oSimpleDemoResVo;
	}

	// #endregion
}