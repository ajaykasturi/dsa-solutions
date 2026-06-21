# Binary Search

## Problem

Given a **sorted** array `arr[]` and a target value `x`, return the index of `x` in `arr[]` if present, otherwise return `-1`.

## Test Cases

| Input `arr[]`              | `x`  | Output         | Why                                                                                                                               |
| -------------------------- | ---- | -------------- | --------------------------------------------------------------------------------------------------------------------------------- |
| `{10, 15}`                 | `20` | `-1`           | `20` is greater than every element — not present                                                                                  |
| `{10, 15}`                 | `5`  | `-1`           | `5` is smaller than every element — not present                                                                                   |
| `{10, 10}`                 | `10` | `0` **or** `1` | Duplicate values — either index is a valid match; the exact result depends on implementation details (e.g. how `mid` is computed) |
| `{10, 20, 30, 40, 50, 60}` | `20` | `1`            | `20` is at index `1`                                                                                                              |
| `{5, 15, 25}`              | `25` | `2`            | `25` is at index `2`                                                                                                              |
| `{5, 10, 15, 25, 35}`      | `20` | `-1`           | `20` falls between `15` and `25` — not present                                                                                    |
