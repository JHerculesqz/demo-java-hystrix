package com.huawei.client;

import org.springframework.stereotype.Service;

import com.huawei.client.provider.MainProvider;
import com.huawei.client.vo.SimpleDemoResVo;
import com.huawei.client.vo.SimpleDemoVo;

@Service
public class HystrixClientService {
	// #region simpleDemo

	public SimpleDemoResVo simpleDemo(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.simpleDemo(oSimpleDemoVo);
	}

	// #endregion

	// #region executeMode

	// #region executeModeSync

	public SimpleDemoResVo executeModeSync(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.executeModeSync(oSimpleDemoVo);
	}

	// #endregion

	// #region executeModeASync

	public SimpleDemoResVo executeModeASync(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.executeModeASync(oSimpleDemoVo);
	}

	// #endregion

	// #region executeModeReact

	public void executeModeReact(SimpleDemoVo oSimpleDemoVo) {
		MainProvider.executeModeReact(oSimpleDemoVo);
	}

	// #endregion

	// #endregion

	// #region isolate

	// #region threadPoolIsolate

	public SimpleDemoResVo threadPoolIsolate(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.threadPoolIsolate(oSimpleDemoVo);
	}

	// #endregion

	// #region semaphoreIsolate

	public SimpleDemoResVo semaphoreIsolate(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.semaphoreIsolate(oSimpleDemoVo);
	}

	// #endregion

	// #endregion
}
