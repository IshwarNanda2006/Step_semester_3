# Week 10 Homework - Complexity Notes

| Problem | Solution | Time | Extra space | Comparison / reason |
|---|---|---:|---:|---|
| P7 Second-Best Score | Track highest and second-highest distinct scores in one pass; never sort. | O(n) | O(1) | Sorting first is O(n log n), plus sorting may mutate the input; one pass is faster asymptotically and preserves the array. |
| P4 Exam Score Band Counter | `lowerBound(low)` gives the first score >= low; `upperBound(high)` gives the first score > high. Subtract the indices. | O(log n) | O(1) | A linear scan is O(n). Lower/upper bounds include all duplicates at both inclusive endpoints. |
| P8 Duty Roster Rotation | Reduce k using `k % n` and place each name at `(i + shift) % n`. | O(n) | O(n) | Repeated single-place rotations can take O(k*n) with array shifts. Modulo avoids full rotations when k is huge. |
| P6 Class Attendance Tracker | Count present days and maintain current and longest streak in the same traversal. | O(n) | O(1) | Both answers can be calculated in one pass without another array. |
| P10 Busiest Bus Row | Sum each row, update the best only when a strictly larger total is found. | O(r*c) | O(1) | Each grid cell is inspected once; strict `>` keeps the earlier row when totals tie. |
