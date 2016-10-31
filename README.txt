# study_jaxb-ws
在我看来，WSDL理解起来真真是反人类，也许是外文翻译成中文的过程是丢失的信息太多吧。反正各个节点的含义实在是太隐晦了。

下面来总结一下各个节点的含义：

types元素
--定义了各种各样的数据类型
message元素
--将各种各样的数据类型组合起来，就变成了消息。消息可以在客户端和服务端之间进行传递
portType元素和operation元素
 --描述了Web服务的接口并定义了他的方法，portType元素和operation元素类似于Java接口和接口中定义的方法声明
--接口方法operation元素的出入参只能是各种message元素。
Binding元素
--将portType元素和operation元素赋给一个特殊的协议和编码样式,类似于Java接口和接口中定义的方法的具体实现
service元素负责将Internet地址赋给一个具体的绑定


===================================================================================================
关于命名空间的总结：

1、实体DefaultWsdl11Definition中的命名空间，设定的是wsdl对象的命名空间，它与wsdl文件中的命名空间相对应
2、package-info.java中的命名空间，设定的是schema对象的命名空间，它与xsd文件中的命名空间相对应
3、@PayloadRoot中的命名空间，主要用来匹配请求报文(message元素)中的命名空间，当请求报文中的命名空间与它定义的命名空间一致时，请求报文才会被映射到相应的方法
	它一般要求与第二条中的xsd文件中的命名空间相等(因为请求报文/message元素的命名空间一般与xsd文件中的命名空间相等)
	也就是说：   请求报文==message元素     请求报文中的命名空间==xsd文件中的命名空间==@PayloadRoot中的命名空间
	如果它与xsd文件中的命名空间不相等， 则消息根本到不了与@PayloadRoot中的命名空间匹配这一步，在与xsd文件匹配的时候就会被截留




===================================================================================================
package-info.java的作用总结

1、为标注在包上的Annotation注解提供便利；本案例中就用到了

2、声明友好类和包常量；暂时还没有见过

3、提供包的整体注释说明:这个很容易理解


===================================================================================================
用这种方式发布webservice的步骤总结：
1、建立domain模型(domain实体)对应的java类文件与schema文件
		注意：
			a)java类文件与schema文件可以相互转换
			b)schema文件上的命名空间与在包上声明的命名空间是相对应的关系
2、配置相应的bean：
		a)配置MessageDispatcherServlet
		b)schema文件对应的XsdSchema
		c)DefaultWsdl11Definition，持有XsdSchema
3、配置service
	@Endpoint
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerRequest")
	@ResponsePayload
	@RequestPayload
