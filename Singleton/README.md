# Singleton

## 前言
When discussing which patterns to drop, we found that we still love them all.
(Not really - I'm in favor of dropping Singleton. Its use is almost always a design smell.)

## 動機
for some components it only makes sense to have one in the system
- database repository
- Object Factory

E.g., the constructor call is expensive
- We only do it once.
- We provide everyone with the same instance
- Want to prevent anyone creating additional copies
- Nedd to take care of lazy instatiation and thread safety

## 遇到的問題
- Refection
- Serialization
- Muti-Thread

## 範例
BasicSingleton

[EasySingleton](https://github.com/changemyminds/Design-and-Pattern/tree/master/Singleton/EasySingleton/src/com/company)
使用三種方式來建立Singleton，其中兩種方式，會因為Muti-Thread造成不為單一例子的情況。

[RegistryOfSingleton](https://github.com/changemyminds/Design-and-Pattern/tree/master/Singleton/RegistryOfSingleton/src)
