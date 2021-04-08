package leetcode;

public class FlipAndInvertImage {
/**    给定一个二进制矩阵A，我们想先水平翻转图像，然后反转图像并返回结果。

    水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转[1, 1, 0]的结果是[0, 1, 1]。

    反转图片的意思是图片中的0全部被1替换，1全部被0替换。例如，反转[0, 1, 1]的结果是[1, 0, 0]。
            1 <= A.length = A[0].length <= 20
            0 <= A[i][j] <= 1
 */
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                if (image[i][left] == image[i][right]) {
                    image[i][left] ^= 1;
                    image[i][right] ^= 1;
                }
                left++;
                right--;
            }
            if (left == right) {
                image[i][left] ^= 1;
            }

        }
        return image;
    }
}
