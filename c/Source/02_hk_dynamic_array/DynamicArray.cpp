#include "DynamicArray.h"

std::shared_ptr<std::vector<int>> find_seq(std::vector<std::shared_ptr<std::vector<int>>> &vectors,
                                           const int &x,
                                           const int &lastAnswer,
                                           const int &n) {
    return vectors[(x ^ lastAnswer) % n];
}

void append_to(std::shared_ptr<std::vector<int>> &vector, const int &y) {
    vector->push_back(y);
}

int find_new_last_answer(const std::shared_ptr<std::vector<int>> &vector, const int &y) {
    return vector->operator[](y % vector->size());
}

void print_new_last_answer(const int &lastAnswer) {
    cout << std::endl << lastAnswer;
}

std::vector<int> DynamicArray::dynamicArray(int n, std::vector<std::vector<int>> queries) {
    std::vector<std::shared_ptr<std::vector<int>>> seqs;
    seqs.reserve(n);
    for (int i = 0; i < n; ++i) {
        seqs.push_back(std::make_shared<std::vector<int>>());
    }
    int lastAnswer = 0;
    std::vector<int> result{};

    for (auto &vec:queries) {
        int type = vec[0];
        int x = vec[1];
        int y = vec[2];

        auto curSeq = find_seq(seqs, x, lastAnswer, n);
        if (type == 1) {
            append_to(curSeq, y);
        } else if (type == 2) {
            lastAnswer = find_new_last_answer(curSeq, y);
            result.push_back(lastAnswer);
            print_new_last_answer(lastAnswer);
        }
    }

    return result;
};
