package com.huawei.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei.server.vo.SimpleDemoResVo;
import com.huawei.server.vo.SimpleDemoVo;

@Controller
@EnableAutoConfiguration
public class HystrixServerController {
	// #region Fields

	@Autowired
	public HystrixServerService hystrixServerService;

	// #endregion

	// #region crazyFunc

	@RequestMapping("hystrix/server/crazyfunc")
	@ResponseBody
	public SimpleDemoResVo crazyFunc(@RequestBody SimpleDemoVo oSimpleDemoVo) {
		return hystrixServerService.crazyFunc(oSimpleDemoVo);
	}

	// #endregion

}
