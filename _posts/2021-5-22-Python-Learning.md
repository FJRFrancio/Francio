---
layout: post
title: Python Learning
tags: 
- Python
categories: Python
---



# Python Learning


## 词典
只要是可hash的对象均可作为key
d.get()获得key
遍历：无序遍历，for k in dict循环时等效于for k in dict.keys(),另外，可以用d.values()或for (k,v) in d.item()返回值或键值对
values()返回一个value的list，此时有数据一致性问题
list(dict)返回index list（只有键）
## 列表生成器
对容器类，均包含一个迭代器，返回下一个元素


```python
ls = [m + n for m in "ABC" for n in "123"]
```

生成器也可生产字典
本质：逐元素的数据集变换，由数据集到数据集，可继续变换下去 

join：将序列中的元素以指定字符链接成新的字符串
zip：将多个可迭代的对象中的元素打包成元组，返回元组构成的列表


```python
A = [[1,2,3],[4,5,6],[7,8,9]]
B = [x for x in zip(*A)] ## *为解包运算，分离出三个向量,zip再将对应列打包，达到转置矩阵的目的
C = [sum(i) for i in B]
print(A)
print(B)
print(C)
```

    [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    [(1, 4, 7), (2, 5, 8), (3, 6, 9)]
    [12, 15, 18]


map():接受一个函数和一个可迭代的对象，作用后返回新的可迭代的对象
filter:同map，过滤满足条件的元素



```python
def f(x):
    return x**2
F = map(f,[1,2,3,4,5,4])
print(list(F))
```

    [1, 4, 9, 16, 25, 16]

sorted:接收可迭代的对象，返回排好序的list,一般list 自带sort方法

```python
sorted?
ls.sort?
#*IN PLACE*:修改原始数据，不生成副本
```


```python
# 生成器
g = (x*x for x in range(1,11) if x%2 == 0)
print(next(g))
ls3 = list(g)
print(ls3) #从上次运行到的地方开始，而不是从头开始
```

    4
    [16, 36, 64, 100]


## 函数
不支持可变参数
def fun(arg,...,*args,**kwargs)



```python
def test_args(arg1,arg2,*argv,**argd):##常用*arg，
    print(arg2)
    for arg in argv:#逐个传入,慢慢拆
        print(arg)
    for k,v in argd.items():
        print(k,":",v)

test_args(2021,"python","datascience","deep",classroom = "207",time = 'mon 5-6')
```

    python
    datascience
    deep
    classroom : 207
    time : mon 5-6


递归函数：快排(有/无lambda)


```python
def quicksort(arr):
    if len(arr) <=1:
        return arr
    pivot = arr[len(arr)//2]
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]
    return quicksort(left) + middle + quicksort(right)

print(quicksort([5,9,3,8,2,3,8,8,3,84,3,3,4,65,97,62,5]))
```

    [2, 3, 3, 3, 3, 3, 4, 5, 5, 8, 8, 8, 9, 62, 65, 84, 97]


生成器函数:类似于generater,每次运行到yield时return出来一个值，逐个处理，不会一次产生一大堆数据
生成器每次调用可以派生出多个生成器实例


```python
def fib(max = 5):
    n,a,b = 0,0,1
    while n < max:
        yield b 
        
        a,b = b,a+b
        n = n+1
f = fib()
f1 = fib(9)
print([i for i in f])
print([i for i in f1])
```

    [1, 1, 2, 3, 5]
    [1, 1, 2, 3, 5, 8, 13, 21, 34]


函数嵌套:return一个函数


```python
def fo(par = 0):# par:缺省参数
    i = par + 1
    
    def fi(x = 0):
        return x+i
    
    return fi()

print(fo(10))
```

    11


## nonlocal/global:指明想要改动的变量位于哪一级

- nonlocal:只可用于嵌套函数中，且在外层需要定义相应的局部变量，将上层的变量用到下层中

- global:可用在任何地方，即使之前从未定义过该变量

- python引用变量顺序：当前作用域》外层》当前模块》python内置



```python
def scope_test():
    def do_local():
        spam = 'local spam No.1'
    def do_nonlocal():
        nonlocal spam
        spam = 'nonlocal spam No.2'
    def do_global():
        global spam 
        spam = "global spam No.3"
    spam = "test spam"
    do_local()
    print("After local assignment: ",spam)
    do_nonlocal()
    print("After nonlocal assignment: ",spam)
    do_global()
    print("After global assignment: ",spam)
scope_test()
print("In global scope:",spam)
```

    After local assignment:  test spam
    After nonlocal assignment:  nonlocal spam No.2
    After global assignment:  nonlocal spam No.2
    In global scope: global spam No.3


## 函数闭包
内部定义函数，并作为返回值返回（工厂模式）
可以在运行过程中定制一个函数，介入下一步



```python
def print_msg(msg):
    def printer(st=''):#函数实例带参数时，也可接受参数
        print(st+msg)
    return printer# 实例化一个函数

enough = print_msg('A')#现在enough是个函数实例
another = print_msg("B")

another()
enough('V')
```

    B
    VA


闭包可产生函数模版


```python
def inc(x):return x+1
def dec(x):return x-1
def make(func):
    def ope(x):
        return func(x)
    return ope

addo = make(inc)
minu = make(dec)

print(addo(1))
print(minu(1))
```

    2
    0


- 装饰器：抽取共性操作作为功能切片，对一类函数进行包装
- 利用闭包给函数添加上下文，闭包函数接受一个函数，在内部函数内使用该函数，并在函数上下文做一些其它操作
    - 应在被装饰的函数前加<@装饰器函数的名称（参数）>，此时再调用这个函数就可以直接得到装饰后的函数，可以放好几层<@函数名>，越靠近原本函数越内层
- 常用于预处理和异常处理
- 通过装饰器的闭包：可以用于定制装饰器
- 此种闭包和装饰操作可以获得更好的程序架构
- 所有被装饰的函数实例共享一个公共缓存（记忆化存储）


```python
def decorator(func):
    def dechouse():
        print('木地板，','吊顶',end = '')#end替换换行符
        func()
    return dechouse

def house():
    print('房子')

def classroom():
    print('教室')

@decorator
def officeroom():
    print('办公室')
    
house()

newhouse = decorator(house)
newhouse()
newclassroom = decorator(classroom)
newclassroom()

officeroom()
```

    房子
    木地板， 吊顶房子
    木地板， 吊顶教室
    木地板， 吊顶办公室



```python
def smart_devide(func):
    def inner(a,b):
        print("I am going to divide",a,"and",b)
        if b == 0:
            print("除数不能为0")
            return
        return func(a,b)
    return inner

@smart_devide
def divide(a,b):
    return a/b

divide(4,3)
divide(4,0)
```

    I am going to divide 4 and 3
    I am going to divide 4 and 0
    除数不能为0


通过函数闭包可对装饰器进行定制


```python
def specify(req):
    def decorator(func):
        def dechouse():
            print(req + "木地板，","吊顶",end = "")
            func()
        return dechouse
    return decorator

@specify("高档")
def house():
    print('房子')
    
@specify("普通")    
def officeroom():
    print('办公室')
    
house()
officeroom()
```

    高档木地板， 吊顶房子
    普通木地板， 吊顶办公室


嵌套装饰器


```python
#TODO
def p(func):
    def inner(*args):
        print("<p>")
        func(*args)
        print("</p>")
    return inner

def body(func):
    def inner(*args):
        print("<body>")
        func(*args)
        print("</body>")
    return inner

@body
@p
def sum_dec(a, b):
    print("{} + {} = {}".format(a, b, a + b))

a = int(input())
b = int(input())
sum_dec(a, b)
```

    1
    2
    <body>
    <p>
    1 + 2 = 3
    </p>
    </body>


装饰器实现记忆化存储


```python
def memorize_factorial(f):#输入被装饰的函数
    memory = {}# 所有被装饰的函数实例共享一个公共缓存（记忆化存储）
    
    def inner(num):
        if num not in memory:#查询缓存
            memory[num] = f(num)#递归调用，并写入缓存
            print('%d not in '%(num),end = '')
        return memory[num]# 如果缓存中有内容，直接返回结果
    
    return inner

@memorize_factorial
def facto(num):
    if num == 1:
        return 1
    else:
        return num*facto(num-1)
    
print(facto(4))
print(facto(5))
print(facto(4))
```

    1 not in 2 not in 3 not in 4 not in 24
    5 not in 120
    24


## 3.18：类


- ==：比较值是否相等
- "is"：比较对象的id（比==更严格）
- 对整数和短小字符，python会缓存并重复使用，再次定义重复的物种时相当于将变量名指向了已有对象
- 引用：传引用、对象复制和复制引用
- 加法：创建新对象
- 乘法：指向对象


```python
a = dict(one=1,two=2,three=3)
b = {'one':1,'two':2,'three':3}
print(a is b)
print(a == b)
print(id(a),id(b))

c = 2.0
d = 2.0
print(c is d)

e = 2
f = 2
print(e is f)
```

    False
    True
    2628343847096 2628343829592
    False
    True


传引用


```python
li1 = [7,8,9,10]
li2 = li1
li1[1] = 16

li2
```




    [7, 16, 9, 10]



复制引用


```python
b =[{'g':1.5}] * 4
print(b)

b[0]['g'] = '32'
print(b)
```

    [{'g': 1.5}, {'g': 1.5}, {'g': 1.5}, {'g': 1.5}]
    [{'g': '32'}, {'g': '32'}, {'g': '32'}, {'g': '32'}]



```python
b = [{'g':1}]+[{'g':1}]+[{'g':1}]+[{'g':1}]
b[0]['g'] = 2
b
```




    [{'g': 2}, {'g': 1}, {'g': 1}, {'g': 1}]



### 拷贝
- 浅拷贝：不拷贝子对象，原始数据改变则子对象改变，复制容器内的引用，不会真正复制对象



```python
import copy
ls = [1,2,3,['a','b']]
c = copy.copy(ls)
c
```




    [1, 2, 3, ['a', 'b']]




```python
ls[3].append("ccc")
ls.append(6)
ls[3][0] = 'c'
ls
```




    [1, 2, 3, ['c', 'b', 'ccc', 'ccc'], 6, 6]




```python
c
```




    [1, 2, 3, ['c', 'b', 'ccc', 'ccc']]



- 深拷贝：复制容器内的对象引用，以及引用对象的内容的内容。。。。。，所有引用对象都重新生成
- 注意循环定义的情况，deepcopy会无限循环



```python
import copy
list = [1,2,3,['a','b']]

d = copy.deepcopy(list)

list.append(4)
list[3][0] = 'c'

print(d)
print(list)
```

    [1, 2, 3, ['a', 'b']]
    [1, 2, 3, ['c', 'b'], 4]


### 名字绑定与引用计数
- python中的赋值操作可认为是一个命名操作，所有对象都有引用计数
- 递归引用会导致内存泄漏，引用计数为0时候会启动对象回收机制
- 增加计数：赋值、在容器中包含该对象
- 减少计数
    - 离开当前名字空间
    - 对象的一个名字被绑定到另外一个对象
    - 对象从包含它的容器中被移除
    - 名字被用del销毁
- globals():全局引用列表
- locals（）:局域引用列表
- getrefcount()一般大于ref_list


```python
from sys import getrefcount as grc

num1 = 2345
num2 = num1+1
print(grc(num1))

num3 = num1
print(grc(num1))

ref_dict = dict(globals())
print([ref for ref in ref_dict if ref_dict[ref] is num1])

print(grc(num1))
del num1
print(grc(num3))
```

    3
    4
    ['num1', 'num3']
    6
    5


### 类的定义，对象的声明
- class:首字母常大写，类内包含属性和方法，对象方法中有形参self，指向实例的引用,必须放在最前面，在实例中调用该方法时不需要给self赋值
- init：初始化类的运行环境
- 对象的内省:列出类内方法与参数



```python
class Cat():
    def __init__(self,name,age):#采用__开始的为内部函数，init在创建实例时自动运行
        self.name = name
        self.age = age
    def sit(self):#外部可见的实例方法
        print(self.name.title()+'is now sitting')
    def roll_over(self):
        print(self.name.title()+'rolled over!')
        
this_cat = Cat('orangecat',6)
print(this_cat.name.title())#title方法返回标题化的串：首字母大写
print(this_cat.age)
```

    Orangecat
    6



```python
this_cat.sit()
this_cat.roll_over()

print(this_cat.__dict__)#内省

class C: pass #定义一个空类，消除类内自带的方法等
print (set(dir(this_cat))-set(dir(C)))##列出个性化属性和方法名
```

    Orangecatis now sitting
    Orangecatrolled over!
    {'name': 'orangecat', 'age': 6}
    {'sit', 'name', 'age', 'roll_over'}


- self：给出操作函数的默认作用域，用于记录每个实例等引用，实例方法中访问内部变量要用self.约束，
- 实例方法中如果需要访问类属性，需要用类名称或指向类的引用进行标识
- 类本身也是对象，可被访问
- 类内的参数无法直接引用，需要classname.para访问，所以实例共享一个类属性


```python
class Cat():
    catfood = 20   #类属性，所有实例共享
    
    def __init__(self,name,age):
        self.name = name
        self.age = age
    
    def eat(self):
        if Cat.catfood > 0:
            Cat.catfood -= 2 ## 访问所有对象共享的类属性
        print('catfood=',Cat.catfood)
        
    def roll_over(self):
        print(self.name.title()+"rolled over!")
        Cat.catfood -= 1
        
curvtail = Cat('curvetail',1)
fatorange = Cat('fatorange',6)

fatorange.roll_over()
fatorange.eat()
curvtail.eat()
curvtail.catfood
```

    Fatorangerolled over!
    catfood= 17
    catfood= 15





    15



不推荐的为对象添加新属性和新方法的写法:容易引起变量名混乱


```python
print(f'fatorange.catfood = {fatorange.catfood}')#会优先访问实例的属性
fatorange.catfood = 100 #在对象空间里创建了一个同名实例
print(f'fatorange.catfood = {fatorange.catfood}')

Cat.catfood = 40
fatorange.eat()
curvtail.eat()
print(fatorange.catfood,curvtail.catfood)
```

    fatorange.catfood = 15
    fatorange.catfood = 100
    catfood= 38
    catfood= 36
    100 36


为实例添加新的方法函数:仅属于这个实例，可以吃到自己的猫粮


```python
def eatm(self):
    self.catfood -= 2
    print(f'mycatfood = {self.catfood}')
```


```python
import types
fatorange.eatmy = types.MethodType(eatm,fatorange)
```


```python
fatorange.eat()
fatorange.eatmy()
fatorange.catfood
```

    catfood= 34
    mycatfood = 98





    98




```python
class C():pass

print([x for x in dir(fatorange) if x not in dir(C)])
```

    ['age', 'catfood', 'eat', 'eatmy', 'name', 'roll_over']


- 为对象添加新属性和方法
    - OBJ.para访问
    - OBJ.para = xxx :在对象空间内创建了同名实例属性
    - classname.para = xxx:直接更改类属性
- 为实例添加新的方法types

- 类对象、属性、方法
    - 类属性由类名访问,由该类和派生的对象实例共享
- 私有变量与内置方法：
    - 默认情况下python中的成员变量和成员函数公开
    - 在函数和变量名前加两个下划线，函数或变量就变成私有的，不可直接访问，但可通过__类名_变量名 格式强制访问（不推荐）
    - 建议写相应的get方法访问


```python
class Person:
    def __init__(self,name,age):
        self.__name = name
        self.age = age
    def printInfo(self):
        print(f'name:{self.__name},age:{self.age}')
        
p = Person("Bob",14)
p.printInfo()
```

    name:Bob,age:14



```python
p.age
```




    14




```python
p.name
```


    ---------------------------------------------------------------------------
    
    AttributeError                            Traceback (most recent call last)
    
    <ipython-input-12-a2041b62649a> in <module>
    ----> 1 p.name


    AttributeError: 'Person' object has no attribute 'name'


- 常见内置方法：
    - iter:迭代器,无论何时创建迭代器都会调用这个方法
    - next:下一个，迭代器获取下一个值时必被调用
    - reverse:逆向迭代，不常用
    - 
    定义一个迭代器类：


```python
class Foo:
    def __init__(self,n):
        self.n = n
    def __iter__(self):
        return self
    def __next__(self):
        if self.n >= 8:
            raise StopIteration
        self.n += 1
        return self.n

f1 = Foo(5)

for i in f1:
    print(i)
```

    6
    7
    8


所以迭代器共享迭代变量的例子


```python
class InfIter:
    num = 1
    
    def __iter__(self):
        InfIter.num = 1 #每次chong
        return self
    
    def __next__(self):
        InfIter.num += 2
        return InfIter.num
    
odd = InfIter()
print(next(odd),next(odd))

odd2 = InfIter()
print(next(odd2),next(odd2))
```

    3 5
    7 9



```python
odd3 = InfIter()
print(next(odd3))
```

    11


- 基于类实现的装饰器：必须实现call init
    - call：可调用对象，在内部实现对输入函数的装饰逻辑，call里写闭包
    - init：接收被装饰函数
    甚至可以返回一个新的类


```python
class logger(object):
    def __init__(self,func):# func是被装饰的函数
        self.func = func
    
    def __call__(self,*args,**kwargs):
        print('[INFO]: the function {func} ()is running...'.format(func = self.func.__name__))
        return self.func(*args,**kwargs)

@logger
def say(something):
    print("say {}!".format(something))
    
say('hello')
```

    [INFO]: the function say()is running...
    say hello!



```python
class makeHtmlTagClass(object):
    def __init__(self,tag,css_class=''):
        self._tag = tag
        self._css_class = "class='{0}'".format(css_class) if css_class != "" else""
        
    def __call__(self,fn):
        def wrapped(*args,**kwargs):
            return "<"+self._tag+self._css_class+">"+fn(*args,**kwargs)+"</"+self._tag+">"
        return wrapped

@makeHtmlTagClass(tag = 'b',css_class='bold_css')
@makeHtmlTagClass(tag = 'i',css_class="italic_css")
def say(someth):
    return "Hello,{}".format(someth)

print(say("这里是内容"))
```

    <bclass='bold_css'><iclass='italic_css'>Hello,这里是内容</i></b>


- 用类定义数据结构
    - 单链表
    - 树


```python
# 单链表
class Node(object):
    def __init__(self,value):
        self.value = value
        self.nextnode = None
```


```python
a = Node(1)
b = Node(2)
c = Node(3)
```


```python
a.nextnode = b
```


```python
b.nextnode = c
```


```python
#二叉树
class BinaryTree(object):
    def __init__(self,rootObj):
        self.key = rootObj
        self.leftChild = None
        self.rightChild = None
        
    def insertLeft(self,newNode):
        if self.leftChild == None:
            self.leftChild = BinaryTree(newNode)
        else:
            t = BinaryTree(newNode)
            t.leftChild = self.leftChild
            self.leftChild = t
    def insertRight(self,newNode):
        if self.rightChild == None:
            self.rightChild = BinaryTree(newNode)
        else:
            t = BinaryTree(newNode)
            t.rightChild = self.rightChild
            self.rightChild = t
            
    def getRightChild(self):
        return self.rightChild
    
    def getLeftChild(self):
        return self.leftChild
    
    def setRootVal(self,obj):
        self.key = obj
    
    def getRootVal(self):
        return self.key
```


```python
from __future__ import print_function

r = BinaryTree('a')
print(r.getRootVal())
print(r.getLeftChild())
r.insertLeft('b')
print(r.getLeftChild())
print(r.getLeftChild().getRootVal())
r.insertRight('b')
print(r.getRightChild())
print(r.getRightChild().getRootVal())
r.getRightChild().setRootVal('hello')
print(r.getRightChild().getRootVal())
```

    a
    None
    <__main__.BinaryTree object at 0x0000017905EE24C8>
    b
    <__main__.BinaryTree object at 0x0000017905EE2F88>
    b
    hello


- 类的继承、重写、补充
    - 基类名必须与派生类定义在同一作用域中
    - 派生类的定义可以使用表达式
    - 创建一个类的实例，方法按照如下规则解析：搜索对应的类属性，必要时沿基类逐级搜索，如果找到了函数对象这个方法引用就是合法的
    class DerivedClassName(modname.BaseClassName)
- super关键字



```python
class Person(object):
    def talk(self):
        print("person is talkig.....")
        
class Chinese(Person):
    def walk(self):
        print('is walking...')
        
c = Chinese()
c.talk()
c.walk()
```

    person is talkig.....
    is walking...


- 继承后构造函数的写法：
    - 经典类的写法：`父类名称.__init__(self,参数1，参数2，...)`
    - 新式类的写法：`super(子类，self).__init__(参数1，参数2，...)`


```python
class Person(object):
    def __init__(self,name,age):
        self.name = name
        self.age = age
        self.weight = 'weight'
        
    def talk(self):
        print("person is talking.....")
        
class Chinese(Person):
    def __init__(self,name,age,language):#先继承，再重构
        Person.__init__(self,name,age)#继承父类的构造方法
        self.language = language# 定义类的本身属性
        print(self.name,self.age,self.weight,self.language)
        
    def talk(self):# 子类 重构方法
        print('%s is speaking chinses'% self.name)
        
    def walk(self):
        print("is walkig...")
        
c = Chinese('Xiaowang',22,'Chinese')
c.talk()
        
        
```

    Xiaowang 22 weight Chinese
    Xiaowang is speaking chinses


继承构成类有向图,调用super()：广度优先搜索找到第一个符合条件的函数


```python
class A:
    def foo(self):
        print('call A.foo()')
    
class B(A):
    def foo(self):
        print('call B.foo()')

class C(A):
    def foo(self):
        print("call C.foo()")
    def foo2(self):
        super().foo()
        
class D(B,C):
    def foo(self):
        pass

d = D()
d.foo()
d.foo2()
```

    call C.foo()
    call A.foo()


- 继承与组合
    - 组合：init接收类作为参数，包含了两类不同对象（多个类的集成）
    - is a kind of:派生
    - has a kind of:组合


```python
class Turtle:
    def __init__(self,x):
        self.num = x

class Fish:
    def __init__(self,x):
        self.num = x
        
class Pool:
    def __init__(self,x,y):
        self.turtle = Turtle(x)
        self.fish = Fish(y)
        
    def number(self):
        print('%s Turtle, %s Fish' % (self.turtle.num,self.fish.num))

p = Pool(3,4)
p.number()
        
```

    3 Turtle, 4 Fish


- 类方法、静态方法
    - @staticmethon
        - 多次继承不会覆盖，保持编程环境的稳定性
    - @classmethod
        - self变为cls，可用于更高层次的类加工


```python
# 实现多个初始化函数
class Book(object):
    def __init__(self,title):
        self.title=title
        
    #@classmethod                     #注释掉以后调用时要显式输入类引用作为参数，
    def class_method_creat(cls,title):
        book = cls(title = title)
        return book
    
    @staticmethod
    def static_method_creat(title):
        book = Book(title)
        return book
    
    
book1 = Book("use instance_method_create book instance")
book2 = Book.class_method_creat(Book,"use class_method_creat book instance")# 注意这里的Book
book3 = Book.static_method_creat("use static_mythod_creat book instance")

print(book1.title)
print(book2.title)
print(book3.title)
```

    use instance_method_create book instance
    use class_method_creat book instance
    use static_mythod_creat book instance



```python
#使用静态方法创造稳定的环境
class Foo(object):
    X = 1
    Y = 14
    
    @staticmethod
    def averag(*mixes):
        return sum(mixes)/len(mixes)
    
    @staticmethod
    def static_method():# 静态方法不会随着继承到新环境而改变运算逻辑，直接用类名称
        print('父类中的静态方法')
        return Foo.averag(Foo.X,Foo.Y)
    
    @classmethod
    def class_method(cls):# cls指向类空间的方法，会随着继承到子类改变运算逻辑
        print('父类中的类方法')
        return cls.averag(cls.X,cls.Y)
    
class Son(Foo):
    X = 3
    Y = 5
    
    @staticmethod
    def averag(*mixes):
        print('子类中重载了父类的静态方法')
        print("666",mixes)
        return sum(mixes)/3
```

### Python 设计模式
是一种解决问题抽象，目的是把一些常见的应用抽象为一种类设计模式，具体实现中仅需套用或略作修改

- 单例模式：所有生成的实例均指向同一个对象
    - 用cls时，指向已有实例（重写new方法），只有第一次调用时产生新对象


```python
class Singleton(object):
    
    
    def __init__(self):
        print("Do something new.")
        
    def __new__(cls, *args, **kwargs):
        if not hasattr(Singleton,"_instance"):
            Singleton._instance = object.__new__(cls)#%%!反射机制
            
        return Singleton._instance
    
obj1 =Singleton()
obj2 = Singleton()
print(obj1,obj2)
        
    
```

    Do something new.
    Do something new.
    <__main__.Singleton object at 0x000002D230F04A88> <__main__.Singleton object at 0x000002D230F04A88>


- 观察者模式：发布-订阅模式
    - 多使用注册-通知-撤销注册的形式
    - observer将自己注册到被观察对象中，被观测对象将观测者存放在一个容器中
    - 被观察的对象发生了某种变化，从容器中得到所有注册过的观察者，将变化通知观察者

![image.png](attachment:image.png)


```python
class Subject:
    def __init__(self):
        self.observers = []
        
    def add_observers(self,observer):
        self.observers.append(observer)
        return self
    
    def remove_observer(self,observer):
        self.observers.remove(observer)
        return self
    
    def notify(self,msg):
        for observer in self.observers:
            observer.update(msg)
            
class Observer(object):
    def __init__(self,name):
        self.name = name
        
    def update(self,msg):
        p`rint(self.name+"收到了消息:"+msg)
            
xiaoming = Observer("xiaoming")
lihua = Observer("lihua")

rain = Subject()

rain.add_observers(xiaoming)
rain.add_observers(lihua)

rain.notify("下雨了！")

rain.remove_observer(lihua)

rain.notify("不下了！")
```

    xiaoming收到了消息:下雨了！
    lihua收到了消息:下雨了！
    xiaoming收到了消息:不下了！


## 文件操作
### Ipython下常用的文件操作命令
- %cd修改目录
- %ls显示目录内容
- %load加载代码
- %save保存cell
- %%writefile将单元格内容写到指定文件中
- %run运行脚本
- %run -d交互式调试器
- %timeit测试代码运行时间
- %%timeit测试代码运行时间
- 一个%：一行
- 两个%：一个代码块

### 文件读写
    python通过'open()'函数打开文件，一般用法为'open(filename,mode)',完整定义为'open(file,mode = "r",buffering = -1,encodig = None,errors = None,newline = None,closefd = True,opener = None)'
    Mode的可选值为：
- t:默认，文本模式
- x:写模式，若文件已存在则报错
- b:二进制模式，可读可写，打开一个文件进行更新
- r:只读打开，文件指针放在开头，默认
- rb:二进制只读，常用于非文本文件，如图片
- r+:读写，指针在文件开头
- rb+:二进制读写
- w:只写入，若文件已存在则打开文件，从头编辑，原有内容会被删除
- wb:二进制打开并写入，性质同上
- w+:打开并读写，从头开始编辑


```python
#readlines:把文件的所有行读成一个数组
f = open("test_input.txt")
print(f.readlines())
```

    ['testline1\n', 'testline2\n', 'test line 3']



```python
# read读入指定字节数的内容
f = open("test_input.txt")
print(f.read(8))
```

    testline



```python
f = open('test_input.txt')
for line in f:             # 一般可以把file看成可迭代对象
    print (line)
    
f = open("test_input.txt")
for line2 in f:           # print自带换行和line自带换行
    print(line2.strip())
```

    testline1
    
    testline2
    
    test line 3
    testline1
    testline2
    test line 3


写文件：write()


```python
of = open("test_output.txt",'w')
of.write("line1")
of.write("line2\n")
of.write('line3\n')
of.close()
```


```python
#字节文件的直接存取
f=open('test_input.txt',"rb+")
f.write(b'sds0123456789abcdef')# b 指明是字节流
f.seek(5)#Go to the 6th byte in the file
print(f.read(1))
print(f.tell())
f.seek(-3,2)# 后面的参数：0:从文件开头，1:从当前位置 2:从文件末尾
print(f.read(1))
f.close()
```

    b'2'
    6
    b'e'



```python
# 上下文管理器：退出自动关闭文件，规定了一块名字空间
with open('test_input.txt') as myfile:#自动执行析构函数，释放空间
    for line in myfile:
        print(line)
        
myfile.closed == 1
```

    sds0123456789abcdef
    
    test line 3





    True



## Pythom 类体系与架构编程
### 工厂模式：实现参数化定制类
- 本质是用类定制类，然后到具体实例
- 工厂模式的基础是共性抽象，把相关的类的共性和个性化定制相融合的解决方案


```python
#工厂模式示例：宠物
from abc import ABC,abstractmethod

class StandardFactory(object):
    
    @staticmethod                    #静态方法，稳定
    def get_factory(factory):        #实际可以传入更多参数
        '''根据参数找到相应的工厂'''
        if factory == "cat":
            return CatFactory()      #这里带参数，就要用到类属性和类方法
        elif factory == 'dog':
            return DogFactory()
        raise TypeError('Unknown Factory')
        
class DogFactory(object):
    def get_pet(self):               #这里可以带参数甚至组合其他类，定义不同的dog
        return Dog()                 #返回一个dog类的实例
    
class CatFactory(object):
    def get_pet(self):
        return Cat()
    
class Pet(ABC):                      #抽象类可以通过MyIterable方法查询所有派生子类
    @abstractmethod                  #强制子类必须实现该方法
    def eat(self):
        pass
     
    def jump(self):                  # 不能创建实例，可被继承
        print("jump,,,,")
    
class Dog(Pet):
    def eat(self):                   #必须实现抽象类Pet中被标记的方法
        return 'Dog eat...'
    
class Cat(Pet):
    def eat(self):
        return 'Cat eat....'
    
```


```python
#使用工厂类
if __name__ == "__main__":
    factory = StandardFactory.get_factory("cat")# 配置抽象工厂参数，生成一个猫工厂
    cat  =factory.get_pet()# 生成一个猫实例
    print(cat.eat())
    
    factory = StandardFactory.get_factory("dog")
    dog = factory.get_pet()
    print(dog.eat())
    
    dog.jump()#继承自抽象类的jump
    cat.jump()
```

    Cat eat....
    Dog eat...
    jump,,,,
    jump,,,,


被import进来的模块，'__name__()'等于模块名，但正在运行的会是main

#### Python的类实现方案优点
- 全面实现面向对象的解决方案，基本复刻Java的模式
- 提供了更高的灵活性
- 为参数话的软件架构编程提供了良好的支持

#### 类编程架构和函数编程架构总结
- 函数的嵌套构成数据加工流程，函数功能的抽象与装饰及函数闭包构成函数的装配加工方案
- 编程的本质是函数，而函数又可以被其它函数层层加工出来（函数闭包等）
- 类也是函数，也可用来被函数加工或加工函数，类定义类一个私有的数据和计算子环境
- 函数装饰器对应于类体系中的抽象类函数闭包中函数的返回值可以参考类的实例化过程
- 装饰器：本质上也是对抽象类的多继承

## 异常处理
- 使用local.__buildins__查看异常
- except 可以指定要捕获到异常，也可不加异常的种类
- raise：自举
- finally：最终必执行
- 异常处理流程：
    - 程序出错引发异常
    - 当前流程被打断，处理错误
    - 异常对象未被处理则回溯(traceback)终止

## Python 并发处理

### 进程，线程，协程

- 并行：在不同CPU核上跑两个进程，两个计算流在时间上重叠
- 并发：单核CPU跑两个进程，两个计算流在时间上相互独立
- 计算机执行程序流程
    - 程序翻译成机器指令
    - 程序计数器控制程序运行到哪一步
    - 通用目的计数器、浮点寄存器、条件码寄存器
        - 程序运行过程的草稿纸
        - 存储某些变量的值、中间计算结果等
    - 虚拟内存划分：进程用到的内存地址只是一个虚拟地址，内核负责把这个虚拟地址映射到物理内存
    - 内核负责资源调度
        -进程的挂起与唤醒：两进程间通过内核模式进行上下文切换，在用户模式下执行，每次切换需要重启进程，耗时较长
    - 每个进程有独立的逻辑控制流、私有的虚拟地址空间
- 表达式的互相协作
- 资源等待
- 进程之间逻辑上相互隔离，进程是内核安全的，不共享空间
- 进程：资源分配的最小单元，资源被内核保护，
    - 上下文：程序计数器、通用目的寄存器、浮点寄存器、状态寄存器、用户栈、内核栈、内核数据结构
- 线程(thread)：调度执行的最小单元
    - 每个线程运行在单一进程中，一个进程可以有多个线程
    - 内核不安全，需要锁，轻量级，切换快，线程为并发
    - 一个进程的不同线程共享进程上下文的剩余部分（如打开的文件表）
    - 上下文：程序计数器、通用目的寄存器、浮点寄存器、条件码、线程ID、栈、栈指针
- 锁机制：用于多个逻辑控制流同时读写共享资源时。读写前上锁，读写完释放锁，共享变量上锁时不可读写。误差允许时，可以不加锁以提高性能


### 多线程与多进程
- 多进程：程序之间不共享内存，使用的资源独立
    - 一个进程挂了不影响别的进程
    - 切换上下文效率低，通信和信息共享不方便
- 多线程
    - 上下文切换效率比进程高，线程之间信息共享和通信方便
    - 缺点：一个线程挂了会使整个进程挂掉，操作全局变量需要锁机制不太方便
    不同进程、线程之间总是并发或并行的
#### 多进程对象：Process对象
- p.start():启动进程，调用子进程中的p.run()
- p.run():进程启动时运行的方法 , 正是他去调用target指定的函数
- p.terminate():强制终止进程p,不会进行任何清理操作 ,如果p创建了子进程 ,该子进程就成了僵尸进程,使用该方法需要特别小心这种情况,如果p还保存了一个锁那么也将不会被释放,进而导致死锁
- p.is_alive() 如果p仍在运行，返回True
- p.join([timeout]):主线程等待 p终止 (强调 : 是主线程处于等待的状态 , 而p是处于运行状态 )timeout 是可选的超时间 , 需要强调的是 , p.join只能 join start 开启的进程 , 而不能join run开启的进程
- Tips:无论是进程还是线程，都遵循：守护xx会等待主xx运行完毕后被销毁，运行完毕并非终止运行
    - 对主进程，运行完毕指的是主进程代码执行完毕
    - 对主线程来说，运行完毕指的是主线程所在进程内所有非守护线程全部运行完毕
- join阻塞主进程


```python
# 在jupyter里体现不出多进程的优点?

from multiprocessing import Process
import os
import time

def hello(i):
    print("son process id {} -for task {}".format(os.getpid(),i))
    time.sleep(1)
    
if __name__ == "__main__":
    print('current father process {}'.format(os.getpid()))
    start = time.time()
    #p1 = Process(target = hello, args=(1,))# 包装一个进程
    #p2 = Process(target = hello, args=(2,))
    p1 = Process(target = hello(1))# 包装一个进程
    p2 = Process(target = hello(2))
    p1.start()
    p2.start()
    p1.join()
    p2.join()
    end = time.time()

    print("Totally take {} second".format((end - start)))


```

    current father process 101628
    son process id 101628 -for task 1
    son process id 101628 -for task 2
    Totally take 2.2871506214141846 second


### 多进程模式
- 进程池
    - 定义一个池子，里面放上固定数量的进程，有任务时就拿一个池子里的进程处理任务，处理完毕时拿一个进程处理任务，处理完毕后进程不关闭，返回进程池继续等任务。
    - 池中进程数量不够，任务会等待进程执行完前面的任务后回到进程池，拿到空闲进程才可继续进行
    - 同一时间最多有固定数量的进程在运行，不会增加操作系统的调度难度，节省开闭进程的时间，一定程度上实现了并发效果
- multiprocessing.Pool
    - numprocess：要创建的进程数。省略则默认使用os.cpu_count()
    - initializer：每个工作进程启动时执行的可调用对象，默认为None
    - initargs：传给initializer的参数组
    - p.apply(func[,args [,kwargs]]) 在一个池中执行func(*args,\**kwargs)再返回结果（同步调用）
    - p.apply_async(func[,args [,kwargs]])同上，异步调用，子进程执行的同时主进程会继续向下执行。
    - p.close()关闭进程池，防止进一步操作。如果操作持续挂起，则将在工作进程终止前完成
    - p.join() 等待所有工作进程退出，此方法只能在close()或terminate()之后调用


```python
from multiprocessing import Pool
import os,time,random

def long_time_task(name):
    print("Run task %s (%s)..."%(name,os.getpid()))
    start = time.time()
    time.sleep(random.random(2)*3)
    end = time.time()
    print('Task %s runs %0.2f seconds.'%(name,(end - start)))
    
if __name__ == "__main__":
    print('Parent process %s.'% os.getpid())
    p = Pool(4)
    for i in range(5):
        p.apply_async(long_time_task,args=(i,))
    print('Waiting for all subprocess done....')
    p.close()
    p.join()
    print('All subprocess done.')
```

![image.png](attachment:image.png)


```python
# 进程很多时，可以用进程池管理
from multiprocessing import Process,Pool
import os
import time

def hello(i):
    print("son process id {} - for task {}".format(os.getpid()))
    time.sleep(1)

if __name__ == "__main__":
    print("current father process {}".format(os.getpid()))
    start = time.time()
    p = Pool(4)
    for i in range(5):
        p.apply_async(hello, args = (i,))
    p.close()
    p.join()
    end = time.time()
    print("Totally take {} seconds".format((end-start)))
```

#### 进程间通讯
使用多个进程时，使用消息传递来进行进程之间的通信，并避免使用任何同步原语（如锁）
- 传递消息可以用Pipe()链接两个进程，或队列Queue(允许多个生产者和消费者)
- multiprocessing: 使用queue.Empty 和 queue.Full异常
- Queue有两个方法get和put
- Queue：
    - 近似于queue.Queue的克隆
    - q.put(item)将item放进队列中，当队列已满就会阻塞，直到有数据从管道中取出
    - q.put_nowait(item)将item放入序列，如果当前队列已满，直接报错
    - q.get()返回放入队列的一项数据，取出的是先放进去的数据，当前队列为空就会阻塞，直到放数据进来
    - q.get_nowait()同上，不阻塞但报错
- Pipe：返回一个由管道连接的链接对象，默认情况下是双工


```python
#多进程
from multiprocessing import Process,Pipe

def f(conn):
    conn.send([42,None,"hello"])
    conn.close()
    
if __name__ == "__main__":
    parent_conn,chile_conn = Pipe()
    p = Proess(target = f,args = (child_conn,))
    p.start()
    print(parent_conn.recv())
    p.join()
    
```

### 常见应用模式：生产者-消费者
生产者产生数据，消费者读取数据，数据常常保存在一个消息队列中   
python中提供Queue进行数据共享


```python
from multiprocessing import Process, Queue
import os,time,random

#写数据进程执行的代码
def producer(q):
    for value in range(5):
        print('Produce %d'%value)
        q.put(value)
        time.sleep(1)
        
def consumer(q):
    while True:
        value = q.get(True)
        print('Consume %d'%value)
        time.sleep(1)
        
if __name__ == "__main__":
    t0 = time.time()
    #父进程创建queue，传给各个子进程
    q = Queue()
    pw = Process(target = producer, args = (q,))
    pr = Process(target = consumer, args = (q,))
    # 启动子进程，写入
    pw.start()
    #读取
    pr.start()
    #等待pw结束
    pw.jion()
    #pr死循环，无法结束，直接强行终止
    pr.terminate()
    print("take %s s"%(time.time()-t0))
```

![image.png](attachment:image.png)


```python
# 多线程
import threading
import time

def hello(i):
    print('thread id:{}for task {}'.format(threading.current_thread().name,i))
    time.sleep(2)
    
if __name__ == "__main__":
    start = time.time()
    
    t1 = threading.Thread(target = hello,args = (1,))
    t2 = threading.Thread(target = hello,args = (2,))
    t1.start()
    t2.start()
    t1.join()
    t2.join()
    end = time.time()
    print("Take {} s".format((end - start)))
    
```

    thread id:Thread-6for task 1
    thread id:Thread-7for task 2
    Take 2.0088984966278076 s


![image.png](attachment:image.png)

#### Python 多线程编程
- Cpython中存在全局解释器锁，使得一个进程任意时刻仅有一个线程在执行，选用没有锁的JPython可解决该问题



## Python的协程与TKinter
### 协程
- 逻辑上独立运行的模块
- send：送值给赋了yield值的变量，yield完成后下一轮才进行赋值，所以第一次send必须是Ｎone（详见"有隐含功能的迭代器"）
- next相当于send None 
- 本质上诗同一个线程内串行交替进行
- 协程之间可以通过信号来协调运行或挂起
- 协程挂起后环境被保持，下次被执行可以直接开始运行


```python
# Python迭代器，通过自身的send函数被调
def fib(n):
    index = 0
    a = 0
    b = 1
    while index < n:
        receive = yield b
        print("fib receive %d "% receive)
        a,b = b,a+b
        index += 1

fib = fib(10)
print("fib yield %d "%fib.send(None))
print("fib yield %d "%fib.send(1))
print("fib yield %d "%fib.send(1))
print("fib yield %d "%fib.send(1))
print("fib yield %d "%fib.send(1))
```

    fib yield 1 
    fib receive 1 
    fib yield 1 
    fib receive 1 
    fib yield 2 
    fib receive 1 
    fib yield 3 
    fib receive 1 
    fib yield 5 



```python
# 制造一个含有隐含功能的迭代器
def get_cal():
    x = 1
    y = 1
    exp = None
    while x < 256:
        if exp == None:
            x,y = y,x+y
            exp = yield y
        else:
            exp = yield (eval(exp))

gc = get_cal()
print(next(gc))
print(next(gc))
print(gc.send('23-9/6'))
print(next(gc))
```

    2
    3
    21.5
    5


#### Python使用迭代器实现协程轮转调度
带有自阻塞功能的迭代器    
yield可以不返回值    



```python
def task1():
    timeN = 12
    dur = 6

    while timeN > 0:
        timeN -= dur
        print('Task1 need : ',timeN)
        yield timeN

    print("Task 1 Finished")

def task2():
    timeN = 11
    dur = 3

    while timeN > 0:
        timeN -= dur
        print('Task2 need : ',timeN)
        yield           #可以只中断进程而不返回值

    print("Task 1 Finished")

def RoundRobin(*task):
    tls = list(task)
    while len(tls) > 0:
        for p in tls:
            try:
                next(p)
            except StopIteration:
                tls.remove(p)
    print("All Finished")

t1 = task1()
t2 = task2()

RoundRobin(t1,t2)

```

    Task1 need :  6
    Task2 need :  8
    Task1 need :  0
    Task2 need :  5
    Task 1 Finished
    Task2 need :  2
    Task2 need :  -1
    Task 1 Finished
    All Finished


#### 回调函数：call back
函数中调用一个作为参数传入的函数。   
常用来实现函数功能的整合    
handler：句柄，类似于闭包（例子为整合日志函数和计算函数）    
回调函数可以在外部被装饰，作为一个范式化的句柄进行后续处理，再把句柄扔到前面的任务队列里实现任务管理    

​    


```python
def demo_callback(st):
    print(st)

def caller(args,func):
    print("Caller: Do Something.")
    func(args)

caller(('I am callee'),demo_callback)
```

    Caller: Do Something.
    I am callee



```python
# 回调函数方案实现函数功能组合
#日志+算法合并

def demo_handle(func,args,callback):
    result = func(*args)
    callback(result,func.__name__) # 参数： 计算结果 函数名

def add(x,y):
    return x+y

def notify(result,frm):
    print('Call fun {}() result = {}'.format(frm,result))

demo_handle(add,(3,5),callback=notify)
```

    Call fun add() result = 8


#### 异步阻塞


```python
def apply_handler(func,args,*,callback): #异步框架函数，协调运行
    result = func(*args)
    callback(result)  # 把计算结果交给回调函数

def add(x,y): return x+y  #计算函数
def times(x,y): return x*y

def make_handler():       #Handler 句柄
    counter = 0           # 计数器，记录总调用函数
    def handler(resurt):# 把要进行的任务包装一下
        nonlocal counter
        counter += 1
        print("counter = {} result: {}".format(counter,resurt))

    return handler

handler = make_handler()# 类似于装饰器，具备全局管理功能
apply_handler(add,(2,3),callback=handler)
apply_handler(times,(4,6),callback=handler)

```

    counter = 1 result: 5
    counter = 2 result: 24



```python
def apply_async(func,args,*,callback):# 异步方式组装回调函数
    result = func(*args)
    callback.send(result)#重新唤醒协程

def add(x,y): return x+y  #计算函数
def times(x,y): return x*y

def make_handler():       #Handler 句柄,把函数包装成协程
    counter = 0           # 计数器，记录总调用函数
    while True:
        result = yield#阻塞自己，等待被调用
        counter += 1
        print('counter = {} result = {}'.format(counter,result))

handle = make_handler()# 类似于装饰器，具备全局管理功能
next(handle)#初始化第一轮send。到yield 开始等待
apply_async(add,(2,3),callback=handle)
apply_async(times,(4,6),callback=handle)
```

    counter = 1 result = 5
    counter = 2 result = 24


#### 轮转调度队列中的协程
自阻塞和队列调度：使用pop-append实现任务的循环调度和任务管理（PPT中片子顺序有点问题）


```python

waiting_list = []#装着多个handle每个handle里包着不同的task

class Handle(object):
    def __init__(self,gen):
        self.gen = gen

    def call(self):
        try:
            next(self.gen)#被调用后实际做工作的部分
            waiting_list.append(self)#把自己放回列表最后
        except StopIteration:
            pass

def RoundRobin(*tasks):
    waiting_list.extend(Handle(c) for c in tasks)#加入被handle修饰的任务
    while waiting_list:
        p = waiting_list.pop(0)#从队头弹出一个handle
        p.call()#启动一个任务

    print("All Finished")

if __name__ == "__main__":
    RoundRobin(task1(),task2())
```

    Task1 need :  6
    Task2 need :  8
    Task1 need :  0
    Task2 need :  5
    Task 1 Finished
    Task2 need :  2
    Task2 need :  -1
    Task 1 Finished
    All Finished


#### python3.5后，使用async和await实现协程
串行运行    
另一种模式是使用create task，实现伪并发，谁空闲谁就可以走（自阻塞-发出异常-下一个task执行）    
还有timeout模式，设定超时，规定任务运行时间，超时则会抛出timeoyterror异常，结束掉这个协程。    
- 生成器/协程在正常返回退出时会抛出一个StopIteration异常，而原来的返回值会存放在StopIteration对象的value属性中
可用下面的方法拿到值：
- 通过await语法来挂起自身的协程，并等待另一个协程完成直到返回结果
- await语法只能出现在通过async修饰的函数中，否则会报SyntaxError错误。而且await后面的对象需要是一个Awaitable，或者实现了相关的协议。
- https://zhuanlan.zhihu.com/p/27258289
- 完成异步的代码不一定要用async/await，使用了async/await的代码也不一定能做到异步，async/await是协程的语法糖，使协程之间的调用变得更加清晰，使用async修饰的函数调用时会返回一个协程对象，await只能放在async修饰的函数里面使用，await后面必须要跟着一个协程对象或Awaitable，await的目的是等待协程控制流的返回，而实现暂停并挂起函数的操作是yield。


```python
try:
    async_function().send(None)
except StopIteration as e:
    print(e.value)
```


```python
%%writefile co-routine2.py
import asyncio
import time

async def say_after(delay,what):
    await asyncio.sleep(delay)
    print(what)

async def main():
    print(f"started at {time.strftime('%X')}")

    await say_after(1,'hello')
    await say_after(2,'world')

    print(f"finished at {time.strftime('%X')}")

asyncio.run(main())

```

    Writing co-routine2.py



```python
# 另一种main 的写法
async def main():
    task1 = asyncio.create_task(
        say_after(3,"hello")
    )
    task2 = asyncio.create_task(
        say_after(1,"world")
    )


    print(f"started at {time.strftime('%X')}")

    await task1
    await task2

    print(f"finished at {time.strftime('%X')}")

asyncio.run(main())
```


```python
#设置超时
import asyncio
import time

async def eternity():
    await asyncio.sleep(3600)
    print('yay!')

async def main():
    try:
        await asyncio.wait_for(eternity(),timeout=1.0)#设置超时
    except asyncio.TimeoutError:
        print('timeout!')

asyncio.run(main())
```

#### 使用事件队列循环实现生产者-消费者协程
生产者提前生成，消费者靠协程打断生产者的线程并取出已经生成的数据


```python
import asyncio,time

async def consumer(q):
    print('consumer starts.')
    while True:

        item = await q.get()

        if item is None:
            q.task_done()
            break
        else:
            await asyncio.sleep(1)
            print('consume %d '% item)
            q.task_done()

    print("consume ends.")

async def producer(q):
    print('producer starts.')

    for i in range(5):
        await asyncio.sleep(1)
        print('produce %d'%i)
        await q.put(i)

    await q.put(None)
    await q.join()
    print('producer ends.')

q = asyncio.Queue(maxsize=10)
t0 = time.time()
loop = asyncio.get_event_loop()
tasks = [producer(q),consumer(q)]
loop.run_until_complete(asyncio.wait(tasks))
loop.close()
print(time.time() - t0,"s")


```


    ---------------------------------------------------------------------------
    
    RuntimeError                              Traceback (most recent call last)
    
    <ipython-input-1-a9bb5c5f386c> in <module>
         33 loop = asyncio.get_event_loop()
         34 tasks = [producer(q),consumer(q)]
    ---> 35 loop.run_until_complete(asyncio.wait(tasks))
         36 loop.close()
         37 print(time.time() - t0,"s")


    ~\AppData\Local\Programs\Python\Python37\Lib\asyncio\base_events.py in run_until_complete(self, future)
        564         future.add_done_callback(_run_until_complete_cb)
        565         try:
    --> 566             self.run_forever()
        567         except:
        568             if new_task and future.done() and not future.cancelled():


    ~\AppData\Local\Programs\Python\Python37\Lib\asyncio\base_events.py in run_forever(self)
        519         self._check_closed()
        520         if self.is_running():
    --> 521             raise RuntimeError('This event loop is already running')
        522         if events._get_running_loop() is not None:
        523             raise RuntimeError(


    RuntimeError: This event loop is already running


    consumer starts.
    producer starts.
    produce 0
    produce 1
    consume 0 
    produce 2
    consume 1 
    produce 3
    consume 2 
    produce 4
    consume 3 
    consume 4 
    consume ends.
    producer ends.


#### 协程应用场景
- 协程之间不是并发-并行关系
- 逻辑上倾向于功能独立的例程
- 可反复调用时保持内部状态（yield）直到异常中断或自行退出
- 常用药IO，资源管理和操作响应等

#### 进程线程协程小结
- 根据问题特点选用合适的编程方式
    - 考虑通信方式
    - 计算/IO密集型
- 计算密集型常用多进程，每个进程完成独立的部分
- IO密集型使用多线程或协程

Handle:对Task的包装，用于流程控制，框架控制，任务运行完毕前一直是个时间片，不会终结，可以用来控制任务优先级，分配各个任务的时间片