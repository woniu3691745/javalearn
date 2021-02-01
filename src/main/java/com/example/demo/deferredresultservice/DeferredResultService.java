package com.example.demo.deferredresultservice;

import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * @author lidongliang
 * create at: 2021/1/14  5:17 下午
 */
@Service
public class DeferredResultService {

    private Map<String, Consumer<DeferredResultResponse>> taskMap;

    public DeferredResultService() {
        taskMap = new ConcurrentHashMap<>();
    }

    /**
     * 将请求id与setResult映射
     *
     * @param requestId
     * @param deferredResult
     */
    public void process(String requestId, DeferredResult<DeferredResultResponse> deferredResult) {
        // 请求超时的回调函数
        deferredResult.onTimeout(() -> {
            taskMap.remove(requestId);
            DeferredResultResponse deferredResultResponse = new DeferredResultResponse();
            deferredResultResponse.setCode(HttpStatus.REQUEST_TIMEOUT.value());
            deferredResultResponse.setMsg(DeferredResultResponse.Msg.TIMEOUT.getDesc());
            deferredResult.setResult(deferredResultResponse);
        });

//        deferredResult.onCompletion(() -> {
//            taskMap.remove(requestId);
//            DeferredResultResponse deferredResultResponse = new DeferredResultResponse();
//            deferredResultResponse.setCode(HttpStatus.REQUEST_TIMEOUT.value());
//            deferredResultResponse.setMsg(DeferredResultResponse.Msg.TIMEOUT.getDesc());
//            deferredResult.setResult(deferredResultResponse);
//        });

        Optional.ofNullable(taskMap)
                .filter(t -> !t.containsKey(requestId))
                .orElseThrow(() -> new IllegalArgumentException(String.format("requestId=%s is existing", requestId)));

        // 这里的Consumer，就相当于是传入的DeferredResult对象的地址
        // 所以下面settingResult方法中"taskMap.get(requestId)"就是Controller层创建的对象
        // deferredResult::setResult
        taskMap.putIfAbsent(requestId, deferredResult::setResult);
    }

    /**
     * 这里相当于异步的操作方法
     * 设置DeferredResult对象的setResult方法
     *
     * @param requestId
     * @param deferredResultResponse
     */
    public void settingResult(String requestId, DeferredResultResponse deferredResultResponse) {
        if (taskMap.containsKey(requestId)) {
            Consumer<DeferredResultResponse> deferredResultResponseConsumer = taskMap.get(requestId);

            // 这里相当于DeferredResult对象的setResult方法
            // 重点
            deferredResultResponseConsumer.accept(deferredResultResponse);
            taskMap.remove(requestId);
        }
    }

    // 没有悟出来什么意思
    @SneakyThrows
    @PostMapping(value = "/callable")
    public Callable<String> processUpload(final MultipartFile file) {

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "this can return output OR can throw Exception";
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // this can neither return the result nor throw an exception
            }
        };

        threadPool.execute(runnable);
        String submit = threadPool.submit(callable).get();
        return callable;
    }
}











