###以下情况比较适合使用 Factory 模式（创造设计模式）：

> ##### Factory 设计模式无创建逻辑暴露给客户端创建对象，使用一个通用接口引用新创建的对象；

> 1. 实现步骤： 
> 2. 创建一个接口；
> 3. 创建实现相同接口的具体类；
> 4. 创建工厂根据给定信息生成具体类的对象；
> 5. 使用工厂通过传递类型等信息来获取具体类的对象；

> 工厂和抽象工厂转换
>
    当产品只有一个的时候，抽象工厂模式即变成工厂模式；
    当工厂模式的产品变成多个的时候，工厂模式即变成抽象工厂模式。
    
    
    
<br>
---
![Image text](工厂模式.jpg)

![Image text](抽象工厂模式.jpg)