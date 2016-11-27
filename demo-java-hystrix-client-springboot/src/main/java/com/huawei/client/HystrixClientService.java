package com.huawei.client;

import org.springframework.stereotype.Service;

import com.huawei.client.provider.MainProvider;
import com.huawei.client.vo.SimpleDemoResVo;
import com.huawei.client.vo.SimpleDemoVo;

@Service
public class HystrixClientService {
	// #region isolate

	// #region threadPoolIsolate

	public SimpleDemoResVo threadPoolIsolate(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.threadPoolIsolate(oSimpleDemoVo);
	}

	public SimpleDemoResVo threadPoolIsolateFallback(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.threadPoolIsolateFallback(oSimpleDemoVo);
	}

	// #endregion

	// #endregion
}
