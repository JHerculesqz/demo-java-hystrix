package com.huawei._1_fw.component.http;

import com.huawei._1_fw.core.ioc.IOCUtils;

public class HttpUtilsEx {
	// #region postByTemplate

	public static <T> T postByTemplate(String strUrl, Object oPostParam, Class<T> oResponseClazz) {
		HttpUtilsExBean oHttpUtilsExBean = IOCUtils.getInstance().getBean(HttpUtilsExBean.class);
		return oHttpUtilsExBean.postByTemplate(strUrl, oPostParam, oResponseClazz);
	}

	// #endregion
}
