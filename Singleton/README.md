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
- Serialization
- Reflection
- Muti-Thread

## 範例
BasicSingleton
題目：建立一個簡單的Singleton，並將Object Serialization(序列化)存入檔案中，再將其讀取與原本的物件比較是否相同，會發現讀取的物件與原本的物件是不相同的。

原因：因為JVM不在乎你的類別建構子是否為private，他還是會建構一個新的物件。

解決辦法：加上readResolve()方法，來確保沒有人可以通過序列化或反序列化來創建另一個實體。

[EasySingleton](https://github.com/changemyminds/Design-and-Pattern/tree/master/Singleton/EasySingleton/src/com/company)
使用三種方式來建立Singleton，其中兩種方式，會因為Muti-Thread造成不為單一例子的情況。

[RegistryOfSingleton](https://github.com/changemyminds/Design-and-Pattern/tree/master/Singleton/RegistryOfSingleton/src)
