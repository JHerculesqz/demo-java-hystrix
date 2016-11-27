package com.huawei.client.cmd._3_isolate;

import com.huawei._1_fw.HttpUtilsEx;
import com.huawei.client.vo.SimpleDemoResVo;
import com.huawei.client.vo.SimpleDemoVo;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class SemaphoreIsolateCommand extends HystrixCommand<SimpleDemoResVo> {
	// #region Fields

	private SimpleDemoVo simpleDemoVo;

	// #endregion

	// #region Construction

	public SemaphoreIsolateCommand(SimpleDemoVo oSimpleDemoVo) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("SemaphoreIsolateCommand"))
				.andCommandKey(HystrixCommandKey.Factory.asKey("2"))
				.andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
						.withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
						.withExecutionIsolationSemaphoreMaxConcurrentRequests(2)));
		this.simpleDemoVo = oSimpleDemoVo;
	}

	// #endregion

	// #region run

	@Override
	protected SimpleDemoResVo run() throws Exception {
		System.out.println("buData:" + this.simpleDemoVo.getName());

		// TODO:replace by post
		SimpleDemoResVo oSimpleDemoResVo = HttpUtilsEx.postByTemplate("http://localhost:8000/hystrix/server/crazyfunc",
				this.simpleDemoVo, SimpleDemoResVo.class);
		return oSimpleDemoResVo;
	}

	// #endregion

	// #region fallback

	@Override
	protected SimpleDemoResVo getFallback() {
		System.out.println("fallBack:" + this.simpleDemoVo.getName());

		// TODO:replace by websocket
		SimpleDemoResVo oSimpleDemoResVo = new SimpleDemoResVo();
		oSimpleDemoResVo.setName("fallback");
		return oSimpleDemoResVo;
	}

	// #endregion
}
