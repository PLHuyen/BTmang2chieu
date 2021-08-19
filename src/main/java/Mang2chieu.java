import java.util.Scanner;

public class Mang2chieu {
    public static void main(String[] args) {

        int[][] a = inputMatrix();

        int max = maxMatrix(a);
        System.out.println("Phần tử lớn nhất trong ma trận = " + max);

        if(isPrimeMatrix(a)){
            System.out.println(" Là số nguyên tố ");
        } else {
            System.out.println(" Không là số nguyên tố");
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số: ");
        int n = sc.nextInt();
        if (checkNumber(a, n)) {
            System.out.format("Có %d trong ma trận.", n);
        } else System.out.format("Không có %d trong ma trận.", n);
        System.out.println();

    }


    public static int[][] inputMatrix() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Số dòng: ");
        int r = scan.nextInt();

        System.out.print("Số cột: ");
        int c = scan.nextInt();

        int[][] ret = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.format("a[%d][%d] = ", i, j);
                ret[i][j] = scan.nextInt();
            }
        }
        return ret;
    }

    // giá trị lớn nhất trong ma trận

    public static int maxMatrix(int[][] a) {
        int max = a[0][0];
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (max < a[i][j]) {
                    max = a[i][j];
                }
            }
        }
        return max;
    }

    // số nguyên tố

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeMatrix(int[][] a) {
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (!isPrime(a[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkNumber(int[][] a, int number) {
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (a[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    // tổng phần tử trên hàng d

    public static int sumRow(int[][] a, int d) {
        int sum = 0;
        for (int i = 0, c = a.length; i < c; i++) {
            sum += a[d - 1][i];
        }
        return sum;
    }

    // tổng phần tử trên cột c

    public static int sumCol(int[][] a, int c) {
        int sum = 0;
        for (int i = 0, r = a[0].length; i < r; i++) {
            sum += a[i][c - 1];
        }
        return sum;
    }

    // tổng các phần tử nằm trên đường chéo chính

    public static void sumMaindiagonal(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length;  i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (i == j) {
                    sum += a[i][j];
                }
            }
        }
    }

    // tổng các phần tử nằm trên đường chéo phụ

    public static void sumAuxiliarydiagonal(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length;  i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (i + j == a.length - 1) {
                    sum += a[i][j];
                }
            }
        }
    }

    // tổng nửa trên đường chéo chính

    public static void sumHalfabovemaindiagonal(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (j > i) {
                    sum += a[i][j];
                }
            }
        }
    }

    // tổng nửa dưới đường chéo chính

    public static void sumHalfUnderneathMainDiagonal(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (i > j) {
                    sum += a[i][j];
                }
            }
        }
    }

    // tổng nửa trên đường chéo phụ

    public static void sumAboveAuxiliaryDiagonal(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c - 1 - i; j++) {
                sum += a[i][j];
            }
        }
    }

    // tổng nửa dưới đường chéo phụ

    public static void sumBelowAuxiliaryDiagonal(int[][] a, int row) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = a[0].length - i; j < a[0].length; j++) {
                sum += a[i][j];
            }
        }
    }
}
