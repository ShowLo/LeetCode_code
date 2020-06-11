class BrowserHistory {
    private int idx;
    private List<String> history;

    public BrowserHistory(String homepage) {
        idx = 0;
        history = new ArrayList<>();
        history.add(homepage);
    }
    
    public void visit(String url) {
        int size = history.size();
        int removeCount = size - idx - 1;
        for (int i = 0; i < removeCount; ++i) {
            history.remove(size - 1 - i);
        }
        history.add(url);
        ++idx;
    }
    
    public String back(int steps) {
        idx = Math.max(0, idx - steps);
        return history.get(idx);
    }
    
    public String forward(int steps) {
        idx = Math.min(idx + steps, history.size() - 1);
        return history.get(idx);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
