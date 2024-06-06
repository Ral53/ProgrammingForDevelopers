package Backtracking;

public class Permutation {
    private int count = 0; // Class-level variable to keep track of the number of permutations

    void findPermutation(String str, String perm) {
        if (str.length() == 0) {
            System.out.println(perm);
            count++;
            return;
        }

        // If perm has more than one character and the second character is not 'B', skip further processing
        if (perm.length() > 1) {
            if (perm.charAt(1) != 'B') {
                return;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char newChar = str.charAt(i);
            String newStr =  str.substring(0, i) + str.substring(i + 1);
            findPermutation(newStr, perm + newChar);
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Permutation perm = new Permutation();
        perm.findPermutation("ABC", "");
        System.out.println("Total permutations: " + perm.getCount());
    }
}
