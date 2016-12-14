package com.huawei.server.trandition.provider;

import com.huawei.server.trandition.vo.SimpleDemoResVo;
import com.huawei.server.trandition.vo.SimpleDemoVo;

public class MainProvider {
	// #region Fields

	private static int crazyMode;

	// #endregion

	// #region doSth

	public static SimpleDemoResVo doSth(SimpleDemoVo oSimpleDemoVo) {
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
		oSimpleDemoResVo.setMsg(oSimpleDemoVo.getMsg());
		return oSimpleDemoResVo;
	}

	// #endregion
}
