# Adapter(轉接器)

## 前言
Getting the interface you want from the interface you have.<br>
A construct which adapts an existing interface X to conform to the required interface Y.

## 動機
Electrical devices have different power(interface) requirements
- Voltage (5V, 200V)
- Socket/plug type(Europe, UK, USA)

We cannot modify our gadgets to support every possible interface
- Some support possible(e.g., 120/220V)

Thus, we use a special device(an adapter) to give us the interface we require from the interface we have

## 遇到的問題
使用Class Adapter好還是該用Object Adapter好？<br>
其實就是繼承(inheritance) vs 組合(composition)的問題<br>
多組合少繼承，所以個人推薦使用Object Adapter較佳。<br>

## 範例
### [ClassAndObjectAdapter](https://github.com/changemyminds/Design-and-Pattern/tree/master/Adapter/ClassAndObjectAdapter/src)
使用Class Adapter和Object Adapter來執行。<br>
原本有一個插頭他只提供120V的電壓，現在要將這個插頭也可以提供3V、12V、120V的電壓，該怎麼辦？<br><br>
補充<br>
Class Adapter – This form uses java inheritance and extends the source interface, in our case Socket class.<br>
Object Adapter – This form uses Java Composition and adapter contains the source object.
 
## 總結
- Implementing an Adapter is easy
- Determine the API you have and the API you need
- Create a component which aggregates(has a reference to, ...) the adaptee
- Intermediate representations can pile up: use caching and other optimizations