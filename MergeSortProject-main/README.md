# Merge Sort Project

## [16,21,11,8,12,22]

<br>
1.Yukarıdaki dizinin sort türüne göre aşamalarını yazınız.
<br>
<br>

| Syntax | Outlook  |
| ----------- | ----------- |
| Stage 1 | [16,21,11,8,12,22] |
| Stage 2 | [16,21,11]-[8,12,22]
| Stage 3 | [16,21]-[11]-[8,12]-[22] |
| Stage 4 | [16]-[21]-[11]-[8]-[12]-[22] |
| Stage 5 | [16,21]-[11]-[8,12]-[22] |
| Stage 6 | [11,16,21]-[8,12,22] |
| Stage 7 | [8,11,12,16,21,22]|

## Big-O gösterimini yazınız.

```
O(n.logn)
```