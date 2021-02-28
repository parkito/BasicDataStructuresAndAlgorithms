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

double to_median(std::vector<int> &arr) {
    std::sort(arr.begin(), arr.end());
    return median(arr);
}

void replace(const int &from, const int &to, std::vector<int> &arr) {
    for (int &i : arr) {
        if (i == from) {
            i = to;
            break;
        }
    }
}

int activityNotifications(std::vector<int> expenditure, int d) {
    int notifications = 0;
    std::vector<int> temp(&expenditure[0], &expenditure[d]);
    int firstTo = expenditure[0];
    for (int i = 0; i + d < expenditure.size(); ++i) {
        double median = to_median(temp);
        int currentDay = i + d;
        int currentDaySum = expenditure[currentDay];
        if (currentDaySum >= median * 2) {
            notifications++;
        }
        replace(firstTo, currentDaySum, temp);
        firstTo = currentDay;
    }
    return notifications;
}

int main() {
    std::cout << activityNotifications({2, 3, 4, 2, 3, 6, 8, 4, 5}, 5) << std::endl; //2
    std::cout << activityNotifications({1, 2, 3, 4, 4}, 4) << std::endl; //0
};
