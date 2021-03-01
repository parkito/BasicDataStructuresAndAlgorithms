#include <iostream>
#include <vector>

int replace(const int &from, const int &to, std::vector<int> &arr) {
    for (int i = 0; i < arr.size(); ++i) {
        if (arr[i] == from) {
            arr[i] = to;
            return i;
        }
    }
    return -1;
}

void adjust_arr(int replaced, std::vector<int> &arr) {
    for (;;) {
        if (replaced + 1 < arr.size() && arr[replaced] > arr[replaced + 1]) {
            std::swap(arr[replaced], arr[replaced + 1]);
            replaced++;
        } else if (replaced - 1 >= 0 && arr[replaced] < arr[replaced - 1]) {
            std::swap(arr[replaced], arr[replaced - 1]);
            replaced--;
        } else {
            return;
        }
    }
}

int activityNotifications(std::vector<int> expenditure, int d) {
    int notifications = 0;
    std::vector<int> dayWindow(&expenditure[0], &expenditure[d]);
    std::sort(dayWindow.begin(), dayWindow.end());
    int lastDay = expenditure.size() - d;
    int middle = dayWindow.size() / 2;
    int *oneMed = &dayWindow[middle];
    int *secMed = &dayWindow[middle - 1];
    bool isComplexMed = dayWindow.size() % 2 == 0;
    for (int i = 0; i < lastDay; ++i) {
        int currentDay = expenditure[i + d];
        int median;
        if (isComplexMed) {
            median = *oneMed + *secMed;
        } else {
            median = *oneMed * 2;
        }
        if (currentDay >= median) {
            notifications++;
        }
        if (i + 1 < lastDay) {
            int replaced = replace(expenditure[i], currentDay, dayWindow);
            adjust_arr(replaced, dayWindow);
        } else {
            return notifications;
        }
    }
    return notifications;
}

int main() {
    std::cout << activityNotifications({2, 3, 4, 2, 3, 6, 8, 4, 5}, 5) << std::endl; //2
    std::cout << activityNotifications({1, 2, 3, 4, 4}, 4) << std::endl; //0
};
