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
- Thread-safe

## 範例
### [BasicSingleton](https://github.com/changemyminds/Design-and-Pattern/blob/master/Singleton/BasicSingleton/src/Demo.java)
建立一個簡單的Singleton，並將Object Serialization(序列化)存入檔案中，再將其讀取與原本的物件比較是否相同，會發現讀取的物件與原本的物件是不相同的，而且再多執行緒下會有問題。

### [StaticBlockSingleton](https://github.com/changemyminds/Design-and-Pattern/blob/master/Singleton/StaticBlockSingleton/src/Demo.java)
利用Static Initializer，來建立Singleton，Static Initializer的方法跟類別中定義的建構子很像，它的功能在於初始化類別，當類別初次被使用、被載入至JVM時，會執行static block裡面的程式碼。
此方法再多執行緒下，並不會出現問題，能夠維持單一的實體。

### [LazySingleton](https://github.com/changemyminds/Design-and-Pattern/tree/master/Singleton/LazySingleton/src/com/company)
使用四種方式來建立Singleton，其中兩種方式為Synchronized Accessor和Double Checked Locking，另外兩種方式會因為Muti-Thread造成Thread-safe不為單一例子的情況。

### [InnerStaticSingleton](https://github.com/changemyminds/Design-and-Pattern/blob/master/Singleton/InnerStaticSingleton/src/Demo.java)
一般又可以稱為LazyHolder，並且也維持單一實體，這種方始較佳符合「延遲載入」、「高效能」，缺點是不可用在非靜態類別的屬性上面。

### [Monostate](https://github.com/changemyminds/Design-and-Pattern/blob/master/Singleton/MonoState/src/Demo.java)
和Singleton類似，但是Singleton通常有一個getInstance的method，用起來和一般物件不同，而MonoState的運作方式與一般物件相同，它讓所產生的物件中的屬性相同，
但缺點是物件有建構與解構的方式，而且產生的新物件是不同的，因次效率較Singleton差。

### [RegistryOfSingleton](https://github.com/changemyminds/Design-and-Pattern/tree/master/Singleton/RegistryOfSingleton/src)

