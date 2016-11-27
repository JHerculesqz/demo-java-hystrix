package com.huawei.server.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SimpleDemoVo {
	// #region Fields

	@Setter
	@Getter
	private String name;

	@Setter
	@Getter
	private boolean recovery;

	// #endregion
}
