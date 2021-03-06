###以下情况比较适合使用 Decorator 模式：

> ##### Decorator 装饰器的核心就是在不改原有类的基础上给类新增功能。

> 不改变原有类

> 在装饰器模式中有四个比较重要点抽象出来的点；
> 1. 抽象构件角色(Component) - 定义抽象接口;
> 2. 具体构件角色(ConcreteComponent) - 实现抽象接口，可以是一组;
> 3. 装饰角色(Decorator) - 定义抽象类并继承接口中的方法，保证一致性;
> 4. 具体装饰角色(ConcreteDecorator) - 扩展装饰具体的实现逻辑;


####总结
> 使用装饰器模式满足单一职责原则，你可以在自己的装饰类中完成功能逻辑的扩展，而不影响主类，同时可以按需在运行时添加和删除这部分逻辑。另外装饰器模式与继承父类重写方法，在某些时候需要按需选择，并不一定某一个就是最好。
>
> 装饰器实现的重点是对抽象类继承接口方式的使用，同时设定被继承的接口可以通过构造函数传递其实现类，由此增加扩展性并重写方法里可以实现此部分父类实现的功能。
>
> 就像夏天热你穿短裤，冬天冷你穿棉裤，雨天挨浇你穿雨衣一样，你的根本本身没有被改变，而你的需求却被不同的装饰而实现。生活中往往比比皆是设计，当你可以融合这部分活灵活现的例子到代码实现中，往往会创造出更加优雅的实现方式。
>
> 装饰模式是继承的一个替代模式，装饰模式可以动态扩展一个实现类的功能。