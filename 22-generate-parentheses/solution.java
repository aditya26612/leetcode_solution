// 2 ms | 44 MB
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(result, "", 0, 0, n);

        return result;
    }

    private void backtrack(
        List<String> result,
        String current,
        int open,
        int close,
        int n
    ) {
        // We have used all n pairs
        if (open == n && close == n) {
            result.add(current);
            return;
        }

        // We can still add an opening bracket
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }

        // We can add ')' only if there is an unmatched '('
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
}