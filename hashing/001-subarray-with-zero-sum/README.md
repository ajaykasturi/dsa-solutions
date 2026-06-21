# Subarray with 0 Sum

## Test Cases

| Input                    | Output | Why                                              |
| ------------------------ | ------ | ------------------------------------------------ |
| `{1, 4, 13, -3, -10, 5}` | true   | Subarray `[13, -3, -10]` sums to 0               |
| `{-1, 4, -3, 5, 1}`      | true   | Subarray `[-1, 4, -3]` sums to 0                 |
| `{3, 1, -2, 5, 6}`       | false  | No contiguous subarray sums to 0                 |
| `{5, 6, 0, 8}`           | true   | Single element `0` counts as a zero-sum subarray |