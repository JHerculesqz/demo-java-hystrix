package com.huawei.server.wow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei._1_fw.core.ioc.IOCUtils;
import com.huawei.server.trandition.vo.SimpleDemoResVo;
import com.huawei.server.trandition.vo.SimpleDemoVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Controller
@EnableAutoConfiguration
public class HystrixServer4WowController {
	// #region Fields

	@Autowired
	public HystrixServer4WowService hystrixServerService;

	// #endregion

	// #region doSth

	@HystrixCommand(groupKey = "doSthGroup4Wow", threadPoolKey = "doSthThreadPool4Wow", commandKey = "doSth4Wow", fallbackMethod = "doSthFallback4Wow", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000") })
	@RequestMapping("hystrix/server/wow/doSth")
	@ResponseBody
	public SimpleDemoResVo doSth(@RequestBody SimpleDemoVo oSimpleDemoVo) {
		return IOCUtils.getInstance().getBean(HystrixServer4WowController.class).doSthInner(oSimpleDemoVo);
	}

	@HystrixCommand(groupKey = "doSthInnerGroup4Wow", threadPoolKey = "doSthInnerThreadPool4Wow", commandKey = "doSthInner4Wow", fallbackMethod = "doSthFallback4Wow", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000") })
	public SimpleDemoResVo doSthInner(SimpleDemoVo oSimpleDemoVo) {
		return hystrixServerService.doSth(oSimpleDemoVo);
	}

	public SimpleDemoResVo doSthFallback4Wow(SimpleDemoVo oSimpleDemoVo) {
		return hystrixServerService.doSthFallback(oSimpleDemoVo);
	}

	// #endregion
}
