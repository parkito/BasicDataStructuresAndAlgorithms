#include <iostream>

int countingValleys(int steps, std::string path) {
    int valleys = 0;
    int currentLevel = 0;
    bool isValleyNow = false;
    for (auto &op:path) {
        if (op == 'D') {
            currentLevel--;
        } else if (op == 'U') {
            currentLevel++;
        }
        if (currentLevel < 0 && !isValleyNow) {
            isValleyNow = true;
        } else if (currentLevel == 0 && isValleyNow) {
            valleys++;
            isValleyNow = false;
        }
    }

    return valleys;
}

int main() {
    std::cout << countingValleys(8, "UDDDUDUU") << std::endl;
}
