---
title: Give Java more memory
date: 2016-04-24 18:26:58
tags: [ecplise, java]
categories: tips
---

It is common when deal with large data set (hundreds of Mb), we come to stack overflow exception. We can solve it by giving java more memory (heap memory) using
```
java someclass --Xss1024m
```
1024 can replaced with larger number.

In ecplise, go to run configuration, and arguments tab, in VM arguments text zone, adding the above command.
