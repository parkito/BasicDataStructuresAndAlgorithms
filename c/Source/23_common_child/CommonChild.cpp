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

bool contains(std::string &str, std::vector<char> &sub, int &from) {
    for (int i = 0; i < str.length(); ++i) {
        int orig = i;
        for (int j = from; j < sub.size(); ++j) {
            if (str[orig] == sub[j]) {
                orig++;
            } else {
                break;
            }
            if (j == sub.size() - 1) {
                return true;
            }
        }
    }
    return false;
}

int commonChild(std::string s1, std::string s2) {
    std::unordered_set<char> set2 = to_set(s2);
    std::vector<char> substr = std::vector<char>();
    for (auto &ch:s1) {
        if (set2.find(ch) != set2.end()) {
            substr.push_back(ch);
        }
    }
    for (int i = 0; i < substr.size(); ++i) {
        if (contains(s1, substr, i) && contains(s2, substr, i)) {
            return substr.size() - i;
        }
    }

    return 0;
}

int main() {
    std::cout << commonChild("HARRY", "SALLY") << std::endl;//2
}
