package com.huawei.client.trandition;

import org.springframework.stereotype.Service;

import com.huawei.client.trandition.provider.MainProvider;
import com.huawei.client.trandition.vo.SimpleDemoResVo;
import com.huawei.client.trandition.vo.SimpleDemoVo;

@Service
public class HystrixClient4TranditionService {
	// #region doSth

	public SimpleDemoResVo doSth(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.doSth(oSimpleDemoVo);
	}

	public SimpleDemoResVo doSthFallback(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.doSthFallback(oSimpleDemoVo);
	}

	// #endregion
}
