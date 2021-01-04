#include "StringLength.cpp"
#include "Tester.cpp"
#include "Cmake.h"

class StringLengthTest : public Tester {

protected:
    std::string test_dir() override {
        return cmake_dir() + "/Resource/01_string_length/";
    }

    static std::string to_string(const std::vector<std::string> &vec) {
        if (vec.empty()) {
            return "";
        } else {
            return vec[0];
        }
    }

    std::vector<std::string> test_case(std::vector<std::string> &vector) override {
        size_t result = StringLength().stringLength(to_string(vector));
        return {std::to_string(result)};
    }
};