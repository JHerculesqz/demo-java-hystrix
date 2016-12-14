package com.huawei.server.trandition;

import org.springframework.stereotype.Service;

import com.huawei.server.trandition.provider.MainProvider;
import com.huawei.server.trandition.vo.SimpleDemoResVo;
import com.huawei.server.trandition.vo.SimpleDemoVo;

@Service
public class HystrixServer4TranditionService {
	// #region doSth

	public SimpleDemoResVo doSth(SimpleDemoVo oSimpleDemoVo) {
		return MainProvider.doSth(oSimpleDemoVo);
	}

	// #endregion
}
