#include <iostream>
#include <unordered_set>
#include <vector>

std::unordered_set<char> to_set(std::string &str) {
    std::unordered_set<char> set = std::unordered_set<char>();
    for (auto &ch:str) {
        set.insert(ch);
    }
    return set;
}

std::vector<char> to_substr(std::string &str, std::unordered_set<char> set) {
    std::vector<char> substr = std::vector<char>();
    for (auto &ch:str) {
        if (set.find(ch) != set.end()) {
            substr.push_back(ch);
        }
    }
    return substr;
}

bool contains(std::string &str, std::vector<char> &sub, int &from) {
    for (int i = 0, j = from; i < str.length(); ++i) {
        if (str[i] == sub[j] && i != j) {
            j++;
        }
        if (j == sub.size() - 1) {
            return true;
        }
    }

    return false;
}

int commonChild(std::string s1, std::string s2) {
    int matrix[s1.length() + 1][s2.length() + 1];
    for (int i = 0; i <= s1.length(); i++) {
        for (int j = 0; j <= s2.length(); j++) {
            if (i == 0 || j == 0)
                matrix[i][j] = 0;

            else if (s1[i - 1] == s2[j - 1])
                matrix[i][j] = matrix[i - 1][j - 1] + 1;

            else
                matrix[i][j] = std::max(matrix[i - 1][j], matrix[i][j - 1]);
        }
    }

    return matrix[s1.length()][s2.length()];
}

int main() {
    std::cout << commonChild("HARRY", "SALLY") << std::endl;//2
    std::cout << commonChild("SHINCHAN", "NOHARAAA") << std::endl;//3
    std::cout << commonChild("AA", "BB") << std::endl;//0
}
