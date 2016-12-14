package com.huawei.client.wow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei._1_fw.core.ioc.IOCUtils;
import com.huawei.client.trandition.vo.SimpleDemoResVo;
import com.huawei.client.trandition.vo.SimpleDemoVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Controller
@EnableAutoConfiguration
public class HystrixClient4WowController {
	// #region Fields

	@Autowired
	public HystrixClient4WowService hystrixClientService;

	// #endregion

	// #region doSth

	@HystrixCommand(groupKey = "doSthGroup4Wow", threadPoolKey = "doSthThreadPool4Wow", commandKey = "doSth4Wow", fallbackMethod = "doSthFallback4Wow", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000") })
	@RequestMapping("hystrix/client/wow/doSth")
	@ResponseBody
	public SimpleDemoResVo doSth(@RequestBody SimpleDemoVo oSimpleDemoVo) {
		return IOCUtils.getInstance().getBean(HystrixClient4WowController.class).doSthInner(oSimpleDemoVo);
	}

	@HystrixCommand(groupKey = "doSthInnerGroup4Wow", threadPoolKey = "doSthInnerThreadPool4Wow", commandKey = "doSthInner4Wow", fallbackMethod = "doSthFallback4Wow", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000") })
	public SimpleDemoResVo doSthInner(SimpleDemoVo oSimpleDemoVo) {
		return hystrixClientService.doSth(oSimpleDemoVo);
	}

	public SimpleDemoResVo doSthFallback4Wow(SimpleDemoVo oSimpleDemoVo) {
		return hystrixClientService.doSthFallback(oSimpleDemoVo);
	}

	@HystrixCommand(groupKey = "doSthFinishGroup4Wow", threadPoolKey = "doSthFinishThreadPool4Wow", commandKey = "doSthFinish4Wow", fallbackMethod = "doSthFinishFallback4Wow", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000") })
	@RequestMapping("hystrix/client/wow/doSthFinish")
	@ResponseBody
	public SimpleDemoResVo doSthFinish(@RequestBody SimpleDemoVo oSimpleDemoVo) {
		return IOCUtils.getInstance().getBean(HystrixClient4WowController.class).doSthFinishInner(oSimpleDemoVo);
	}

	@HystrixCommand(groupKey = "doSthFinishInnerGroup4Wow", threadPoolKey = "doSthFinishInnerThreadPool4Wow", commandKey = "doSthFinishInner4Wow", fallbackMethod = "doSthFinishFallback4Wow", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000") })
	public SimpleDemoResVo doSthFinishInner(SimpleDemoVo oSimpleDemoVo) {
		return hystrixClientService.doSthFinish(oSimpleDemoVo);
	}

	public SimpleDemoResVo doSthFinishFallback4Wow(SimpleDemoVo oSimpleDemoVo) {
		return hystrixClientService.doSthFinishFallback(oSimpleDemoVo);
	}

	@HystrixCommand(groupKey = "doSthFailGroup4Wow", threadPoolKey = "doSthFailThreadPool4Wow", commandKey = "doSthFail4Wow", fallbackMethod = "doSthFailFallback4Wow", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000") })
	@RequestMapping("hystrix/client/wow/doSthFail")
	@ResponseBody
	public SimpleDemoResVo doSthFail(@RequestBody SimpleDemoVo oSimpleDemoVo) {
		return IOCUtils.getInstance().getBean(HystrixClient4WowController.class).doSthFailInner(oSimpleDemoVo);
	}

	@HystrixCommand(groupKey = "doSthFailInnerGroup4Wow", threadPoolKey = "doSthFailInnerThreadPool4Wow", commandKey = "doSthFailInner4Wow", fallbackMethod = "doSthFailFallback4Wow", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000") })
	public SimpleDemoResVo doSthFailInner(SimpleDemoVo oSimpleDemoVo) {
		return hystrixClientService.doSthFail(oSimpleDemoVo);
	}

	public SimpleDemoResVo doSthFailFallback4Wow(SimpleDemoVo oSimpleDemoVo) {
		return hystrixClientService.doSthFailFallback(oSimpleDemoVo);
	}

	// #endregion
}
