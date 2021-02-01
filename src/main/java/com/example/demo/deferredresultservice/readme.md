+ http://localhost:8080/deferred-result/get?timeout=8000  A
+ http://localhost:8080/deferred-result/result?desired=成功  B

当发起A调用，超时8s，在超时之前调用B，A返回成功，否者A返回失败。

也就是A可以一直等待B调用~

`
API接口需要在指定时间内将异步操作的结果同步返回给前端时；
Controller处理耗时任务，并且需要耗时任务的返回结果时；
当一个请求到达API接口，如果该API接口的return返回值是DeferredResult，
在没有超时或者DeferredResult对象设置setResult时，接口不会返回，
但是Servlet容器线程会结束，DeferredResult另起线程来进行结果处理(即这种操作提升了服务短时间的吞吐能力)，
并setResult，如此以来这个请求不会占用服务连接池太久，如果超时或设置setResult，接口会立即返.
`


客户发送请求
Servlet容器分配一个线程并在其中调用Servlet
Servlet调用request.startAsync()，保存AsyncContext，然后返回
容器线程一直退出，但响应保持打开状态
其他一些线程使用保存AsyncContext来完成响应
客户收到回复

参考 https://www.cnblogs.com/duanxz/p/3748163.html