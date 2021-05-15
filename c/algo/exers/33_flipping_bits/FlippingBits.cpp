#include <iostream>
#include <bits/stdc++.h>

long flippingBits(long n) {
    for (int i = 0; i < 32; ++i) {
        n ^= 1U << i;
    }
    return n;
}

int main() {
    std::cout << flippingBits(2147483647) << std::endl; //2147483648
    std::cout << flippingBits(1) << std::endl; //4294967294
    std::cout << flippingBits(0) << std::endl; //4294967295
}