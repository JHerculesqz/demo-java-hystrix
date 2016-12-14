package com.huawei.server.trandition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei.server.trandition.vo.SimpleDemoResVo;
import com.huawei.server.trandition.vo.SimpleDemoVo;

@Controller
@EnableAutoConfiguration
public class HystrixServer4TranditionController {
	// #region Fields

	@Autowired
	public HystrixServer4TranditionService hystrixServerService;

	// #endregion

	// #region doSth

	@RequestMapping("hystrix/server/trandition/doSth")
	@ResponseBody
	public SimpleDemoResVo doSth(@RequestBody SimpleDemoVo oSimpleDemoVo) {
		return hystrixServerService.doSth(oSimpleDemoVo);
	}

	// #endregion
}
