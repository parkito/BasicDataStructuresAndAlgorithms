#include "Tester.h"
#include <filesystem>

void Tester::run_tests() {
    for (const auto &entry : std::filesystem::directory_iterator(test_dir())) {
        std::cout << entry.path() << std::endl;
    }
}
