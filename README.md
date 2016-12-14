#设计目标#
验证调用方使用Hystrix、服务端也使用Hystrix的情况下，如何通过HystrixDashboard观测熔断、熔断恢复过程

#实现步骤(SpringBoot版本)#
##1.常规模式(仅调用方使用Hystrix)##
###1.1.Dashboard###
**STEP1.build.gralde引用jar**
	
	compile('org.springframework.cloud:spring-cloud-starter-hystrix')
	compile('org.springframework.cloud:spring-cloud-starter-hystrix-dashboard')
	
**STEP2.在XXXApplication.java中@EnableHystrixDashboard**

**STEP3.运行，http://localhost:9000/hystrix**

###1.2.调用方###
**STEP1.build.gradle引用jar**
	
	compile('org.springframework.cloud:spring-cloud-starter-hystrix')
	
**STEP2.在xxxxApplication.java中，类上添加注解@EnableCircuitBreaker**

**STEP3.在controller中，每个rest接口处，添加cmd相应设置以及Fallback方法**

<font color="red" size=2>注意点：STEP3中的CmdKey不要重复</font>
	
	@HystrixCommand(groupKey = "doSthGroup", 
		threadPoolKey = "doSthThreadPool", 
		commandKey = "doSth", 
		fallbackMethod = "doSthFallback", 
		commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000") 
		})
	@RequestMapping("hystrix/client/trandition/doSth")
	@ResponseBody
	public SimpleDemoResVo doSth(@RequestBody SimpleDemoVo oSimpleDemoVo) {
		return hystrixClientService.doSth(oSimpleDemoVo);
	}
	
	public SimpleDemoResVo doSthFallback(SimpleDemoVo oSimpleDemoVo) {
		return hystrixClientService.doSthFallback(oSimpleDemoVo);
	}



###1.3.被调方###
**STEP1.如同普通的rest接口开发一样**

###1.4.验证过程###
**测试用例构造了如下几种情况**
	
	1.被调方启动线程，线程中死循环，导致被调方线程池接近满而未满，导致调用方熔断开启；
	被调方通过另一个rest接口，将前述死循环线程逐个释放，导致调用方熔断关闭；
	2.被调方启动线程，线程中死循环，导致被调方线程池完全占满，导致调用方熔断开启；
	3.被调方Sleep超时，导致调用方熔断开启，过一段时间调用方熔断关闭；
	4.被调方异常，导致调用方熔断开启，过一段时间调用方熔断关闭；
	



##2.非常规模式(调用方/被调方都使用Hystrix)##
###2.1.Dashboard###
步骤同1.1

###2.2.调用方###
**STEP1.build.gradle引用jar**
	
	compile('org.springframework.cloud:spring-cloud-starter-hystrix')
	
**STEP2.在xxxxApplication.java中，类上添加注解@EnableCircuitBreaker**

**STEP3.在controller中，每个rest接口处，配对出现doSth/doSthInner/doSthFallback、doSthFinish/doSthFinishInner/doSthFinishFallback、doSthFail/doSthFailInnner/doSthFailFallback**

<font color="red" size=2>注意点：STEP3中的CmdKey一定一定不要重复</font>

<font color="red" size=2>注意点：STEP3中的doSthInner一定通过getBean方式调用才能让Hystrix生效</font>
	
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



###2.3.被调方###
STEP1.同2.2

###2.4.验证过程###
**测试用例构造了如下几种情况**
	
	1.被调方启动doSthCmd,doSthCmd中启动doSthInnerCmd，doSthInnerCmd启动线程死循环，导致被调方doSthInner的线程池接近满而未满，导致被调方doSthInner/被调方doSth/调用方doSth的熔断开启；
	被调方通过另一个rest接口，将前述死循环线程逐个释放，导致被调方doSthInner的线程池接近满而未满，导致被调方doSthInner/被调方doSth/调用方doSth的熔断关闭；
	2.被调方启动doSthCmd,doSthCmd中启动doSthInnerCmd，doSthInnerCmd启动线程死循环，导致被调方doSthInner的线程池完全占满，导致被调方doSthInner/被调方doSth/调用方doSth的熔断开启；
	过一段时间被调方doSth/调用方doSth的熔断关闭;
	2.被调方Sleep超时，导致调用方级联熔断开启，过一段时间调用方级联熔断关闭；
	3.被调方异常，导致调用方级联熔断开启，过一段时间调用方级联熔断关闭；




#实现步骤(原生版本)#
	
	步骤封装性不如SpringBoot，请自行参考源码

#reference#
	
	[zipkin]
	http://zipkin.io/pages/existing_instrumentations.html
	[hystrix(semphore)]
	https://github.com/Netflix/Hystrix/wiki/How-it-Works
	https://spring.io/guides/gs/circuit-breaker/
	http://ningandjiao.iteye.com/blog/2171185
	http://ningandjiao.iteye.com/blog/2171191
	http://ningandjiao.iteye.com/blog/2171849
	http://hot66hot.iteye.com/blog/2155036
	[hystrix config]
	https://github.com/Netflix/Hystrix/wiki/Configuration
	[hystrix dashboard by spring boot]
	http://blog.csdn.net/MrTitan/article/details/51565074
	http://cloud.spring.io/spring-cloud-static/Camden.SR2/
	[hystrxi验证流程]
	https://raw.githubusercontent.com/wiki/Netflix/Hystrix/images/hystrix-command-flow-chart.png
	https://raw.githubusercontent.com/wiki/Netflix/Hystrix/images/circuit-breaker-1280.png
	[hystrix by springboot]
	http://spring.io/guides/gs/circuit-breaker/
	https://github.com/Netflix/Hystrix/tree/master/hystrix-contrib/hystrix-javanica
	https://github.com/Netflix/Hystrix/wiki/Configuration


http://localhost:7000/hystrix.stream

