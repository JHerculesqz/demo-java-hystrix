package com.huawei._1_fw.component.zipkin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

@Component
public class ZipkinTracerBean {
	// #region Fields

	@Autowired
	public Tracer tracer;

	// @Bean
	// Sampler sampler() {
	// return new AlwaysSampler();
	// }

	// #endregion
}
