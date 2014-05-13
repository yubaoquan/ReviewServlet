复习Servlet	
=====================


此项目用于复习`Servlet`和`jsp`技术. 
### Table of contents

You can insert a table of contents using the marker `[TOC]`:

[TOC]

----------

说明
-----------

这个项目内容比较乱。复习的知识点有 **cookie**，**session**，**Filter**, **Listener**, 还有一些附带的小知识点，如**HTTP头信息**，**页面和Servlet编码**，处理**Ajax中文乱码**等等。

#### <i class="icon-share"></i> 主要项目内容

本复习项目目前包括以下内容:

- 在线书签管理器
--Servlet+jsp
- 在线聊天室
--Servlet+jsp+ajax+css
- Template, to have a full control of the output.

> **NOTE:** 在今后学到新的Servlet知识之后，有可能在本项目的基础上继续<!---扩充功能-->。


----------

### 部分源代码文件描述
罗列一下主要项目中的部分代码。其他零碎有的不重要，有的忘记了，的就不一一介绍了。


>**Bookmark** 这个项目是从**一本书**[^一本书]上学的，.细节上有了一定的修改。在线书签项目的文件描述如下:

文件名    | 描述
--------- | -----
AddBookmark.java  | 添加书签的Servlet,调用BookmarkService.java
AddForm.java     | 处理添加书签失败的Servlet
BookmarkInitializer.java      | 监听器，用于项目初始化时载入文件中已存在的书签
ListBookmark.java | 用于列出所有书签
Login.java | 登录用的
TestSelect | 一个用于测试Select元素用法的Servlet
BookmarkService.java | 处理添加书签的具体业务逻辑
CharacterFilter.java | 用于字符替换的过滤器
CharacterRequestWrapper.java | 配合CharacterFilter的Request包装器，用于修改Request中的参数


>**chat** 在线聊天室项目的文件描述如下:

| 文件名    |    描述 |
| :-------- | :--------|
| ChatLogin.java | 登录用的，不解释 | 
| MessageDispatcher.java    |   相当于服务器。用于保存在线用户信息和对用户说话进行广播。 
> **NOTE:** 其实以前就想着做一个在线聊天室和研究研究`Ajax`，但是由于自己太懒了，就一直没动手做。前几天，一个同学找我帮他做一下课程设计，其中有一部分涉及到Ajax但是当时确实不会，就无能为力了。



[^一本书]: Servlet&JSP学习笔记 林信良 清华大学出版社
  