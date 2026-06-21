# Longest Subarray with Equal 0s and 1s\*\*

Input is a binary array (`0`s and `1`s only).

## Test Cases

| #   | Input `arr[]`              | Output | Matching subarray                               |
| --- | -------------------------- | ------ | ----------------------------------------------- |
| 1   | `{1, 0, 1, 1, 1, 0, 0}`    | `6`    | `{0, 1, 1, 1, 0, 0}` (indices 1–6)              |
| 2   | `{1, 1, 1, 1}`             | `0`    | none — no `0`s present at all                   |
| 3   | `{0, 0, 1, 1, 1, 1, 1, 0}` | `4`    | `{0, 0, 1, 1}` (indices 0–3)                    |
| 4   | `{0, 0, 1, 0, 1, 1}`       | `6`    | `{0, 0, 1, 0, 1, 1}` (indices 0–5, whole array) |
