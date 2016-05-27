// Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
//
// Range Sum Query 2D
// The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
//
// Example:
// Given matrix = [
//       [3, 0, 1, 4, 2],
//       [5, 6, 3, 2, 1],
//       [1, 2, 0, 1, 5],
//       [4, 1, 0, 1, 7],
//       [1, 0, 3, 0, 5]
//     ]
//
// sumRegion(2, 1, 4, 3) -> 8
// update(3, 2, 2)
// sumRegion(2, 1, 4, 3) -> 10
// Note:
//     The matrix is only modifiable by the update function.
//     You may assume the number of calls to update and sumRegion function is distributed evenly.
//     You may assume that row1 ≤ row2 and col1 ≤ col2.
//
// Hide Tags Segment Tree Binary Indexed Tree
// Hide Similar Problems (M) Range Sum Query 2D - Immutable (M) Range Sum Query - Mutable

class NumMatrix {
    vector<vector<int>> tree;
    vector<vector<int>> ma;
public:
    NumMatrix(vector<vector<int>> &matrix) {
          void update(int row, int col, int val) {
