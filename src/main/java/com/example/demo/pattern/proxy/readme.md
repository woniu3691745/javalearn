###以下情况比较适合使用 Proxy 模式：

> ##### Proxy 代理模式使用``代理对象``完成用户请求，屏蔽用户对真实对象的访问。

> 代理模式角色分为4种：
> 1. 主题接口：定义代理类和真实主题的公共对外方法，也是代理类真实主题的方法；
> 2. 真实主题：真正实现业务逻辑的类；
> 3. 代理类：用来代理和封装真实主题；
> 4. Main：客户端，使用代理类和主题接口完成一些工作。

####动态代理
> 动态代理类使用字节码动态生成加载技术，在运行时生成加载类。
> 1. JDK(反射)
> 2. CGLIB(字节码)
> 3. Javassist(字节码)
> 4. ASM库
<br>

###区别
1.JDK和CGLib的区别

    JDK动态代理只能对实现了接口的类生成代理，而不能针对类;
    CGLib是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法（继承）;
2.Spring在选择用JDK还是CGLib的依据

    当Bean实现接口时，Spring就会用JDK的动态代理;
    当Bean没有实现接口时，Spring使用CGLib来实现;
    可以强制使用CGLib（在Spring配置中加入<aop:aspectj-autoproxy proxy-target-class=“true”/>）;

---
[代理 Proxy](https://developer.ibm.com/zh/articles/j-lo-proxy-pattern/)