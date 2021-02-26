#include <iostream>
#include <vector>

double median(const std::vector<int> &exp) {
    if (exp.size() % 2 == 0) {
        int middle = exp.size() / 2;
        return double (exp[middle] + exp[middle - 1]) / 2;
    } else {
        return exp[exp.size() / 2];
    }
}

double to_median(const int &from, const int &to, const std::vector<int> &arr) {
    std::vector<int> sub(&arr[from], &arr[to]);
    std::sort(sub.begin(), sub.end());
    return median(sub);
}

int activityNotifications(std::vector<int> expenditure, int d) {
    int notifications = 0;
    for (int i = 0; i + d < expenditure.size(); ++i) {
        double median = to_median(i, d + i, expenditure);
        int currentDaySum = expenditure[i + d];
        if (currentDaySum >= median * 2) {
            notifications++;
        }
    }
    return notifications;
}

int main() {
    std::cout << activityNotifications({2, 3, 4, 2, 3, 6, 8, 4, 5}, 5)<<std::endl; //2
    std::cout << activityNotifications({1, 2, 3, 4, 4}, 4) << std::endl;; //4
};
