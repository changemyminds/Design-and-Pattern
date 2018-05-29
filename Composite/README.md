# Composite(組合模式)

## 前言
Treating individual and aggregate objects uniformly<br>
Ａ mechanism for treating individual(scalar) objects and compositions of objects in a uniform manner.

## 動機
- Objects use other object's fields/methods through inheritance and composition
- Composition lets us make compound objects
    - E.g., a mathematical expression composed of simple expressions; or
    - A shape group made of several different shapes
- Composite design pattern is used to treat both single (scalar) and composite objects uniformly
    - I.e., Foo and List<Foo> have common APIs

## 遇到的問題
 
## 範例


## 總結


## 筆記
多組合少用繼承<br>
謹慎使用繼承。<br><br>
多擴充少用修改<br>
因新需求擴充新功能，兒少修改已經通過測試的程式碼。<br>
最終目標是要讓程式達到高內聚低耦合的目的。