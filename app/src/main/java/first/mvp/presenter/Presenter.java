package first.mvp.presenter;

/**
 * Created by ezequiel.garcia on 8/15/16.
 */
public interface Presenter <V>{
    void setView(V view);
    void detachView();
}
