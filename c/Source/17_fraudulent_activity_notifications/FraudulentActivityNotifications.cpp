#include <iostream>
#include <vector>

double median(const std::vector<int> &exp) {
    if (exp.size() % 2 == 0) {
        int middle = exp.size() / 2;
        return double(exp[middle] + exp[middle - 1]) / 2;
    } else {
        return exp[exp.size() / 2];
    }
}

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
            break;
        }
    }
}

int activityNotifications(std::vector<int> expenditure, int d) {
    int notifications = 0;
    std::vector<int> temp(&expenditure[0], &expenditure[d]);
    std::sort(temp.begin(), temp.end());
    int lastDay = expenditure.size() - d;
    for (int i = 0; i < lastDay; ++i) {
        double med = median(temp);
        int currentDaySum = expenditure[i + d];
        if (currentDaySum >= med * 2) {
            notifications++;
        }
        if (i + 1 < lastDay) {
            int replaced = replace(expenditure[i], currentDaySum, temp);
            adjust_arr(replaced, temp);
        }
    }
    return notifications;
}

int main() {
    std::cout << activityNotifications({2, 3, 4, 2, 3, 6, 8, 4, 5}, 5) << std::endl; //2
    std::cout << activityNotifications({1, 2, 3, 4, 4}, 4) << std::endl; //0
};
