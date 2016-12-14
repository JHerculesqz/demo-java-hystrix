package com.huawei.server.wow;

import org.springframework.stereotype.Service;

import com.huawei.server.trandition.vo.SimpleDemoResVo;
import com.huawei.server.trandition.vo.SimpleDemoVo;
import com.huawei.server.wow.provider.MainProvider;

@Service
public class HystrixServer4WowService {
	// #region doSth

	public SimpleDemoResVo doSth(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.doSth(oSimpleDemoVo);
	}

	public SimpleDemoResVo doSthFallback(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.doSthFallback(oSimpleDemoVo);
	}

	// #endregion
}
