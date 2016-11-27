package com.huawei.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei.client.vo.SimpleDemoResVo;
import com.huawei.client.vo.SimpleDemoVo;

@Controller
@EnableAutoConfiguration
public class HystrixClientController {
	// #region Fields

	@Autowired
	public HystrixClientService hystrixClientService;

	// #endregion

	// #region simpleDemo

	@RequestMapping("hystrix/client/simpledemo")
	@ResponseBody
	public SimpleDemoResVo simpleDemo(@RequestBody SimpleDemoVo oSimpleDemoVo) {
		return hystrixClientService.simpleDemo(oSimpleDemoVo);
	}

	// #endregion

	// #region executeMode

	// #region executeModeSync

	@RequestMapping("hystrix/client/executeModeSync")
	@ResponseBody
	public SimpleDemoResVo executeModeSync(@RequestBody SimpleDemoVo oSimpleDemoVo) {
		return hystrixClientService.executeModeSync(oSimpleDemoVo);
	}

	// #endregion

	// #region executeModeASync

	@RequestMapping("hystrix/client/executeModeASync")
	@ResponseBody
	public SimpleDemoResVo executeModeASync(@RequestBody SimpleDemoVo oSimpleDemoVo) {
		return hystrixClientService.executeModeASync(oSimpleDemoVo);
	}

	// #endregion

	// #region executeModeReact

	@RequestMapping("hystrix/client/executeModeReact")
	@ResponseBody
	public void executeModeReact(@RequestBody SimpleDemoVo oSimpleDemoVo) {
		hystrixClientService.executeModeReact(oSimpleDemoVo);
	}

	// #endregion

	// #endregion

	// #region isolate

	// #region threadPoolIsolate

	@RequestMapping("hystrix/client/threadPoolIsolate")
	@ResponseBody
	public SimpleDemoResVo threadPoolIsolate(@RequestBody SimpleDemoVo oSimpleDemoVo) {
		return hystrixClientService.threadPoolIsolate(oSimpleDemoVo);
	}

	// #endregion

	// #region semaphoreIsolate

	@RequestMapping("hystrix/client/semaphoreIsolate")
	@ResponseBody
	public SimpleDemoResVo semaphoreIsolate(@RequestBody SimpleDemoVo oSimpleDemoVo) {
		return hystrixClientService.semaphoreIsolate(oSimpleDemoVo);
	}

	// #endregion

	// #endregion
}
