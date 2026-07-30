class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];

        if (startColor == color) {
            return image;
        }

        dfs(image, sr, sc, startColor, color);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int startColor, int color) {
        int x = sr;
        int y = sc;

        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
            return;
        }
        if (image[x][y] != startColor) {
            return;
        }

        image[x][y] = color;
        dfs(image, x - 1, y, startColor, color);
        dfs(image, x + 1, y, startColor, color);
        dfs(image, x, y - 1, startColor, color);
        dfs(image, x, y + 1, startColor, color);

        return;
    }
}