---
layout: post
title: Python PCA-SVD
tags: 
- Python
- PCA
- SVD
categories: Python
description: PCA与SVD 基础原理
---



# Python PCA SVD

- 特征分布越平，方差越大，对数据的区分度越好
- 非正交的基：带来冗余信息
- 正交性：特征的协方差矩阵。为0则互相独立
- 协方差矩阵：对角元素为特征的方差，其它为相关性

## PCA
主成分分解    
- 先中心化，转置乘自身，得到实对称矩阵，再PCA对角化，此时对角元即为新特征的方差，方差越大区分度越高，舍去小方差即可完成降维
- 降维后低秩的矩阵为样本提供了更好的分布，将原样本投射到新的维度中。降维可以减小噪音


```python
import sklearn
import numpy as np
from sklearn.preprocessing import StandardScaler
```


```python
a = np.array([[1,2,3],[2,4,6]])
print(np.mean(a))
print(np.mean(a,axis = 0))
print(np.mean(a,axis = 1))

b = np.array([[[1,2],[3,4]],[[3,4],[5,6]]])
print(np.mean(b,axis = 0))

a_std = StandardScaler().fit_transform(a)
print(a_std)

a_std = StandardScaler(with_std = False).fit_transform(a)
print(a_std)

```

    3.0
    [1.5 3.  4.5]
    [2. 4.]
    [[2. 3.]
     [4. 5.]]
    [[-1. -1. -1.]
     [ 1.  1.  1.]]
    [[-0.5 -1.  -1.5]
     [ 0.5  1.   1.5]]


- 二维PCA：最大化协方差矩阵的迹，协方差矩阵基于图像求得
- Robust PCA：降噪PCA
    - PCA损失函数为F范数，平方误差损失使得最终结果对强噪声敏感
    - 加上一个稀疏矩阵（的L1范数）用于允许例外的存在，可以屏蔽稀疏噪声的影响

## SVD
奇异值分解
- 将原特征空间中样本向量重新用一组新的系数和基表达，中间的奇异值矩阵表示向量的拉伸程度，此时的基相当于原样本的"零件"
- 泛化与泛化损失（推荐系统
- 泛化界：衡量泛化的程度，维度过低会产生泛化损失。但适当泛化，系统的鲁棒性较好
- 降维：丢弃奇异值小的主成分

- SVD不作中心化，将样本集分解为参数*特征的线型表达，可以加先验（机器学习，神经网络）
- PCA用于特征工程，降噪，数据压缩等（分解，特征工程）

降维维度过低：损失较大
- 谱聚类、社区划分、拉普拉斯矩阵
- 不好量化的量：按照关系加权



```python

```


```python

```


```python

```


```python

```


```python

```


```python

```


```python

```


```python

```


```python

```


```python

```


```python

```
