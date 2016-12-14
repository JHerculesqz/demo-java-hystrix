package com.huawei.client.wow;

import org.springframework.stereotype.Service;

import com.huawei.client.trandition.vo.SimpleDemoResVo;
import com.huawei.client.trandition.vo.SimpleDemoVo;
import com.huawei.client.wow.provider.MainProvider;

@Service
public class HystrixClient4WowService {
	// #region doSth

	public SimpleDemoResVo doSth(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.doSth(oSimpleDemoVo);
	}

	public SimpleDemoResVo doSthFallback(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.doSthFallback(oSimpleDemoVo);
	}

	public SimpleDemoResVo doSthFinish(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.doSthFinish(oSimpleDemoVo);
	}

	public SimpleDemoResVo doSthFinishFallback(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.doSthFinishFallback(oSimpleDemoVo);
	}

	public SimpleDemoResVo doSthFail(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.doSthFail(oSimpleDemoVo);
	}

	public SimpleDemoResVo doSthFailFallback(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.doSthFailFallback(oSimpleDemoVo);
	}

	// #endregion
}
