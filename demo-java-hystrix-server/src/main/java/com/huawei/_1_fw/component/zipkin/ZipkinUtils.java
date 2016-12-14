package com.huawei._1_fw.component.zipkin;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.huawei._1_fw.core.ioc.IOCUtils;

public class ZipkinUtils {
	public static <T> Future<T> newThread(ICallableCallback<T> oICallableCallback, String strSpanName) {
		// 1.generate oCallable by oICallableCallback
		Callable<T> oCallable = new Callable<T>() {
			@Override
			public T call() throws Exception {
				return oICallableCallback.run();
			}

			@Override
			public String toString() {
				return strSpanName;
			}
		};
		// #region 暂时保留，另一种写法,SXL好聪明

		// Callable<Span1ResVo> traceCallable = new TraceCallable<>(oTracer,
		// new
		// DefaultSpanNamer(), oCallable,
		// "calculateTax");

		// #endregion

		// 2.generate oCallableByTracer
		ZipkinTracerBean oZipkinTracerBean = IOCUtils.getInstance().getBean(ZipkinTracerBean.class);
		Callable<T> oCallableByTracer = oZipkinTracerBean.tracer.wrap(oCallable);
		Future<T> oFuture = Executors.newSingleThreadExecutor().submit(oCallableByTracer);

		// 3.return oFuture
		return oFuture;
	}
}
