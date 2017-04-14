public void selectSort() {
        for (int i = 0; i < sizeofarray; i++) {
            for (int j = 0; j < sizeofarray - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    long temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }

            }

        }
    }