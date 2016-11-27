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

	/**
	 * 0:so crazy<br>
	 * 1:crazy<br>
	 * 2:so crazy to recovery<br>
	 */
	@Setter
	@Getter
	private int crazyMode;

	// #endregion
}
