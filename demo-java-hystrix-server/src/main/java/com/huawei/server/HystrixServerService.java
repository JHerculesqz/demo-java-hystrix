package com.huawei.server;

import org.springframework.stereotype.Service;

import com.huawei.server.provider.MainProvider;
import com.huawei.server.vo.SimpleDemoResVo;
import com.huawei.server.vo.SimpleDemoVo;

@Service
public class HystrixServerService {
	// #region crazyFunc

	public SimpleDemoResVo crazyFunc(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.crazyFunc(oSimpleDemoVo);
	}

	// #endregion

}
