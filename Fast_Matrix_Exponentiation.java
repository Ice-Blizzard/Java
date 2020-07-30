
public class Fast_Matrix_Exponentiation {

  static int [][] multipling(int [][] a, int [][] b) {

    int n = a[0].length;
    int [][] c = new int [n][n];

    for (int i = 0; i < n; i++)  {	
      for (int j = 0; j < n; j++) {

        c[i][j] = 0;

        for (int k = 0; k < n; k++) {
          c[i][j] = c[i][j] + (a[i][k] * b[k][j]);
        }
      }
    }

    return c;
  }

  static int[][] fast_matrix_exponentiation(int [][] e, int k) {

    int n = e[0].length;

    if (k == 0) {
      int [][] c = new int [n][n];

      for (int i = 0; i < n; i++)  {	
        for (int j = 0; j < n; j++) {

          if (i == j) {
            c[i][j] = 1;
          }

          else {
            c[i][j] = 0;
          }
        }
      }

    return c;
    }

    else {
      if (k == 1) {
        return e;
      }
      else {

        if (k % 2 == 0)
          return multipling(fast_matrix_exponentiation(e, (k/2)),
            fast_matrix_exponentiation(e, (k/2)));

        else
          return multipling(fast_matrix_exponentiation(e, (k-1)),
            fast_matrix_exponentiation(e, 1));
      }
    }
  }

  public static void main(String[] args) {
  
    int[][] test = {{0}};
    int k = 0;

    int n = test[0].length;
    int[][] output = fast_matrix_exponentiation(test, k);

    for (int i = 0; i < n; i++)  {	
      for (int j = 0; j < n; j++) {
        System.out.print(output[i][j] + " ");
      }

      System.out.print("\n");
    }  
  }
}
