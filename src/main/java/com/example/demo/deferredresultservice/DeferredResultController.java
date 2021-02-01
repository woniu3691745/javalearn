package com.example.demo.deferredresultservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author lidongliang
 * create at: 2021/1/14  5:18 下午
 */
@RestController
@RequestMapping(value = "/deferred-result")
public class DeferredResultController {

    @Autowired
    private DeferredResultService deferredResultService;

    /**
     * 为了方便测试，简单模拟一个
     * 多个请求用同一个requestId会出问题
     */
    private final String requestId = "haha";


    @GetMapping(value = "/get")
    public DeferredResult<DeferredResultResponse> get(@RequestParam(value = "timeout", required = false, defaultValue = "10000") Long timeout) {
        DeferredResult<DeferredResultResponse> deferredResult = new DeferredResult<>(timeout);

        deferredResultService.process(requestId, deferredResult);

        // 返回deferredResult，相当于关闭请求，打开响应
        return deferredResult;
    }

    /**
     * 设置DeferredResult对象的result属性，模拟异步操作
     *
     * @param desired
     * @return
     */
    @GetMapping(value = "/result")
    public String settingResult(@RequestParam(value = "desired", required = false, defaultValue = "成功") String desired) {
        DeferredResultResponse deferredResultResponse = new DeferredResultResponse();
        if (DeferredResultResponse.Msg.SUCCESS.getDesc().equals(desired)) {
            deferredResultResponse.setCode(HttpStatus.OK.value());
            deferredResultResponse.setMsg(desired);
        } else {
            deferredResultResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            deferredResultResponse.setMsg(DeferredResultResponse.Msg.FAILED.getDesc());
        }
        deferredResultService.settingResult(requestId, deferredResultResponse);

        return "Done";
    }

    /**
     * 可以通过配置的TaskExecutor运行给定任务来获取返回值。
     */
    public void m1() {
        Callable<String> stringCallable = deferredResultService.processUpload(null);
        try {
            String call = stringCallable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
