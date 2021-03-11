#include <iostream>

bool isSpecial(const std::string &st, const int &from, const int &to) {
    char first = st[from];
    int subStringSize = to - from;
    int mid = -1;
    if (subStringSize > 1 && (subStringSize + 1) % 2 == 1) {
        mid = from + subStringSize / 2;
    }
    for (int i = from + 1; i <= to; ++i) {
        if (st[i] != first) {
            if (mid > 0) {
                if (i != mid) {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
    return true;
}

long substrCount(int n, std::string s) {
    if (n <= 1) {
        return n;
    }
    long counter = 0;
    for (int i = 1; i < n; ++i) {
        for (int j = 0; j + i < n; ++j) {
            if (isSpecial(s, j, j + i)) {
                counter++;
            }
        }
    }
    return counter + n;
}

int main() {
    std::cout << substrCount(std::string("mnonopoo").size(), "mnonopoo") << std::endl; //12
    std::cout << substrCount(std::string("asasd").size(), "asasd") << std::endl; //7
    std::cout << substrCount(std::string("abcbaba").size(), "abcbaba") << std::endl; //10
    std::cout << substrCount(std::string("aaaa").size(), "aaaa") << std::endl; //10
};

