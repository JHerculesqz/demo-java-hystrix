package com.huawei.server.provider;

import com.huawei.server.vo.SimpleDemoResVo;
import com.huawei.server.vo.SimpleDemoVo;

public class MainProvider {
	// #region Fields

	private static int crazyMode;

	// #endregion

	// #region crazyFunc

	public static SimpleDemoResVo crazyFunc(SimpleDemoVo oSimpleDemoVo) {
		crazyMode = oSimpleDemoVo.getCrazyMode();

		if (1 == crazyMode) {
			try {
				Thread.sleep(30 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (3 == crazyMode) {
			System.out.println(3 / 0);// ÅªËÀ×Ô¼º
		} else {
			while (true) {
				System.out.println("I am crazy robot...");
				if (2 == crazyMode) {
					System.out.println("I am ok now...");
					break;
				}
			}
		}

		SimpleDemoResVo oSimpleDemoResVo = new SimpleDemoResVo();
		oSimpleDemoResVo.setName(oSimpleDemoVo.getName());
		return oSimpleDemoResVo;
	}

	// #endregion
}
