#pragma once

#include "stdexcept"

namespace ds_utils {

    static const std::size_t BAG_DEFAULT_SIZE = 10;
    static const std::size_t BAG_DEFAULT_REPLICATION_NUMBER = 2;

    static const std::size_t STACK_DEFAULT_SIZE = 10;
    static const std::size_t STACK_DEFAULT_REPLICATION_NUMBER = 2;

    template<typename T>
    void copy_store(const std::size_t fromSize, const T *arrFrom, T *arrTo) {
        for (std::size_t i = 0; i < fromSize; ++i) {
            arrTo[i] = arrFrom[i];
        }
    }

    template<typename T>
    T *extend_store(const std::size_t baseSize, const T *arrFrom, const std::size_t extendedSize) {
        if (baseSize >= extendedSize) {
            throw std::runtime_error("New size cannot be smaller than old size");
        }
        T *newStore = new T[extendedSize];
        copy_store(baseSize, arrFrom, newStore);
        return newStore;
    }

}