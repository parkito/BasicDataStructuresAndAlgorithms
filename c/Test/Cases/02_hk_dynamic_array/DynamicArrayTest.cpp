#include "DynamicArrayTest.h"


std::string DynamicArrayTest::test_dir() {
    return cmake_dir() + "/Resource/02_hk_dynamic_array/";
}

std::vector<std::string> DynamicArrayTest::test_case(std::vector<std::string> &vector) {
    auto da = DynamicArray();
    std::vector<std::vector<int>> vecs;

    for (auto &str:vector) {
        std::vector<int> ve;
        ve.push_back(str[0] - '0');
        ve.push_back(str[2] - '0');
        ve.push_back(str[4] - '0');
        vecs.push_back(ve);
    }

    auto resultD = da.dynamicArray(2, vecs);
    std::vector<std::string> result;
    result.reserve(resultD.size());
    for (auto &lineInt:resultD) {
        result.push_back(std::to_string(lineInt));
    }
    return result;
}
