package com.huawei.client.provider;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.huawei.client.cmd._1_execute_mode.ExecuteModeCmd;
import com.huawei.client.cmd._2_simple_demo.SimpleDemoCmd;
import com.huawei.client.cmd._3_isolate.SemaphoreIsolateCommand;
import com.huawei.client.cmd._3_isolate.ThreadPoolIsolateCommand;
import com.huawei.client.vo.SimpleDemoResVo;
import com.huawei.client.vo.SimpleDemoVo;

import rx.Observable;
import rx.Observer;

public class MainProvider {
	// #region simpleDemo

	public static SimpleDemoResVo simpleDemo(SimpleDemoVo oSimpleDemoVo) {
		SimpleDemoResVo oSimpleDemoResVo = new SimpleDemoCmd("simpleDemo").execute();
		return oSimpleDemoResVo;
	}

	// #endregion

	// #region executeMode

	// #region executeModeSync

	public static SimpleDemoResVo executeModeSync(SimpleDemoVo oSimpleDemoVo) {
		ExecuteModeCmd oExecuteModeCmd = new ExecuteModeCmd("executeMode");
		SimpleDemoResVo oSimpleDemoResVo = oExecuteModeCmd.execute();
		return oSimpleDemoResVo;
	}

	// #endregion

	// #region executeModeASync

	public static SimpleDemoResVo executeModeASync(SimpleDemoVo oSimpleDemoVo) {
		ExecuteModeCmd oExecuteModeCmd = new ExecuteModeCmd("executeMode");
		Future<SimpleDemoResVo> oFuture = oExecuteModeCmd.queue();
		while (!oFuture.isDone()) {
			System.out.println("Do other things ...");
		}
		SimpleDemoResVo oSimpleDemoResVo = null;
		try {
			oSimpleDemoResVo = oFuture.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return oSimpleDemoResVo;
	}

	// #endregion

	// #region executeModeReact

	public static void executeModeReact(SimpleDemoVo oSimpleDemoVo) {
		ExecuteModeCmd oExecuteModeCmd = new ExecuteModeCmd("executeMode");
		Observable<SimpleDemoResVo> result = oExecuteModeCmd.observe();
		result.subscribe(new Observer<SimpleDemoResVo>() {
			@Override
			public void onCompleted() {
				System.out.println("Command Completed");
			}

			@Override
			public void onError(Throwable e) {
				System.out.println("Command failled");
			}

			@Override
			public void onNext(SimpleDemoResVo oSimpleDemoResVo) {
				System.out.println(oSimpleDemoResVo);
			}
		});
	}

	// #endregion

	// #endregion

	// #region isolate

	// #region threadPoolIsolate

	public static SimpleDemoResVo threadPoolIsolate(SimpleDemoVo oSimpleDemoVo) {
		ThreadPoolIsolateCommand oThreadPoolIsolateCommand = new ThreadPoolIsolateCommand(oSimpleDemoVo);
		SimpleDemoResVo oSimpleDemoResVo = oThreadPoolIsolateCommand.execute();
		return oSimpleDemoResVo;
	}

	// #endregion

	// #region semaphoreIsolate

	public static SimpleDemoResVo semaphoreIsolate(SimpleDemoVo oSimpleDemoVo) {
		SemaphoreIsolateCommand oSemaphoreIsolateCommand = new SemaphoreIsolateCommand(oSimpleDemoVo);
		SimpleDemoResVo oSimpleDemoResVo = oSemaphoreIsolateCommand.execute();
		return oSimpleDemoResVo;
	}

	// #endregion

	// #endregion
}
