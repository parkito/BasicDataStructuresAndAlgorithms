#include <iostream>

int divide(int dividend, int divisor) {
    if (divisor == 0) {
        throw std::runtime_error("Divisor cannot be 0");
    }
    if (dividend == 0) {
        return 0;
    }
    int abs_dd = std::abs(dividend);
    int abs_dr = std::abs(divisor);
    int counter = 0;
    for (int accum = abs_dr; accum <= abs_dd;) {
        counter++;
        accum += abs_dr;
    }
    int quotient;
    if (counter == 0) {
        return 0;
    } else {
        quotient = counter;
    }

    if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
        return quotient;
    }
    return -quotient;
}

int main() {
    std::cout << divide(4, 2) << std::endl; //2
    std::cout << divide(3, 2) << std::endl;//1
    std::cout << divide(5, 3) << std::endl;//1
    std::cout << divide(1, 3) << std::endl;//0
    std::cout << divide(3, 3) << std::endl;//1
    std::cout << divide(-3, 3) << std::endl;//-1
    std::cout << divide(6, -3) << std::endl;//-2
    std::cout << divide(0, -3) << std::endl;//0
    std::cout << divide(1, 0) << std::endl;//exception
}