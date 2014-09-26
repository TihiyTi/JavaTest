package com.tihiy.mvc.abs;

public interface AddOnModelInterface<T> {
    public void prepareState(T dataForState);
    public Object getState();
}
