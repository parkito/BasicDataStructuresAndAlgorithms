#include <iostream>

long countA(const std::string &s, long to) {
    long as = 0;
    for (int i = 0; i < to; ++i) {
        if (s[i] == 'a') {
            as++;
        }
    }
    return as;
}

long repeatedString(std::string s, long n) {
    if (n <= s.length()) {
        return countA(s, n);
    } else {
        long mod = n % s.length();
        long dev = n / s.length();
        return dev * countA(s, s.length()) + countA(s, mod);
    }
}

int main() {
    std::cout << repeatedString("aba", 10) << std::endl;
    std::cout << repeatedString("a", 1000000000000) << std::endl;
}
