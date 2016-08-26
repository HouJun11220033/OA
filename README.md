# OA
传智播客OA项目
1，新建工程，类型为Web Project，设置默认编码为UTF-8，并创建如下文件夹
	1，Source Folder
		1，src		项目源码
		2，config	配置文件
		3，test		单元测试
	2，普通文件夹
		1，WebRoot/style		css与图片等文件
		2，WebRoot/script		js脚本文件
		3，WebRoot/WEB-INF/jsp	jsp页面文件
	3，包结构
		1，实体
			cn.itcast.oa.domain
		2，Dao
			cn.itcast.oa.dao			Dao接口
			cn.itcast.oa.dao.impl		Dao实现类
		3，Service
			cn.itcast.oa.service		Service接口
			cn.itcast.oa.service.impl	Service实现类
		4，View(Struts2)
			cn.itcast.oa.strtus2.action	
		5，其他
			cn.itcast.oa.cfg			配置
			cn.itcast.oa.util			工具类
			...

2，新建数据库，指定编码为UTF-8。
		
3，添加jar包（放在 WebRoot/WEB-INF/lib/ 下）
	1，环境为：JDK_1.6、JavaEE_5.0
	2，Junit-4.4：
		junit4.4.jar
	3，Struts-2.1.8.1：
		1，添加 ${Struts2_Home}/apps/struts2-blank-2.1.8.1.war/WEB-INF/lib/*.jar
		2，添加struts2-spring整合插件的jar：${Struts2_Home}/lib/struts2-spring-plugin-2.1.8.1.jar
	4，Hibernate-3.6：
		1，添加 ${HIBERNATE_HOME}/hibernate3.jar
		2，添加 ${HIBERNATE_HOME}/lib/required/*.jar
				${HIBERNATE_HOME}/lib/jpa/hibernate-jpa-2.0-api-1.0.0.Final.jar
		3，添加 JDBC 驱动包，mysql-connector-java-5.1.5-bin.jar
		4，添加 slf4j-log4j12-1.5.8.jar、log4j-1.2.15.jar，
		5，添加 c3p0-0.9.1.2.jar
	5，Spring 2.5.6
		1，添加 ${SPRING_HOME}/dist/spring.jar
		2，添加 ${SPRING_HOME}/lib/aspectj/*.jar（共2个）
		3，添加 ${SPRING_HOME}/lib/cglib/cglib-nodep-2.1_3.jar
		5，添加 ${SPRING_HOME}/lib/jakarta-commons/commons-logging.jar（1.1.1版）
		6，添加工具jar包：commons-codec.jar，commons-lang.jar
	6，Jbpm 4.4（带了Hibernate 3.3.1的jar包与MySQL的JDBC驱动包，所以要把重复的包删除）
		1，添加 ${JBPM_HOME}/jpbm.jar
		2，添加 ${JBPM_HOME}/lib/*.jar，除了junit.jar、servlet-api.jar、cglib.jar
		3，注意：不要添加 cglib.jar，因为Spring中有更高版本的 cglib-nodep-2.1_3.jar
		4, 问题 启动Tomcat后，访问JSP时（使用的是MyEclipse自带的Tomcat，是6.0的版本），报错：
			Caused by: java.lang.LinkageError: loader constraints violated when linking javax/el/ExpressionFactory class
				at org.apache.jsp.WEB_002dINF.jsp.UserAction.loginUI_jsp._jspInit(loginUI_jsp.java:39)
				at org.apache.jasper.runtime.HttpJspBase.init(HttpJspBase.java:52)
				at org.apache.jasper.servlet.JspServletWrapper.getServlet(JspServletWrapper.java:159)
				at org.apache.jasper.servlet.JspServletWrapper.service(JspServletWrapper.java:329)
				at org.apache.jasper.servlet.JspServlet.serviceJspFile(JspServlet.java:320)
				at org.apache.jasper.servlet.JspServlet.service(JspServlet.java:266)
				... 40 more
				或
java.lang.LinkageError: loader constraint violation: when resolving interface method "javax.servlet.jsp.JspApplicationContext.getExpressionFactory()Ljavax/el/ExpressionFactory;" the class loader (instance of org/apache/jasper/servlet/JasperLoader) of the current class, org/apache/jsp/index_jsp, and the class loader (instance of org/apache/catalina/loader/StandardClassLoader) for resolved class, javax/servlet/jsp/JspApplicationContext, have different Class objects for the type javax/el/ExpressionFactory used in the signature
	org.apache.jsp.index_jsp._jspInit(index_jsp.java:23)
	org.apache.jasper.runtime.HttpJspBase.init(HttpJspBase.java:52)
	org.apache.jasper.servlet.JspServletWrapper.getServlet(JspServletWrapper.java:159)
	org.apache.jasper.servlet.JspServletWrapper.service(JspServletWrapper.java:329)
	org.apache.jasper.servlet.JspServlet.serviceJspFile(JspServlet.java:320)
	org.apache.jasper.servlet.JspServlet.service(JspServlet.java:266)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:803)
	org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter.doFilter(StrutsPrepareAndExecuteFilter.java:88)




		说明：原因是Jbpm的juel.jar, juel-engine.jar, juel-impl.jar包和Tomcat6.0中的el-api.jar包冲突了。
		有三个解决办法：
		1，方法一：换成tomcat5.5，就没有问题了。
		2，方法二：在MyEclipse的Preferences -> MyEclipse -> Application Servers -> Tomcat -> .. -> Paths 中配置 Append to classpath，选中 juel.jar, juel-engine.jar, juel-impl.jar 这三个jar包就可以了。
		3，方法三：将 juel.jar, juel-engine.jar, juel-impl.jar 这三个包复制到tomcat6下 lib/ 中，并删除原来的el-api.jar，
		切记还要把工程中 WEB-INF\lib 下的 juel.jar, juel-engine.jar, juel-impl.jar 删除，不然还是要冲突。
	


	8，其他的jar包（在Spring中有）
		commons-codec.jar	含有MD5的工具类
		commons-lang.jar	java.lang包中有关类的工具类

	提示：注意不要发生jar包冲突的问题。
	
4，配置文件（除web.xml外，都放在源码文件夹 conf/ 下）
	1，Log4j的配置文件：
		log4j.properties
	2，Strtus2的配置文件：
		1，MessageResources.properties
		2，在 web.xml 中配置Struts2的Filter：
			<!-- Struts2的配置 -->
			<filter>
				<filter-name>struts2</filter-name>
				<filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
			</filter>
			<filter-mapping>
				<filter-name>struts2</filter-name>
				<url-pattern>/*</url-pattern>
			</filter-mapping>
		3，配置struts.xml
			<?xml version="1.0" encoding="UTF-8" ?>
			<!DOCTYPE struts PUBLIC
			    "-//Apache Software Foundation//DTD Struts Configuration 2.1.7//EN"
			    "http://struts.apache.org/dtds/struts-2.1.7.dtd">
			<struts>
				<!-- 设置开发模式 -->
				<constant name="struts.devMode" value="true" />
				<!-- 把action扩展名配置为action -->
				<constant name="struts.action.extension" value="action" />
				<!-- 指定主题使用simple（默认值为xhtml） -->
				<constant name="struts.ui.theme" value="simple" />
				<!-- 定义全局的国际化资源文件 -->
				<constant name="struts.custom.i18n.resources" value="MessageResources"></constant>

				<!-- 可以把相关的action都放在一个package中，以便于管理，形成模块 -->
				<package name="default" extends="struts-default">

				</package>
			</struts>
	3，Hibernate的配置文件：hibernate.cfg.xml
		1，对于MySQL数据库，（JBPM4要求）方言要配置为：org.hibernate.dialect.MySQL5InnoDBDialect
		2，配置如下：
			<!-- 方言 -->
			<property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
			<!-- 其他配置 -->
			<property name="show_sql">true</property>
			<property name="hbm2ddl.auto">update</property>
		3，说明：在这里不配置数据库连接信息，是在后面Spring中整合Hibernate时配置的（配置c3p0数据库连接池）。
	4，Spring的配置文件：applicationContext.xml
		1，声明如下：
			<?xml version="1.0" encoding="UTF-8"?>
			<beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				xmlns:aop="http://www.springframework.org/schema/aop" xmlns:context="http://www.springframework.org/schema/context"
				xmlns:tx="http://www.springframework.org/schema/tx"
				xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
					http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
					http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
					http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd">
		2，配置bean的自动扫描与装配
			<!-- 配置bean的自动扫描与装配 -->
			<context:component-scan base-package="cn.itcast.oa"></context:component-scan>
	5，Jbpm的配置文件：jbpm.cfg.xml


一些问题说明：
	如果使用JavaEE1.4，则可能会出现以下错误：
	1，Caused by: javax.xml.parsers.FactoryConfigurationError: Provider org.apache.xerces.jaxp.DocumentBuilderFactoryImpl not found
	2，Caused by: java.lang.NoClassDefFoundError: org/jboss/mx/util/PropertyAccess
	解决办法：使用JavaEE_5.0就可以了。
	3，${SPRING_HOME}/lib/j2eecommon-annotations.jar（如果是JDK6.0则不需要）
	





Struts2的dtd文件的位置：
{Struts2_Home}\src\core\src\main\resources
