class Solution {
public:
  string largestMultipleOfThree(vector<int>& digits) {
    long long int sum = 0;
    int zerocount = 0;
    for (int x : digits)  sum += x, zerocount += (x == 0 ? 1 : 0);
    int rem = sum % 3;
    sort(digits.rbegin(), digits.rend());
    if (rem == 1) {
      //trying to remove 1 modder
      bool modderFound = false;
      for (int i = digits.size() - 1; i >= 0; i--) {
        if (digits[i] % 3 == 1) {
          modderFound = true;
          digits.erase(digits.begin() + i);
          break;
        }
      }
      if (!modderFound) {
        vector<int> idxes;
        for (int i = digits.size() - 1; i >= 0; i--) {
          if (digits[i] % 3 == 2) {
            idxes.push_back(i);
            if (idxes.size() == 2) break;
          }
        }
        if (idxes.size() == 2) {
          digits[idxes[0]] = -1;
          digits[idxes[1]] = -1;
        } else return "";
      }
    } else if (rem == 2) {
      bool modderFound = false;
      for (int i = digits.size() - 1; i >= 0; i--) {
        if (digits[i] % 3 == 2) {
          modderFound = true;
          digits.erase(digits.begin() + i);
          break;
        }
      }
      if (!modderFound) {
        vector<int> idxes;
        for (int i = digits.size() - 1; i >= 0; i--) {
          if (digits[i] % 3 == 1) {
            idxes.push_back(i);
            if (idxes.size() == 2) break;
          }
        }
        if (idxes.size() == 2) {
          digits[idxes[0]] = -1;
          digits[idxes[1]] = -1;
        } else return "";
      }
    }

    string str = "";
    if (digits[0] == 0) return "0";
    for (int x : digits)if (x != -1)str.append(to_string(x));
    return str;
  }
};