 void insertSort() {
        {
              int in, out;
              for (out = 1; out < sizeofarray; out++) {
                  long temp = A[out];
                 in = out;
                  while (in > 0 && A[in - 1] >= temp) {
                      A[in] = A[in - 1];
                      --in;
                 }
               A[in] = temp;
              }
         }
    }
