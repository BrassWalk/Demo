package practice.problems.interviews.amazon;


class RectangleResponse {

    final int i;
    final int j;
    final int area;

    RectangleResponse(
            final int i,
            final int j,
            final int area) {
        this.i = i;
        this.j = j;
        this.area = area;
    }

    public String toString() {
        return "[" + i + ", " + j + ", " + area + "]";
    }
}

public class LargestRectangleInArray {

    public RectangleResponse getLargestRectangle(final int[] array) {
        int i = 0;
        int j = array.length - 1;

        RectangleResponse maxRectangleResponse = new RectangleResponse(i, j, 0);

        while (i < j) {
            final int area = getArea(array, i, j);

            if (area > maxRectangleResponse.area) {
                maxRectangleResponse = new RectangleResponse(i, j, area);
            }

            i++;
            j--;
        }

        return maxRectangleResponse;
    }

    private int getArea(
            final int[] array,
            final int i,
            final int j) {
        final int distance = j - i;
        final int height = Math.min(array[i], array[j]);
        return distance * height;
    }
}
