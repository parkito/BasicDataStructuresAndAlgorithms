#pragma once

#include <iostream>
#include <vector>
#include <fstream>
#include <sstream>

namespace global {
    template<typename T>
    void print(const std::vector<T> &vector) {
        for (auto &vec :vector) {
            std::cout << vec << std::endl;
        }
        std::cout << std::endl;
    }

    template<typename T>
    void swap(T &a, T &b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    std::string file_to_string(std::string path) {
        std::ifstream inFile;
        inFile.open(path); //open the input file

        std::stringstream strStream;
        strStream << inFile.rdbuf(); //read the file
        return strStream.str(); //str holds the content of the file
    }
}
