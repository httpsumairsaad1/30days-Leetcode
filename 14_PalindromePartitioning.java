public class Solution {
    public List<List<String>> partition(String str) {
        List<List<String>> partitions = new ArrayList<>();
        generatePartitions(str, 0, new ArrayList<>(), partitions);
        return partitions;
    }

    private void generatePartitions(String str, int index, List<String> currentPartition, List<List<String>> partitions) {
        if (index == str.length()) {
            partitions.add(new ArrayList<>(currentPartition));
            return;
        }
        for (int i = index + 1; i <= str.length(); i++) {
            if (isPalindrome(str, index, i - 1)) {
                currentPartition.add(str.substring(index, i));
                generatePartitions(str, i, currentPartition, partitions);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
