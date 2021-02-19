#include <iostream>
#include <vector>
#include <map>
#include "../00_global/Global.h"

void minimumBribes(std::vector<int> q) {
    int bribes = 0;
    int donePos = 0;
    std::map<int, int> map = std::map<int, int>{};
    for (int i = 0; i < q.size() - 1;) {
        if (q[i + 1] - q[i] == 1) {
            i++;
            if (q[donePos + 1] - q[donePos] == 1) {
                donePos++;
            }
        } else if (q[i + 1] > q[i]) {
            i++;
        } else {
            if (map.find(q[i]) != map.end()) {
                int elemMoves = ++map[q[i]];
                if (elemMoves > 2) {
                    std::cout << "Too chaotic" << std::endl;
                    return;
                }
            } else {
                map.insert(std::make_pair(q[i], 1));
            }
            bribes++;
            global::swap(q[i + 1], q[i]);
            if (q[donePos + 1] - q[donePos] == 1) {
                donePos++;
            }
        }
        if (i == q.size() - 1 && i != donePos) {
            i = donePos;
        }
    }

    std::cout << bribes << std::endl;
}

int main() {
    minimumBribes({1, 2, 3, 5, 4, 6, 7, 8}); //1
    minimumBribes({4, 1, 2, 3}); //Too chaotic
    minimumBribes({2, 1, 5, 3, 4}); //3
    minimumBribes({2, 5, 1, 3, 4}); //Too chaotic
    minimumBribes({5, 1, 2, 3, 7, 8, 6, 4}); //Too chaotic
    minimumBribes({1, 2, 5, 3, 7, 8, 6, 4}); //7;
}
