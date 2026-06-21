# Count Distinct Elements

## Test Cases

| Input | Output | Why |
|---|---|---|
| `{15, 12, 13, 12, 13, 13, 18}` | `4` | Distinct values: `15, 12, 13, 18` (12 and 13 repeat) |
| `{10, 10, 10}` | `1` | Every element is the same value |
| `{10, 11, 12}` | `3` | All three elements are already distinct |

---

## Optimized Solution

### Approach

Use a **Set** to track values already seen. Walk through the array once — for each element, add it to the set only if it isn't already there. Duplicates get skipped automatically since a set can't hold repeated values. At the end, the set's size is the count of distinct elements.

### Dry Run: `arr[] = {10, 20, 10, 20, 30}`

`s = {}` initially

| i | arr[i] | s (after) |
|---|---|---|
| 0 | 10 | `{10}` |
| 1 | 20 | `{10, 20}` |
| 2 | 10 | `{10, 20}` — already present, skipped |
| 3 | 20 | `{10, 20}` — already present, skipped |
| 4 | 30 | `{10, 20, 30}` |

**Result:** `3` distinct elements (`10, 20, 30`)

### Time Complexity

O(n) — one pass through the array

### Aux Space

O(d) — where `d` is the number of distinct elements stored in the set
