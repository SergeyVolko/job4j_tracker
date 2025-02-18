package lambda.task4;

import lambda.task1.Attachment;
import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getSize() - right.getSize();
            }
        };
        Arrays.sort(atts, comparator);
        /**
         * Решение описать текстом.
         */
        Comparator<String> cmpText  = (left, right) -> left.compareTo(right);
        Comparator<String> cmpDescSize  = (left, right) ->
                Integer.compare(right.length(), left.length());
    }
}

