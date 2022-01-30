# 作业与总结

---

## 作业一

### 作业要求

**2.（必做）思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程？写出你的方法，越多越好，提交到 Github。**

### 做题思路

一共 10 种，大致如下：

- 不使用多线程并发工具：
  - NoLockMethod.java(使用循环不断判断)
  - ThreadJoinMethod.java(使用Thread Join)
- 使用多线程并发工具
  - 不使用 Future（使用类似等待-通知机制）
    - SynchronizedMethod.java
    - SemaphoreMethod.java
    - LockConditionMethod.java
    - CyclicBarrierMethod.java
    - CountDownLatchMethod.java
  - 使用 Future（使用线程池的 submit）
    - FutureMethod.java
    - FutureTaskMethod.java
    - CompletableFutureMethod.java
    