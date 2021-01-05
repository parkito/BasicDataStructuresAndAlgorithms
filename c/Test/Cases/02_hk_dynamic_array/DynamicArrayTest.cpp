#include "DynamicArray.h"
#include "Tester.h"
#include "Cmake.h"

class DynamicArrayTest : public Tester {

protected:
    std::string test_dir() override {
        return cmake_dir() + "/Resource/02_hk_dynamic_array/";
    }

    std::vector<std::string> test_case(std::vector<std::string> &vector) override {
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
};