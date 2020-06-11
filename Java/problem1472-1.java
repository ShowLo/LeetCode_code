class BrowserHistory {
    private Stack<String> backHistory;
    private Stack<String> forwardHistory;

    public BrowserHistory(String homepage) {
        backHistory = new Stack<>();
        backHistory.push(homepage);
        forwardHistory = new Stack<>();
    }
    
    public void visit(String url) {
        backHistory.push(url);
        while (!forwardHistory.empty()) {
            forwardHistory.pop();
        }
    }
    
    public String back(int steps) {
        steps = Math.min(steps, backHistory.size() - 1);
        for (int i = 0; i < steps; ++i) {
            forwardHistory.push(backHistory.pop());
        }
        return backHistory.peek();
    }
    
    public String forward(int steps) {
        steps = Math.min(steps, forwardHistory.size());
        for (int i = 0; i < steps; ++i) {
            backHistory.push(forwardHistory.pop());
        }
        return backHistory.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
