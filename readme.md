<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [项目介绍](#%E9%A1%B9%E7%9B%AE%E4%BB%8B%E7%BB%8D)
- [相关思想&技术](#%E7%9B%B8%E5%85%B3%E6%80%9D%E6%83%B3%E6%8A%80%E6%9C%AF)
- [表结构](#%E8%A1%A8%E7%BB%93%E6%9E%84)
- [项目图片](#%E9%A1%B9%E7%9B%AE%E5%9B%BE%E7%89%87)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# 项目介绍

使用J2EE技术实现的模仿天猫整站项目,恶趣味的把天猫换成了京东

学习自[how2j](https://how2j.cn/k/tmall-j2ee/tmall-j2ee-894/894.html?p=28546)

本项目没有使用SSH,SSM框架，而是使用J2EE整套技术来作为解决方案，实现各种业务场景

这样可以比较好的夯实J2EE基础

# 相关思想&技术

数据就是`模型` (bean,DAO)
页面就是`视图` (JSP)
控制不同的模型显示在不同的视图上，这件事就是由`控制器`来完成的 (servlet)



其他更详细的部分可以看doc.md

# 表结构

![image-20210407034556416](imgs/image-20210407034556416.png)

| Category      |      |      |
| ------------- | ---- | ---- |
| Property      |      |      |
| Product       |      |      |
| PropertyValue |      |      |
| ProductImage  |      |      |
| Review        |      |      |
| User          |      |      |
| Order         |      |      |
| OrderItem     |      |      |

# 项目图片