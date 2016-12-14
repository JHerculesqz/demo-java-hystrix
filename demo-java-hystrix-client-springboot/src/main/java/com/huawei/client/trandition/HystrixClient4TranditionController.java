package com.huawei.client.trandition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei.client.trandition.vo.SimpleDemoResVo;
import com.huawei.client.trandition.vo.SimpleDemoVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Controller
@EnableAutoConfiguration
public class HystrixClient4TranditionController {
	// #region Fields

	@Autowired
	public HystrixClient4TranditionService hystrixClientService;

	// #endregion

	// #region doSth

	@HystrixCommand(groupKey = "doSthGroup", threadPoolKey = "doSthThreadPool", commandKey = "doSth", fallbackMethod = "doSthFallback", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000") })
	@RequestMapping("hystrix/client/trandition/doSth")
	@ResponseBody
	public SimpleDemoResVo doSth(@RequestBody SimpleDemoVo oSimpleDemoVo) {
		return hystrixClientService.doSth(oSimpleDemoVo);
	}

	public SimpleDemoResVo doSthFallback(SimpleDemoVo oSimpleDemoVo) {
		return hystrixClientService.doSthFallback(oSimpleDemoVo);
	}

	// #endregion
}
