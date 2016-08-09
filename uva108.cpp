#include <iostream>
#include <cstdlib>
#include <vector>

using namespace std;

int main() {
  int n, k;
  cin >> n;
  int sums[n][n];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      cin >> k;
      sums[i][j] = k;

      if (i > 0) {
        sums[i][j] += sums[i-1][j];
      }
      if (j > 0) {
        sums[i][j] += sums[i][j-1];
      }
      if (i > 0 && j > 0) {
        sums[i][j] -= sums[i-1][j-1];
      }
    }
  }

  int max = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      for (int k = i; k < n; k++) {
        for (int l = j; l < n; l++) {
          int square = sums[k][l];
          if (j > 0) {
            square -= sums[k][j-1];
          }
          if (i > 0) {
            square -= sums[i-1][l];
          }
          if (i > 0 && j > 0) {
            square += sums[i-1][j-1];
          }
          if (square > max) {
            max = square;
          }
        }
      }
    }
  }
  cout << max << endl;
  return 0;
}
