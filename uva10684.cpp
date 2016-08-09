#include <iostream>
#include <cstdlib>
#include <vector>

using namespace std;

int main() {
  while (true) {
    int n, k;
    cin >> n;
    if (n == 0) {
      break;
    }
    int sum = 0;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      cin >> k;
      if (sum < 0) {
        sum = 0;
      }
      sum += k;
      ans = max(sum, ans);
    }
    if (sum <= 0) {
      cout << "Losing streak." << endl;
    } else {
      cout << "The maximum winning streak is " << ans << "." << endl;
    }
  }
  return 0;
}
