#pragma once

#include <iostream>
#include <vector>

#define SOURCE_DIR "${CMAKE_SOURCE_DIR}"

class Tester {
public:
    void run_tests();

protected:
    virtual std

    ::string test_dir() = 0;

    virtual std::vector<
            std::string>
    test_case(std::vector<
            std::string> &) = 0;
};

