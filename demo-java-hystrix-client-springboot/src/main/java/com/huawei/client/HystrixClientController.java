package com.huawei.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei.client.vo.SimpleDemoResVo;
import com.huawei.client.vo.SimpleDemoVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Controller
@EnableAutoConfiguration
public class HystrixClientController {
	// #region Fields

	@Autowired
	public HystrixClientService hystrixClientService;

	// #endregion

	// #region isolate

	// #region threadPoolIsolate

	@HystrixCommand(groupKey = "threadPoolIsolate", threadPoolKey = "threadPoolIsolatePool", commandKey = "threadPoolIsolate", fallbackMethod = "threadPoolIsolateFallback", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000") })
	@RequestMapping("hystrix/client/threadPoolIsolate")
	@ResponseBody
	public SimpleDemoResVo threadPoolIsolate(@RequestBody SimpleDemoVo oSimpleDemoVo) {
		return hystrixClientService.threadPoolIsolate(oSimpleDemoVo);
	}

	public SimpleDemoResVo threadPoolIsolateFallback(SimpleDemoVo oSimpleDemoVo) {
		return hystrixClientService.threadPoolIsolateFallback(oSimpleDemoVo);
	}

	// #endregion

	// #endregion
}
