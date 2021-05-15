#include <iostream>
#include <vector>

void minimumBribes(std::vector<int> q) {
    int bribes = 0;
    int donePosStart = 0;
    int donePosEnd = q.size() - 1;
    for (int i = 0; donePosStart < donePosEnd; ++i) {
        if (q[donePosStart] == donePosStart + 1) {
            donePosStart++;
        }
        if (donePosStart == donePosEnd) {
            break;
        }
        if (i == donePosEnd) {
            donePosEnd--;
            i = donePosStart;
        }
        if (q[i + 1] < q[i]) {
            if (q[i] - i > 3) {
                std::cout << "Too chaotic" << std::endl;
                return;
            }
            bribes++;
            std::swap(q[i + 1], q[i]);
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
    minimumBribes({2, 3, 1}); //2;
}
