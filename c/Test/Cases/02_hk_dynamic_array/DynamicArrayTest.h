#include "DynamicArray.h"
#include "Tester.h"
#include "Cmake.h"

class DynamicArrayTest : public Tester {

protected:
    std::string test_dir() override;

    std::vector<std::string> test_case(std::vector<std::string> &vector) override;
};