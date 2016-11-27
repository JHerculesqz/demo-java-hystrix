package com.huawei.server.provider;

import com.huawei.server.vo.SimpleDemoResVo;
import com.huawei.server.vo.SimpleDemoVo;

public class MainProvider {
	// #region Fields

	private static boolean recovery;

	// #endregion

	// #region crazyFunc

	public static SimpleDemoResVo crazyFunc(SimpleDemoVo oSimpleDemoVo) {
		recovery = oSimpleDemoVo.isRecovery();

		while (true) {
			System.out.println("I am crazy robot...");
			if (recovery) {
				System.out.println("I am ok now...");
				break;
			}
		}

		SimpleDemoResVo oSimpleDemoResVo = new SimpleDemoResVo();
		oSimpleDemoResVo.setName(oSimpleDemoVo.getName());
		return oSimpleDemoResVo;
	}

	// #endregion
}
