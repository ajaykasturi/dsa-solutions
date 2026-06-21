# Longest Subarray with Given Sum

## Test Cases

| Input                      | Target Sum | Output | Why                                                                                                           |
| -------------------------- | ---------- | ------ | ------------------------------------------------------------------------------------------------------------- |
| `{5, 8, -4, -4, 9, -2, 2}` | `0`        | `3`    | `{8, -4, -4}` sums to 0, length 3 — longest among matches (`{-2, 2}` also sums to 0 but is shorter, length 2) |
| `{3, 1, 0, 1, 8, 2, 3, 6}` | `5`        | `4`    | `{3, 1, 0, 1}` sums to 5, length 4 — longest among matches (`{2, 3}` also sums to 5 but is shorter, length 2) |
| `{8, 3, 7}`                | `15`       | `0`    | No subarray sums to 15, so no valid subarray exists                                                           |

---

## Idea

$$\underbrace{a_0,\ a_1,\ \ldots,\ a_i}_{\text{preSum}},\ \underbrace{a_{i+1},\ \ldots,\ a_j}_{\text{sum}},\ \ldots,\ a_{n-1}$$

$$\text{preSum} = a_0 + a_1 + \cdots + a_i = \sum_{k=0}^{i} a_k$$

$$\text{sum} = a_{i+1} + \cdots + a_j = \sum_{k=i+1}^{j} a_k$$

$$\text{preSum} + \text{sum} = a_0 + a_1 + \cdots + a_j = \sum_{k=0}^{j} a_k$$

$$\text{length} = j - i$$

We use a map to store the prefix-sum and the **last** index of the prefix-sum array.

### Example using efficient solution

```
arr[]   = { 8,  3,  1,  5,  -6,  6,  2,  2 }
indexes = { 0,  1,  2,  3,   4,  5,  6,  7 }
sum = 4
```

```
initially
    prefixSum = 0
    m = {}
    res = 0   (res is used to store max length of subarray)

i=0
    prefixSum = 8
    8-4=4 is present in m? No
    m = {(8,0)}, res = 0

i=1
    prefixSum = 8+3 = 11
    11-4=7 is present in m? No
    m = {(8,0), (11, 1)}, res = 0

i=2
    prefixSum = 11+1 = 12
    12-4=8 is present in m? Yes
    res = max(res, 2-0) = 2
    m = {(8,0), (11, 1), (12, 2)}, res = 2

i=3
    prefixSum = 12+5 = 17
    17-4=13 is present in m? No
    m = {(8,0), (11, 1), (12, 2), (17, 3)}, res = 2

i=4
    prefixSum = 17 - 6 = 11
    Here prefixSum = 11 is already present in map
        - You do not replace old entry with new one. ignore it
        - Logic behind this:
            - sum of elements from index 1 to 4 is zero
            - you get longest subarray with old entry
    m = {(8,0), (11, 1), (12, 2), (17, 3)}, res = 2

i=5
    prefixSum = 11 + 6 = 17
    Here prefixSum = 17 is already present in map
        - You do not replace old entry with new one. ignore it
        - Logic behind this:
            - sum of elements from index 1 to 4 is zero
            - you get longest subarray with old entry
    m = {(8,0), (11, 1), (12, 2), (17, 3)}, res = 2

i=6
    prefixSum = 17 + 2 = 19
    19-4=15 is present in m? No
    m = {(8,0), (11, 1), (12, 2), (17, 3), (19, 6)}, res = 2

i=7
    prefixSum = 19 + 2 = 21
    21-4=17 is present in m? Yes
    res = max(res, 7-3=4) = 4
    here you can see that (17, 3) which is old is used to get longer length
    m = {(8,0), (11, 1), (12, 2), (17, 3), (21, 7)}, res = 4
```
