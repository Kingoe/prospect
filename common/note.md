
分布式环境下，开发一个像synchronized关键字那样使用分布式锁。
DistributionLock作用域一个方法函数上，每次调用方法加锁，调用之后自动释放锁。结合AOP中环绕通知特性。